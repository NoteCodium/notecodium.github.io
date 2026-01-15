![image.png](/images/image-220.png)

```
@GetMapping("/{employeeID}")
public EmployeeDto getEmployee(@PathVariable Long employeeID){
    return employeeService.getEmployeeById(employeeID);
}
```

![image.png](/images/image-221.png)

```
not found have the same status code
```

```
new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);
```

# ResponseEntity<> used at at controller level

```
@GetMapping("/{employeeID}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long employeeID){

        Optional<EmployeeDto> employeeDto= employeeService.getEmployeeById(employeeID);

        return employeeDto
                .map(entry -> ResponseEntity.ok(entry))
                .orElse(ResponseEntity.notFound().build());
    }
```

```
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
```

```
  @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployeeDto= employeeService.addEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);
    }
```

```
ResponseEntity.ok(updatedEmployeeDto);
```

```
new ResponseEntity<>(updatedEmployeeDto, HttpStatus.OK);
```

# builder pattern

![image.png](/images/image-222.png)

# Delete

```
  @DeleteMapping("/{employeeID}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long employeeID){
           boolean gotDeleted= employeeService.deleteEmployee(employeeID);
           if(gotDeleted){
               return ResponseEntity.ok(true);
           }
              return ResponseEntity.notFound().build();
    }
```

![image.png](/images/image-223.png)



# Patch

```
    @PatchMapping("/{employeeID}")
    public ResponseEntity<EmployeeDto> updatePartialEmployee(@PathVariable Long employeeID , @RequestBody Map<String,Object> updates){
        EmployeeDto employeeDto= employeeService.updatePartialEmployee(employeeID,updates);
        if(employeeDto==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employeeDto);
    }
```



# Put





