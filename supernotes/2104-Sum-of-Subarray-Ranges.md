    [leetcode.com](https://leetcode.com/problems/sum-of-subarray-ranges/description/)


# a1 sum of all maxima - minimas


```cpp
vector<int> prevMoreOrEqual(vector<int>& v) {
        int n = v.size();
        vector<int> pm(n, -1);
        stack<int> st;
        st.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (!st.empty() && v[i] >= v[st.top()]) {
                pm[st.top()] = i;
                st.pop();
            }
            st.push(i);
        }
        return pm;
    }

    vector<int> nextMore(vector<int>& v) {
        int n = v.size();
        vector<int> nm(n, n);
        stack<int> st;
        st.push(0);
        for (int i = 1; i < n; i++) {
            while (!st.empty() && v[i] > v[st.top()]) {
                nm[st.top()] = i;
                st.pop();
            }
            st.push(i);
        }
        return nm;
    }

    long long sumSubarrayMaxs(vector<int>& v) {
        int n = v.size();
        long long sum = 0;
        vector<int> pm = prevMoreOrEqual(v);
        vector<int> nm = nextMore(v);
        for (int i = 0; i < n; i++)
            sum += (long long)(i - pm[i]) * (nm[i] - i) * v[i];
        return sum;
    }




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

    long long sumSubarrayMins(vector<int>& v) {
        int n=v.size();
        long long sum=0;
        vector<int> pl=prevLessOrEqual(v);
        vector<int> nl=nextLess(v);
        for(int i=0;i<n;i++) 
        sum+=(long long) v[i]*(i-pl[i])*(nl[i]-i);
        return sum;
    }

    long long subArrayRanges(vector<int>& v) {
        long long sum=0;
        sum+=sumSubarrayMaxs(v);
        sum-=sumSubarrayMins(v);
        return sum;
    }
```



# Approach 2

