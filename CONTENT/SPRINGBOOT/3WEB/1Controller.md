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



![image.png](/images/image-150.png)

# RestController

1. building RESTful web services.
2. It’s designed for APIs that return JSON, XML, or other content types, and does not attempt to resolve views.



![image.png](/images/image-152.png)





![image.png](/images/image-151.png)

![image.png](/images/image-153.png)

![image.png](/images/image-154.png)

![image.png](/images/image-155.png)

By default we are sending json, to send XML

```
<dependency>
    <groupId> com.fasterxml.jackson.dataformat</groupId>
    <artifactId>jackson-dataformat-xml</artifactId>
</dependency>
```