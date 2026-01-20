```cpp
int f(vector<int>& v, int k){
    int n=v.size();
    int l=0,h=0,cnt=0,ans=0;
    while(h<n){
        //sum+=v[h]; 
        //change the property
            if(v[h]%2) cnt++;
            while(cnt>k and l<h){
            //this is not the condition of answer
            if(v[l]%2) cnt--;
            l++;
        }
        if(cnt<=k) ans+=(h-l+1); 
        h++;  
    }
    return ans;
}
```
