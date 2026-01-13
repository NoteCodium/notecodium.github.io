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