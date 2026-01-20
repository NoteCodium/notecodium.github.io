```java
class Solution {
    public int singleNumber(int[] v) {
        List<Integer> noDuplicateList=
            new ArrayList<>();

        for(int x: v){
            if(!noDuplicateList.contains(x)){
                noDuplicateList.add(x);
            }
            else{
                //this is important
                //as remove is overloaded .remove(idx) .remove.(Integer.valueOf(elem))
                //this can be confusing 
                noDuplicateList.remove(Integer.valueOf(x));
            }
        }
        
        return noDuplicateList.get(0);
    }
}
```

```cpp
class Solution {
    public int singleNumber(int[] v) {
        Map<Integer,Integer> hashMap=
            new HashMap<>();
        
        for(int x: v){
            hashMap.put(x,hashMap.getOrDefault(x, 0)+1);
        }

        for(var pair: hashMap.entrySet()){
            Integer value=pair.getValue();
            if(value==1){
                return pair.getKey();
            }
        }   
        
        return -1;
    }
}
```

```cpp
class Solution {
    public int singleNumber(int[] v) {
        Set<Integer> set =
             Arrays
                .stream(v)
                .boxed()
                .collect(Collectors.toSet());
        
        int sumOfSet=0,sumOfNum=0;
        for(int x: set){
            sumOfSet+=x;
        }
        for(int x: v){
            sumOfNum+=x;
        }

        return 2*sumOfSet - sumOfNum;
        
    }
}
```