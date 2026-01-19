Floor of x is the largest element which is smaller than or equal to x. Floor of x doesn’t exist if x is smaller than smallest element of arr[].
Ceil of x is the smallest element which is greater than or equal to x. Ceil of x doesn’t exist if x is greater than greatest element of arr[].


```python
#define it(v) v.begin(),v.end()
class Solution {
  public:
    int getFloor(vector<int> &v, int x, int n){
        if(x<v[0]) return -1;
        int l=0,h=n-1,ans=-1;
        while(l<=h){
            int m=l + (h-l)/2;
            if(v[m]<=x){
                l=m+1;
                ans=m;
            }
            else h=m-1;
        }
        return v[ans];
    }
  
    int getCeil(vector<int> &v, int x, int n){
        if(x>v[n-1]) return -1;
        int l=0,h=n-1,ans=-1;
        while(l<=h){
            int m=l + (h-l)/2;
            if(v[m]>=x){
                h=m-1;
                ans=m;
            }
            else l=m+1;
        }
        return v[ans];
    }
  
  
    vector<int> getFloorAndCeil(int x, vector<int> &v) {
        sort(it(v));
        int n=v.size();
        vector<int> ans(2);
        ans[0]=getFloor(v,x,n);
        ans[1]=getCeil(v,x,n);
        return ans;
    }
};

```

# Involving decimals


```python
int cnt=100;
while(cnt--){}
```

```python
while(h-l>1e-6){}
```

```python

lld l=0, h=DBL_MAX, ans=-1;
while(){
    lld m= l+ (h-l)/2;
    if(f(m)){
        l=m;//moving right
    }
    else{
        h=m;//moving left
    }
}

```

Q. find sqrt


```python
if(x<=1) return x;
int l=1,h=x/2,ans=-1;
while(l<=h){
    int m=l+(h-l)/2;
    if(m<=x/m){
        ans=m;
        l=m+1;
    }
    else h=m-1;
}

```

q. nth root


```python
if(x<=1) return x;
int l=1,h=sqrt(x),ans=-1;
while(l<=h){
    int m=l+(h-l)/2;
    if(f(m,n)<=x){
        ans=m;
        l=m+1;
    }
    else h=m-1;
}
```
