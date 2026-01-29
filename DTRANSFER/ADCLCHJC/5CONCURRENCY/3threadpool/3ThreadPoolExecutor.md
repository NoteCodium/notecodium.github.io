---
title: 3ThreadPoolExecutor
---

{% raw %}
![image-2.png](/transfernew/notebook_images/transfernew_ADCLCHJC_5CONCURRENCY_3threadpool_3ThreadPoolExecutor__att_0001.png)

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_5CONCURRENCY_3threadpool_3ThreadPoolExecutor__att_0003.png)

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_5CONCURRENCY_3threadpool_3ThreadPoolExecutor__att_0004.png)

```python
ExecutorService executorService= Executors.newFixedThreadPool(5);
```

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_5CONCURRENCY_3threadpool_3ThreadPoolExecutor__att_0005.png)

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

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_5CONCURRENCY_3threadpool_3ThreadPoolExecutor__att_0006.png)

# threadFactory

Mainly concerned with naming of threads

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_5CONCURRENCY_3threadpool_3ThreadPoolExecutor__att_0007.png)

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_5CONCURRENCY_3threadpool_3ThreadPoolExecutor__att_0008.png)
{% endraw %}
