---
layout: default
title: Main.java
---

```java
{% raw %}
package code.src.main.java.concurrency.threads.eventmgmt;

public class Main {
    public static void main(String[] args) {
        EventContainer ec=new EventContainer(new EventTitle(), new EventSyllabus());
        System.out.println(ec.get());
    }
}

{% endraw %}
```
