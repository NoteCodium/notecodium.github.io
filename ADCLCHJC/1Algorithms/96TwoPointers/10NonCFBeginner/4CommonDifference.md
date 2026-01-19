```python
int l=0,h=1;
while(h<n){
    int dif=v[h]-v[l];
    if(dif==k){

    }
    else if(dif<k){
        h++;
    }
    else{
      l++;
      if(l==h){
        h++;
      }              
    }
}
```

Barclays Chemist  
Make abs dif between a pair of elements as close to k    
abs(v[i]-v[j]) ~ k   
if there are more then one pair, select the one with maximum sum  
Return the sum of that pair


```python
int check=INT_MAX;
int ans=INT_MIN;
int l=0,h=1;
while(h<n){
    int dif=v[h]-v[l];
    //it will be always positive
    int sum=v[l]+v[h];
    if(dif==k){
        ans=max(ans,sum);
        //A little doubt
        l++;
        h++;
    }
    else if(dif<k){
        h++;
    }
    else{
      l++;
      if(l==h){
        h++;
      }              
    }

    //the general solution if we not get dif exactly k
    if(check>abs(dif-k)){
        ans=max(ans,sum);
        check=abs(dif-k);
    }

}
```

![image.png](4CommonDifference_images/image.png)

