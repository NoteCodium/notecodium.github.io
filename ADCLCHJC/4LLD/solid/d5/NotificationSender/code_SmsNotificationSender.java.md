---
layout: default
title: SmsNotificationSender.java
---

```java
{% raw %}
package LLD.solid.d5.NotificationSender;

public class SmsNotificationSender implements NotificationSender {
    @Override
    public void sendNotification(int productId, int customerId) {
        System.out.println("Sending SMS notification");
    }
    
}

{% endraw %}
```
