---
title: summary
---

{% raw %}
1. builder  
2. decorator (doubt)  
3. factory   (Static methods which return objects with new)
4. singleton  (constructor is private, static method to get instance only one time)
5. strategy


do the missing from copy

1. observerRefractor
2. State

```python
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
```
{% endraw %}
