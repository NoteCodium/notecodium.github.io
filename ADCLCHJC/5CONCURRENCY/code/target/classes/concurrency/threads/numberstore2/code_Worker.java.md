---
layout: default
title: Worker.java
---

```java
{% raw %}
package code.src.main.java.concurrency.threads.numberstore2;

public class Worker implements Runnable{

    private final NumberStore numberStore;
    public Worker(NumberStore numberStore){
        this.numberStore=numberStore;
    }

    @Override
    public void run() {
        numberStore.increment();
    }

}
{% endraw %}
```
