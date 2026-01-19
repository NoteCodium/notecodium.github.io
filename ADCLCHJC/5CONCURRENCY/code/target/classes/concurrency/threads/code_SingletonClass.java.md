---
layout: default
title: SingletonClass.java
---

```java
{% raw %}
package code.src.main.java.concurrency.threads;
public class SingletonClass {
    private static SingletonClass singletonClass=null;
    private SingletonClass(){}
    public static SingletonClass getSingletonClass(){
        if(singletonClass==null){
            singletonClass=new SingletonClass();
        }
        return singletonClass;
    }
}

{% endraw %}
```
