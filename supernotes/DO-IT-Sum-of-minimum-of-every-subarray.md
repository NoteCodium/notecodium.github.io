https://leetcode.com/problems/sum-of-subarray-minimums/
in ppa, understand only when watch the video
 

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/aad1f49c-f467-458b-8c94-3a327e9d71a9--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/91d9d504-99c6-4c1d-a292-ace48f66f631--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/6a83d769-8a66-42af-a0e9-b30dfe6e38dd--image.png)

```cpp
#define mod 1000000007
#define ll long long
ll moda(ll a, ll b, ll cm=mod) {a = a % cm; b = b % cm; return (((a + b) % cm) + cm) % cm;}
ll modm(ll a, ll b, ll cm=mod) {a = a % cm; b = b % cm; return (((a * b) % cm) + cm) % cm;}


class Solution {
public:

    vector<int> prevLessOrEqual(vector<int>& v) { 
        int n=v.size(); 
        vector<int> pl(n,-1);
        stack<int> st;
        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(!st.empty() and v[i]<=v[st.top()]){
                pl[st.top()]=i;
                st.pop();
            }
            st.push(i);
        }
        return pl; 
    } 
 

    vector<int> nextLess(vector<int>& v) { 
        int n=v.size(); 
        vector<int> nl(n,n);
        stack<int> st;
        st.push(0);
        for(int i=1;i<n;i++){
            while(!st.empty() and v[i]<v[st.top()]){
                nl[st.top()]=i;
                st.pop();
            }
            st.push(i);
        }
        return nl; 
    } 

    int sumSubarrayMins(vector<int>& v) {
        int n=v.size();
        long long sum=0;
        vector<int> pl=prevLessOrEqual(v);
        vector<int> nl=nextLess(v);
        for(int i=0;i<n;i++) 
        //sum+=v[i]*(nl[i]-i)*(i-pl[i])
        sum=(moda(sum,modm(v[i],modm(i-pl[i],nl[i]-i ))));
        return sum;
    }
};
```



# Approach 2

To calculate `minTime[i]` for every index, we can use a stack to maintain a monotonically increasing sequence during the iteration over `nums`:

- What is the left index `left`? The element on `nums[i]`'s left in the stack.
  
- What is the right index `right`? The element we are using to pop `nums[i]` from the stack.

[Just a moment...](https://leetcode.com/problems/sum-of-subarray-ranges/editorial/)

could not understand this cleaner editorial approach

