# Controller vs RestController

@Controller is a Spring MVC annotation

t’s typically used in traditional web applications to serve HTML content.

By default, methods in a @Controller return views (e.g., HTML, JSP pages)

5. view resolvers to render the content.
    1. example: a view named home (like home.html or home.jsp).

If a method in a @Controller is intended to return a JSON or XML response, you need to use the @ResponseBody annotation on the method, which tells Spring to write the return value directly to the HTTP response body instead of resolving a view.

```
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/page")
    public String getPage() {
        return "home";  // This would return a view named "home"
    }
}
```

![image.png](/images/image-107.png)





# RestController





