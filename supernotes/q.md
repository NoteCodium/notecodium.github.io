```cpp

    int subarraysWithKDistinct(vector<int>& v, int k) {
        int n=v.size();
        int l = 0, h = 0;
        int ans=0;
        unordered_map<int,int> m;
        while(h < n) {
            m[v[h]]++;
            while (m.size()>k and l < h) {
                m[v[l]]--;
                if(m[v[l]]==0) m.erase(v[l]);
                l++;          
            }
            if (m.size() == k){
                ans++;
            } 
            h++;
        }
        return ans;
    }
```