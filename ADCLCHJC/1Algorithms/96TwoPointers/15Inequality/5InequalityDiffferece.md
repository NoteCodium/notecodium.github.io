![image.png](5InequalityDiffferece_images/image.png)


```python
int l=0,h=1;
int ans=0;
while(h<n){
    if(v[h]-v[l]<k){
        ans+=(h-l);// all elements excluding v[l] alone
        h++;
    }
    else{
        l++;
    }
}
```

https://www.youtube.com/watch?v=LZDgz0xKIpg


![image.png](5InequalityDiffferece_images/image.png)


pairwise distinct make it further tough


let the difference bw 3


![image.png](5InequalityDiffferece_images/image.png)


ans1     
![image.png](5InequalityDiffferece_images/image.png)


similarly    
![image.png](5InequalityDiffferece_images/image.png)


continued n sliding window

