[](https://leetcode.com/problems/koko-eating-bananas/description/)

Predicate function is tough




```cpp
bool f(int banPerHour, vector<int>& v, int h){
    
}

int minEatingSpeed(vector<int>& v, int h) {
    // b0 b1 b2 b3 b4 
    int n=v.size();
    if(n>h) return -1;
    int h=*max_element(v.begin(),v.end());
    int l=1;
    int ans=-1;
    while(l<=h){
        int m=(l+h)/2;
        if(f(m,v,h)){
            ans=m;
            h=m-1;
        }
        else l=m+1;
    } 
}
```

```cpp
bool f(int banPerHour, vector<int>& v, long h,int n){
    long timeTaken=0;
    for(long x: v) timeTaken+=ceil(1.0*x/banPerHour);
    return timeTaken<=h;
}
```