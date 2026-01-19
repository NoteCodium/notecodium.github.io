---
layout: default
title: Worker.java
---

```java
{% raw %}
package code.src.main.java.concurrency.threads.numberstore1;

public class Worker implements Runnable{

    private final NumberStore numberStore;
    public Worker(NumberStore numberStore){
        this.numberStore=numberStore;
    }

    @Override
    public void run() {
        for(int i=0;i<1000000;i++){
            numberStore.increment();
        }
    }

}
{% endraw %}
```
