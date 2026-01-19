---
layout: default
title: UpperCaseDecorator.java
---

```java
{% raw %}
package code.src.main.java.lld.examples.CLASSIFICATION.decoratorRefractor.textwriter;

public class UpperCaseDecorator implements WriteDecorator{

    public UpperCaseDecorator(Writer writer){
       super(writer);
    }

    @Override
    public void write(String text) {
        text=text.toUpperCase();
        super.write(text);
    }
    
}

{% endraw %}
```
