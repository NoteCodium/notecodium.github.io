[Matrix Block Sum - LeetCode](https://leetcode.com/problems/matrix-block-sum/description/)

```cpp
bool f(int m, vector<vector<int>>& ma, int k, int rr, int cc){
    for(int r=0;r<rr;r++){
        for(int c=0;c<cc;c++){
            int tr=r+m-1,tc=c+m-1;
            if(tr>=rr or tc>=cc) continue;
            int sum=ma[tr][tc];
            if(c-1>=0) sum-=ma[tr][c-1];
            if(r-1>=0) sum-=ma[r-1][tc];
            if(r-1>=0 and c-1>=0) sum+=ma[r-1][c-1];
            if(sum<=k) return 1;
        }
    }
    return 0;   
}


int maxSideLength(vector<vector<int>>& ma, int k) {
    int rr=ma.size(),cc=ma[0].size();
    int minn=INT_MAX;
    for(int r=0;r<rr;r++){
        for(int c=0;c<cc;c++){
            minn=min(minn,ma[r][c]);
            int tmp=0;
            if(r-1>=0) tmp+=ma[r-1][c];
            if(c-1>=0) tmp+=ma[r][c-1];
            if(r-1>=0 and c-1>=0) tmp-=ma[r-1][c-1];
            ma[r][c]+=tmp;
        }
    }
    if(minn>k) return 0;
    int l=1,h=min(rr,cc),ans=0;
    while(l<=h){
        int m=(l+h)/2;
        if(f(m,ma,k,rr,cc)){
            ans=m;
            l=m+1;
        }
        else h=m-1;
    }
    return ans;
}
```