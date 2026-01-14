![image.png](/images/image-204.png)

```
@Component
public class InterceptorConfig implements WebMvcConfigurer{
    @Autowired
    MC1 mc1;

    @Autowired
    MC2 mc2;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(mc1).addPathPatterns("/greet");;
        registry.addInterceptor(mc2).addPathPatterns("/greet");
    }
}
```

if no pattern is added, then it will always be triggered



# MC1 

```
@Component
public class MC1 implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("MC1 preHandle");
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("MC1 postHandle");
    }
}
```

![image.png](/images/image-205.png)