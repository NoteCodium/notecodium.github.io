[Just a moment...](https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/description/)\

The above approach will give tle

```cpp
int findKthNumber(int rr, int cc, int k) {
    auto cmp=[&](auto &a, auto &b){
        int x=(a.first+1)*(a.second+1),y=(b.first+1)*(b.second+1);
        return x>y;
    };

    priority_queue<pair<int,int> ,vector<pair<int,int>>,decltype(cmp)> pq(cmp);

    pq.push({0,0});
    set<pair<int,int>> se; 
    se.insert({0,0});
    int ans=-1;
    while(k--){
        pair<int,int> p=pq.top();pq.pop();
        int i=p.first,j=p.second;
        ans=(i+1)*(j+1);
        if(j+1<cc and se.count({i,j+1})==0){
            pq.push({i,j+1});
            se.insert({i,j+1});
        }
        
        if(i+1<rr and se.count({i+1,j})==0){
            pq.push({i+1,j});
            se.insert({i+1,j});
        }
    }
    return ans;  
}
```

# Better then any k we need

[668. Kth Smallest Number in Multiplication Table Leetcode Daily Challenge - YouTube](https://youtu.be/N-7biZf7a0I?si=hH7piBWAlBBwbTLM)

```cpp
int f(int m, int rr, int cc){
    int ans=0;  
    for(int r=1;r<=rr;r++){
        ans+=min(m/r,cc);
    }
    return ans;
}

int findKthNumber(int rr, int cc, int k) {
    int l=1,h=rr*cc,ans=-1;
    while(l<=h){
        int m=(l+h)/2;
        if(f(m,rr,cc)>=k){
            ans=m;
            h=m-1;
        }
        else l=m+1;
    }
    return ans;
}
```
