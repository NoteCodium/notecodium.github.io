

![image.png](../images/1f930993-2789-4151-a75b-e4bb5e1ca8e6--image.png)

![image.png](../images/e9bfb352-d23e-43b1-9b75-7aba21773715--image.png)

# Minor diagonal traversal
```cpp
for(int d=0;d<n;d++){
  int r=0,c=d;
  while(c>=0){
    r++;
    c--;
  }
}

for(int d=1;d<n;d++){
  int r=d,c=n-1;
  while(r<n){

    r++;
    c--;
  }
}
```
![image.png](../images/662b5adc-9b9a-4980-9f41-6351461b3c2c--image.png)
