[Ugly Number II - LeetCode](https://leetcode.com/problems/ugly-number-ii/description/)

# By two pointers


![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/2162f74f-fa48-4822-b729-086a8be2a833--image.png)



```cpp
int nthUglyNumber(int n) {
    vector<int> v(n);
    v[0]=1;
    int p2=0,p3=0,p5=0;
    for(int i=1;i<n;i++){
        int val=min({v[p2]*2,v[p3]*3,v[p5]*5});
        v[i]=val;
        //THIS IS HOW WE ARE ENSURING DUPLICATES ARE NOT THERE
        if(val==v[p2]*2) p2++;
        if(val==v[p3]*3) p3++;
        if(val==v[p5]*5) p5++;
    }
    return v[n-1];   
}
```


[Super Ugly Number - LeetCode](https://leetcode.com/problems/super-ugly-number/description/)

A **super ugly number** is a positive integer whose prime factors are in the array `primes`.
Return nth

# This will give TLE
# By priority Queue
# TC n* prime array size *(logn + log(prime array size))
```cpp
int nthUglyNumber(int n) {
    priority_queue<long long,vector<long long>,greater<long long>> pq;
    unordered_set<long long> se;
    pq.push(1);
    se.insert(1);
    long long ans=-1;
    vector<int> primes{2,3,5};
    while(n--){
        ans=pq.top();
        pq.pop();
        for(int i=0;i<primes.size();i++){
            if(se.count(ans*primes[i])!=0) continue;
            se.insert(ans*primes[i]);
            pq.push(ans*primes[i]);
        }
    }
    return ans;
}
```
---------------------------------------------------------------------------------------------------------------------

# Doing like two pointers with the help of heap , the above was entirely a new strategy
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/8efbbe3b-728f-4671-a2e8-2cadbe8f1cb9--image.png)


![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/96e6d512-4a37-4395-a8b1-9575b64a104f--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/3ef3bb63-bc47-4e8f-8510-4cd75b2ce5ce--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/4cc490f8-b04e-47ec-bff7-b28ea3570f28--image.png)





# Rewrite
```cpp
int nthSuperUglyNumber(int n, vector<int>& primes) {
    vector<int> ans;
    ans.push_back(1);
    auto cmp=[&](vector<long> &a, vector<long> &b){
        return a[0]*ans[a[1]]>b[0]*ans[b[1]];
    };
    vector<vector<long>> tmp;
    for(int i=0;i<primes.size();i++) tmp.push_back({primes[i],0});
    priority_queue<vector<long>,vector<vector<long>>,decltype(cmp)> pq(cmp,tmp);
    while(ans.size()<n){
        auto vv=pq.top();pq.pop();
        if(vv[0]*ans[vv[1]]>ans.back()) ans.push_back(vv[0]*ans[vv[1]] );
        pq.push({vv[0],vv[1]+1});
    }
    int ret=ans.back();
    ans.clear();
    return ret;
}
```




```cpp
vector<int> ans;
class Solution {
public:
    struct cmp{
        bool operator()(pair<long,long> &a, pair<long,long> &b){
            return a.first*ans[a.second]>b.first*ans[b.second];
        }
    };


    int nthSuperUglyNumber(int n, vector<int>& primes) {
        priority_queue<pair<long,long>,vector<pair<long,long>>,cmp> pq;
        ans.push_back(1);
        for(int i=0;i<primes.size();i++) pq.push({primes[i],0});
        while(ans.size()<n){
            auto p=pq.top();pq.pop();
            if(p.first*ans[p.second]>ans.back()) ans.push_back(p.first*ans[p.second] );
            pq.push({p.first,p.second+1});
        }
        // return ans.back();
        int ret=ans.back();
        ans.clear();
        return ret;
    }
};
```



![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/7b75ad49-2209-47a8-bf9e-3cd3bc099a82--image.png)