In Spring, both @Bean and @Component are used to define and register objects (called "beans") in the Spring IoC (Inversion of Control) container.

Method-level annotation

1. It's typically used within a @Configuration class.
2. To explicitly declare a single bean that Spring should manage. The method annotated with @Bean is responsible for creating and returning the object that will be registered as a bean in the Spring container.
3. Control over Instantiation: More control. You write the logic inside the @Bean method to create and configure the object. 
    1. This allows for complex initialization
        1. When the creation of a bean involves more than a simple new keyword, such as setting multiple properties programmatically, calling factory methods, or conditional logic.? 
    2. conditional bean creation?, 
    3. or creating beans from classes whose source code you don't control. (PPA)
4. Third-party Libraries: When you need to configure and expose an object from a third-party library as a Spring bean (because you can't add @Component to its source code).
5. Complex Initialization: Multiple Instances of the Same Class: If you need multiple beans of the same class type, each configured differently.?

![image.png](/images/image-98.png)

![image.png](/images/image-100.png)

![image.png](/images/image-105.png)

# Bean Lifecycle Hooks

![image.png](/images/image-144.png)

![image.png](/images/image-145.png)





![image.png](/images/image-147.png)



# Scope of the bean is by deault singleton