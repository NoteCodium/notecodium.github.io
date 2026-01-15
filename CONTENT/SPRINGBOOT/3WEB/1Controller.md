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

![image.png](/images/image-226.png)

![image.png](/images/image-151.png)

![image.png](/images/image-227.png)

![image.png](/images/image-228.png)

GetMappig is also a RequestMapping 







![image.png](/images/image-153.png)

---

# (RequestParam/QueryParam) vs (PathVariable/RequestPath)

Param is optional

Path is non optional and more readable urls make sense

# vs RequestBody

RequestParam/QueryParam

For optional fields (like amazon filters)

1. sort

### But actually, 

![image.png](/images/image-197.png)

![image.png](/images/image-199.png)

![image.png](/images/image-198.png)

whitespace are +?

See google search uth

This part I am week in 



### Typecasting custom object type like date 

1. using a registerd PropertyEditor







# (PathVariable/RequestPath)

![image.png](/images/image-200.png)

# RequestBody

---

![image.png](/images/image-154.png)

![image.png](/images/image-155.png)

```
public class ExamResult {
    private int phy;
    private int chem;
    private int math;

    public int getChem() {
        return chem;
    }

    public int getMath() {
        return math;
    }


    public int getPhy() {
        return phy;
    }
    public ExamResult(int phy, int chem, int math) {
        this.phy = phy;
        this.chem = chem;
        this.math = math;
    }
}
```

![image.png](/images/image-179.png)

![image.png](/images/image-180.png)

![image.png](/images/image-181.png)

By default we are sending json, to send XML

![image.png](/images/image-201.png)

```
<dependency>
    <groupId> com.fasterxml.jackson.dataformat</groupId>
    <artifactId>jackson-dataformat-xml</artifactId>
</dependency>
```

# Update (I already knew this so easy). Patch difficult as I get to know about later

Update

whole data

> See how ModelMapper works, see old codebases in github

```
    public EmployeeDto updateEmployee(Long employeeID, EmployeeDto employeeDto) {
        EmployeeEntity toUpdateEntity=modelMapper.map(employeeDto, EmployeeEntity.class);
        toUpdateEntity.setId(employeeID);//doubt
        EmployeeEntity updatedEntity=employeeRepository.save(toUpdateEntity);
        //Automagically find the employee by id and update it
        return modelMapper.map(updatedEntity, EmployeeDto.class);
    }

    @PutMapping("/{employeeID}")
    public EmployeeDto updateEmployee(@PathVariable Long employeeID ,@RequestBody EmployeeDto employeeDto){
        return employeeService.updateEmployee(employeeID,employeeDto);
    }
```

Patch

This is why patch implementation is difficult

![image.png](/images/image-224.png)

```
    public EmployeeDto updatePartialEmployee(Long employeeID, Map<String, Object> updates) {
        boolean exists=isExistByEmployeeId(employeeID);
        if (!exists) {
            return null;
        }
        EmployeeEntity employeeEntity=employeeRepository.findById(employeeID).orElse(null);
//        EmployeeEntity employeeEntity=employeeRepository.findById(employeeID).get(); doubt
        updates.forEach((field, value)->{
                    Field fieldToBeUpdated = ReflectionUtils.findRequiredField(EmployeeEntity.class, field);
                    fieldToBeUpdated.setAccessible(true);
                    ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value);
                }
        );
        EmployeeEntity updatedEntity=employeeRepository.save(employeeEntity);
        return modelMapper.map(updatedEntity, EmployeeDto.class);
    }
}


    @PatchMapping("/{employeeID}")
    public EmployeeDto updatePartialEmployee(@PathVariable Long employeeID , @RequestBody Map<String,Object> updates){
        return employeeService.updatePartialEmployee(employeeID,updates);
    }
```