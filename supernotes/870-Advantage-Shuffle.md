[Advantage Shuffle - LeetCode](https://leetcode.com/problems/advantage-shuffle/description/)

[#Leetcode 870. Advantage Shuffle || Medium || Code+ Explanation - YouTube](https://youtu.be/2KbKS5aTwcc?si=__wZ_QwdE0BgKLPK)

```cpp
vector<int> advantageCount(vector<int>& orig, vector<int>& v) {
    int n=orig.size();
    vector<int> perm(n);
    vector<pair<int,int>> vop;
    for(int i=0;i<n;i++) vop.push_back({v[i],i});
    sort(vop.begin(),vop.end(),greater<pair<int,int>>());
    sort(orig.begin(),orig.end());
    int l=0,h=n-1;
    for(int i=0;i<n;i++){
        if(orig[h]>vop[i].first){
            perm[vop[i].second]=orig[h];
            h--;
        }
        else{
            perm[vop[i].second]=orig[l];
            l++;
        }
    }
    return perm;
}
```