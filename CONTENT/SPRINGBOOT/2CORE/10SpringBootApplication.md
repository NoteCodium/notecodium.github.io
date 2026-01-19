main thread dies and application server thread keeps on

```
ApplicationContext appliationContext=
    SpringApplication.run(ServerApplication.class, args);
```

```
for(String bean: appliationContext.getBeanDefinitionNames()){
    sout(bean);
}
```

```
Object object
=appliationContext.getBean("lifecycleProcessor");
sout(object.getClass().getName());

```

```
@SpringBootApplication
public class OneApplication {
	public static void main(String[] args) {
		SpringApplication.run(OneApplication.class, args);
		//.class something to do with reflection
			
		}
}
```

![image.png](/images/image-295.png)

NameOfProject+Application is the Main class name

1. NameOfProject
    1. src
        1. main
            1. java
                1. org.example.one



> 2. When spring loads it, it sends some events
>
>    (Doubt some thing regarding it is discussed in inventory management)