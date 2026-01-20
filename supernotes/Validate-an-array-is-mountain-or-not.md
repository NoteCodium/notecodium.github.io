[Valid Mountain Array - LeetCode](https://leetcode.com/problems/valid-mountain-array/description/)

```cpp
bool validMountainArray(vector<int>& v) {
    int n=v.size();
    if(n<3) return 0;
    for(int i=1;i<=n-2;){
        if(v[i-1]<v[i] and v[i]>v[i+1]){
        //find the peak
            int j=i;
        //going left
            while(j>0 and v[j-1]<v[j]){
                j--;
            }
            if(j!=0) return 0;
        //going right
            while(i<=n-2 and v[i]>v[i+1]){
                i++;
            }
            if(i!=n-1) return 0;
            else return 1;
        }
        else i++;
    }
    return 0;
}
```
