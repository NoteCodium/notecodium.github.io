return all unique triplets  
st: a+b+c==k


```python
for(int i=0;i<n;i++){
    if(i>0 and v[i]==v[i-1]){
        continue;
    }
    int rem=k-v[i];
    int l=i+1, h=n-1;
    while(l<h){
        int sum=v[l]+v[h];
        if(sum==k){
            int p=v[l],q=v[h];
            if(p==q){
                break;
            }
            while(l<n and v[l]==p){
                l++;
            }
            while(h>=0 and v[h]==q){
                h--;
            }
    
        }
        else if(sum>k){
            h--;
        }
        else{
            l++;
        }
    }
}
```

three sum closest  
find 3 integers st the sum is closest to k  
return the sum


```python
int dif=INT_MAX;
int ans;
for(int i=0;i<n;i++){
    if(i>0 and v[i]==v[i-1]){
        continue;
    }
    int rem=k-v[i];
    int l=i+1, h=n-1;
    while(l<h){
        int sum=v[l]+v[h];
        if(sum==rem){
            return k;
        }
        if(dif<abs(k-(v[i]+v[l]+v[h]))){
            ans=v[i]+v[l]+v[h];
            dif=abs(k-(v[i]+v[l]+v[h]));
        }

        if(sum>rem){
            h--;
        }
        else{
            l++;
        }
    }
}
```

4sum


```python
for(int i=0;i<n;i++){
    if(i>0 and v[i]==v[i-1]){
        continue;
    }
    for(int j=i+1;j<n;j++){
        if(j>i+1 and v[j]==v[j-1]){
            continue;
        }
        int rem=(ll)k-(v[i]+v[j]);
        int l=j+1, h=n-1;
        while(l<h){
            int sum=v[l]+v[h];
            if(sum==k){
                int p=v[l],q=v[h];
                if(p==q){
                    break;
                }
                while(l<n and v[l]==p){
                    l++;
                }
                while(h>=0 and v[h]==q){
                    h--;
                }
        
            }
            else if(sum>k){
                h--;
            }
            else{
                l++;
            }
        }
    }
}
```
