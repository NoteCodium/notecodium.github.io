const CACHE_NAME = 'notecodium-cache-v1';
const DATA_CACHE_NAME = 'notecodium-data-v1';

// Install Event
self.addEventListener('install', (event) => {
    // Skip waiting to ensure the new service worker takes over immediately
    self.skipWaiting();
    console.log('[Service Worker] Installed');
});

// Activate Event
self.addEventListener('activate', (event) => {
    console.log('[Service Worker] Activated');
    event.waitUntil(
        caches.keys().then((keyList) => {
            return Promise.all(keyList.map((key) => {
                if (key !== CACHE_NAME && key !== DATA_CACHE_NAME) {
                    console.log('[Service Worker] Removing old cache', key);
                    return caches.delete(key);
                }
            }));
        })
    );
    // Claim clients to immediately control open pages
    return self.clients.claim();
});

// Fetch Event
self.addEventListener('fetch', (event) => {
    // 1. Navigation requests (HTML pages) - Network First, fallback to Cache
    if (event.request.mode === 'navigate') {
        event.respondWith(
            fetch(event.request)
                .then((networkResponse) => {
                    return caches.open(DATA_CACHE_NAME).then((cache) => {
                        cache.put(event.request, networkResponse.clone());
                        return networkResponse;
                    });
                })
                .catch(() => {
                    return caches.match(event.request);
                })
        );
        return;
    }

    // 2. Static Assets (CSS, JS, Images within the app) - Stale-While-Revalidate
    // If we have it in cache, serve it. Update it in background.
    event.respondWith(
        caches.match(event.request).then((cachedResponse) => {
            const fetchPromise = fetch(event.request).then((networkResponse) => {
                if (networkResponse && networkResponse.status === 200 && networkResponse.type === 'basic') {
                    caches.open(DATA_CACHE_NAME).then((cache) => {
                        cache.put(event.request, networkResponse.clone());
                    });
                }
                return networkResponse;
            }).catch(err => {
                // Network failed, nothing to do if we have cached response
            });

            return cachedResponse || fetchPromise;
        })
    );
});

// Message Handler (The "Sync" Logic)
self.addEventListener('message', (event) => {
    if (event.data && event.data.type === 'PRECACHE_ALL') {
        const urlsToCache = event.data.urls;
        console.log('[Service Worker] Precaching', urlsToCache.length, 'files...');

        // Notify client of start
        broadcast({ type: 'SYNC_START', count: urlsToCache.length });

        event.waitUntil(
            caches.open(DATA_CACHE_NAME).then(async (cache) => {
                let cachedCount = 0;
                const total = urlsToCache.length;

                // Batch requests to avoid choking the network
                const batchSize = 10;
                for (let i = 0; i < total; i += batchSize) {
                    const batch = urlsToCache.slice(i, i + batchSize);
                    await Promise.all(batch.map(url => {
                        return fetch(url).then(response => {
                            if (response.ok) {
                                return cache.put(url, response);
                            }
                        }).catch(err => console.error('Failed to cache:', url, err));
                    }));

                    cachedCount += batch.length;
                    // Notify client of progress
                    broadcast({ type: 'SYNC_PROGRESS', current: Math.min(cachedCount, total), total: total });
                }

                console.log('[Service Worker] Precache complete');
                broadcast({ type: 'SYNC_COMPLETE' });
            })
        );
    }

    if (event.data && event.data.type === 'CLEAR_CACHE') {
        caches.delete(DATA_CACHE_NAME).then(() => {
            console.log('[Service Worker] Cache cleared');
            broadcast({ type: 'CACHE_CLEARED' });
        });
    }
});

function broadcast(message) {
    self.clients.matchAll().then(clients => {
        clients.forEach(client => client.postMessage(message));
    });
}
