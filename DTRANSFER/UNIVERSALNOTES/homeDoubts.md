---
title: homeDoubts
---

{% raw %}
```python
        //Using the famous syntax here
        Runnable task=null;       
        try {
            task=taskQueue.take();
            task.run();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            // e.printStackTrace();
        }
```

```python
package concurrencyRefractored.NEW.ThreadPool.customthreadpool;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

// @RequiredArgsConstructor
@AllArgsConstructor
public class ThreadPool {
    private final int noOfThreads;
    private final List<Thread> threads;
    private final BlockingQueue<Runnable> tasksQueue;
    private final Set<Integer> deadThreads; //
    private boolean isShutDownInitiated;
    private int yetToTerminateCnt;

    //Constructor overloading
    public ThreadPool(){
        tasksQueue=new ArrayBlockingQueue<>(10);
    }


}
```

text in whatsapp
{% endraw %}
