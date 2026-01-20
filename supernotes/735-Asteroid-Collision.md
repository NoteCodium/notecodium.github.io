[leetcode.com](https://leetcode.com/problems/asteroid-collision/description/)
[Asteroid Collision | Intuition | Dry Run | Leetcode-735 | Uber | Lyft | Explanation ➕ Live Coding - YouTube](https://www.youtube.com/watch?v=7isfomHzzno)


```cpp

```

only case of collide
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/8f8cefba-c696-4549-b9bd-f83a3d49582a--image.png)

```cpp
vector<int> asteroidCollision(vector<int>& v) {
    stack<int> st;
    for(int x: v){
        while(!st.empty() and x<0 and st.top()>0){
            int sum=x + st.top();
            if(sum<0) st.pop();
            else if(sum>0) x=0;
            else{
                st.pop();
                x=0;
            } 
        }
        if(x!=0) st.push(x);
    }
    int n=st.size();
    vector<int> ans(n);
    int i=n-1;
    while(!st.empty()){
        ans[i]=st.top();
        st.pop();
        i--;
    }
    return ans;
}
```
