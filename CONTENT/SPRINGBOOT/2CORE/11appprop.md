![image.png](/images/image-143.png)

Theory

Why ev?

1. A long process after every code change
    1. Testing
    2. Creating docker image
2. To hide some data
3. Can be changed by non technical people
    1. for business needs, ex: delivery provider for ecomerce 

# How to pass it through terminal?

![image.png](/images/image-163.png)

![image.png](/images/image-164.png)

> Doubt

![image.png](/images/image-165.png)

![image.png](/images/image-166.png)

```
@SpringBootApplication
public class EV implements ApplicationRunner {
        @Value("${fname}")
        private String fname;

        public static void main(String[] args) {
            SpringApplication.run(EV.class, args);
        }

        public void run(ApplicationArguments args) {
            System.out.println(fname);
        }
}
```

> How this GUI differs from above

![image.png](/images/image-167.png)





- ![image.png](/images/image-168.png)

![image.png](/images/image-169.png)

![image.png](/images/image-170.png)





