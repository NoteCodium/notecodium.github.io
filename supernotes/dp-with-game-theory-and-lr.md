Increase the difference if there are two person who are taking elements from a deque
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/5dc52972-1b5f-4dba-b547-7fc8aae51f6b--image.png)

as for the next dp this will be calculated
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/382c0fa2-89fd-4c06-8b39-486f25ae2621--image.png)

but we keep wanted p1-p2, so we subtract the next quantity so the signs got reversed


[Stone Game - LeetCode](https://leetcode.com/problems/stone-game/)
```cpp
int f(int l, int r, vector<int>& v){
    if(l>r) return 0;
    return max(v[l]+f(l+1,r,v),v[r]+f(l,r-1,v));
}


bool stoneGame(vector<int>& v) {
    int n=v.size(); 
    return f(0,n-1,v)>0;

}
```


see its explanation of why always Alice wins