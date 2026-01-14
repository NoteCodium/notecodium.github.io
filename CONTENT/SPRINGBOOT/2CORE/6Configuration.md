![image.png](/images/image-106.png)

PPA



This is a popular used many where

```
@Configuration
public class MapperConfig {
    @Bean
    //factory method
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
```