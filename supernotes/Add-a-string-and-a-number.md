[Add to Array-Form of Integer - LeetCode](https://leetcode.com/problems/add-to-array-form-of-integer/description/)


```
class Solution {
    public List<Integer> addToArrayForm(int[] v, int k) {
       //very elegant solution
       int n=v.length;
       int curr=k;
       List<Integer> ans =
            new ArrayList<>();

        int idx=n-1;
        while(idx>=0 || curr>0){
            if(idx>=0){
                curr+=v[idx];
            }
            ans.add(curr%10);
            curr/=10;
            idx--;
        }
        Collections.reverse(ans);
        return ans;
    }
}
```

![image.png](../images/3f457b1f-155c-448b-a285-ef7a30cb00a0--image.png)




---------

[Add to Array-Form of Integer - Leetcode 989 - Python - YouTube](https://youtu.be/eBTZQt1TWfk?si=rSy_OHBaCgRFnfcG)






---------



```cpp
vector<int> addToArrayForm(vector<int>& v, int k) {
    reverse(v.begin(),v.end());
    int i=0;
    int n=v.size();
    while(k){
        int digit=k%10;
        if(i<n) v[i]+=digit;
        else v.push_back(digit);
        int carry=v[i]/10;
        v[i]=v[i]%10;
        k/=10;
        k+=carry;
        i++;
    }
    reverse(v.begin(),v.end());
    return v;
}
```
