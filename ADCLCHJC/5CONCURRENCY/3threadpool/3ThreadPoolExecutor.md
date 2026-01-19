


![image-2.png](3ThreadPoolExecutor_images/image-2.png)


![image.png](3ThreadPoolExecutor_images/image.png)


![image.png](3ThreadPoolExecutor_images/image.png)


```python
ExecutorService executorService= Executors.newFixedThreadPool(5);
```

![image.png](3ThreadPoolExecutor_images/image.png)


```python
ThreadPoolExecutor threadPoolExecutor=
    new ThreadPoolExecutor(
        4,
        6,
        2,
        TimeUnit.SECONDS,
        new ArrayBlockingQueue<>(10)
    );
```

if there are more then 16 tasks in quick time, it will face difficulty


![image.png](3ThreadPoolExecutor_images/image.png)


# threadFactory

Mainly concerned with naming of threads


![image.png](3ThreadPoolExecutor_images/image.png)


![image.png](3ThreadPoolExecutor_images/image.png)

