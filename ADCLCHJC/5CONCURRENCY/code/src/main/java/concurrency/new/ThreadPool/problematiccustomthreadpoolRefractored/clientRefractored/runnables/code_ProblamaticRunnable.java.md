---
layout: default
title: ProblamaticRunnable.java
---

```java
{% raw %}
package concurrencyrefractored.NEW.ThreadPool.problematiccustomthreadpoolRefractored.clientRefractored.runnables;

public class ProblamaticRunnable implements Runnable{

    @Override
    public void run() {
        throw new RuntimeException("Problematic Runnable");
    }
    
}

{% endraw %}
```
