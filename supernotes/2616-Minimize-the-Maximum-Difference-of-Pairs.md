[Just a moment...](https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/description/)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/bdd2e570-c483-4f12-8cbf-4a026a36f3db--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/d4d71bd0-904e-4e17-9052-982653a57cf6--image.png)


[Just a moment...](https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/description/)

```cpp
int f(int m, vector<int>& v, int p, int n){
    int pair=0;
    for(int i=1;i<n;){
        if(abs(v[i]-v[i-1])<=m){
            pair++;
            i+=2;
        }
        else i++;
    }

    return pair>=p;
}

int minimizeMax(vector<int>& v, int p) {
    if(p==0) return 0;
    sort(v.begin(),v.end());
    int n=v.size();
    int l=INT_MAX;
    for(int i=1;i<n;i++){
        l=min(l,v[i]-v[i-1]);
    }
    int h=v[n-1]-v[0];
    int ans=-1;
    while(l<=h){
        int m= l+ (h-l)/2;
        if(f(m,v,p,n)){
            ans=m;
            h=m-1;
        }
        else l=m+1;
    }
    return ans;
}
```
