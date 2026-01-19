---
layout: default
title: DAmericanoIngredientFactory.java
---

```java
{% raw %}
package code.src.main.java.lld.examples.CLASSIFICATION.statecode.cofeemachine;

public class DAmericanoIngredientFactory implements DIngredientFactory {
    @Override
    public DBean getBean(){
        return new DAmericanBean();
    }

}

{% endraw %}
```
