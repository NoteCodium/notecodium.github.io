[Just a moment...](https://leetcode.com/problems/find-longest-awesome-substring/description/)

![image.png](../images/6a24e107-0d1a-4377-9fa7-d908af39e391--image.png)

```cpp
int longestAwesome(string s) {
    unordered_map<int,int> m;
    m[0]=-1;//such that it accurately find the length
    int n=s.size();
    int mask=0;
    int ans=0;
    for(int i=0;i<n;i++){
        char c=s[i];
        mask^=(1<<(c-'0'));
        for(int d=0;d<=9;d++){
            int new_mask=mask^(1<<d);
            if(m.count(new_mask)) ans=max(ans,i-m[new_mask]);                
        }
        if(m.count(mask)) ans=max(ans,i-m[mask]);
        else m[mask]=i;
    }
    return ans;
}
```


![image.png](../images/342fe92a-2a59-4740-b8f0-17445d851acb--image.png)

![image.png](../images/d68ea5ce-3c7d-40b5-9502-937d4f9c7264--image.png)

![image.png](../images/7c17b35d-d09b-429b-be77-ef943f5f7910--image.png)

