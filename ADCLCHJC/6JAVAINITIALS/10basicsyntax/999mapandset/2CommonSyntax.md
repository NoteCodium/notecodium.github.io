# INIT


```python
Set<Integer> set= 
    Set.of(1,2,3,4,5,6,7,8,9,10);
```

```python
//set
Set<Integer> set= 
    new HashSet<>(placeholder);
//this is wrong
```

```python
placeholder
    1. primitive array ❌
    2. collection, such as a List<Integer> ✅
```

but


```python
//this still wont work
int[] arr1 = {1, 2, 3, 4, 5};
Set<Integer> set1 = new HashSet<>(Arrays.asList(arr1));
```

```python
//even this do not work
int[] arr1 = {1, 2, 3, 4, 5};
List<Integer> list1 = Arrays.asList(arr1);
```

```python
//this works
Integer[] arr2 = {1, 2, 3, 4, 5};
List<Integer> list2 = Arrays.asList(arr2);

```

```python
//this will work
Integer[] arr2 = {1, 2, 3, 4, 5};
Set<Integer> set1 = new HashSet<>(Arrays.asList(arr2));
```

```python
//map
Map<Integer, String> fizzBuzzDict =
new HashMap<>() {
    {
        put(3, "Fizz");
        put(5, "Buzz");
    }
};
```

# add and remove


# PUT GET


```python
//row[r]++;
row.put(r, row.getOrDefault(r,0)+1);
```
