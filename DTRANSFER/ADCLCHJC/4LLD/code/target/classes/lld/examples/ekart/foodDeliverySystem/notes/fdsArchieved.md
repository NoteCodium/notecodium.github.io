---
title: fdsArchieved
---

{% raw %}
#requirements
## User should
### search
#### foodName

#### restaurantName

            filter(veg,non-veg)
            cuisine types
            set of cuisine (italian + german)

![{FE39D228-B39D-4BD6-B3EF-DCD074EDFB71}.png](/transfernew/notebook_images/transfernew_ADCLCHJC_4LLD_code_target_classes_lld_examples_ekart_foodDeliverySystem_notes_fdsArchieved__att_0001.png)


There will be both restaurant and dishes in result

1. for the fetched food items, user should be able to navigate to corresponding  restaurant

**food item will have a restId, so we will have getRestById**

# Restaurant
1. menu  \

\\
update\
cost
availibility\


\\\
2. open close time of restaurant

# Register Restaurant
admin aprooval needed

# Menu
add items to cart

**add2Cart(userToken, foodItemId)**

# Cart
1. cart cannot have dishes from different restaurants
2. add/ remove items
3. change quantities

**Order placeOrder(userToken, paymentMode, paymentInfo)**  
reasoning of why we are not sending User  
can be figured out from userID  
will have a db which will contain orders in his cart  
  
We can cross check paymentInfo and price total of the cart value

# Payment

(concept of inheritance)
1. netbanking
2. card based

# User
1. delivery address
2. phone number

# After order
1. track order status   
    ORDER_PLACED   
    CANCELLED   
    (only of cooking has not started)
    COOKING   
    READY_FOR_DELIVERY   
    OUT_FOR_DELIVERY   
    DELIVERED   

These will be changed by the admin of the restaurant, once the order has been placed, an order id is created and sent to him  
Only a delivery guy can change the status to delivered   

tHERE will always be a logical flow of states, one state can not be directly changed to other  

only customer can canell the order  


    
2. ETA

**updateOrder(orderId, status, userToken)**

we will keep on changing the status

# After Delivery
rating \
feedback \

# Intresting
1. coupon code
2. notifications
{% endraw %}
