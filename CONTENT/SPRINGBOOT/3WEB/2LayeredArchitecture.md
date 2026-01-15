![image.png](/images/image-149.png)

![image.png](/images/image-187.png)

1. separation of concerns
2. Resuability
3. Testability
4. Scalibility

```
  @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployeeDto= employeeService.addEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);
    }
```

Controler wil interact with service

service will interact with db