---
layout: default
title: CartItem.java
---

```java
{% raw %}
package code.src.main.java.lld.examples.ekart.foodDeliverySystem.data;

import lombok.Data;

@Data
public class CartItem {
    private final FoodItem foodItem;
    private final int quantity;
}

{% endraw %}
```
