[Paint House III - LeetCode](https://leetcode.com/problems/paint-house-iii/description/)

[Paint House III - YouTube](https://youtu.be/7Evjw2VM240?si=YsAmpAQ3iiK2Ciqd)


```cpp
int f(int idx, int prevColor, int t,vector<int>& v, vector<vector<int>>& ma, int noColors, int target){
    if(t>target) return INT_MAX/2;
    if(idx<0){
        if(t==target) return 0;
        else return INT_MAX/2;
    }
    int ans=INT_MAX/2;
    if(v[idx]==0){
        for(int i=0;i<noColors;i++){
            ans=min(ans,ma[idx][i]+f(idx-1,i+1,prevColor==i+1?t:t+1,v,ma,noColors,target));
        }
    }
    else{
        ans=f(idx-1,v[idx],v[idx]==prevColor?t:t+1,v,ma,noColors,target);
    }

    return ans;
}


int minCost(vector<int>& v, vector<vector<int>>& ma, int noHouses, int noColors, int target) {
    int ans=f(noHouses-1, -1,0,v,ma,noColors, target);
    return ans==INT_MAX/2?-1:ans;      
}
```

```cpp
int mem[101][21][101];

int f(int idx, int prevColor, int t,vector<int>& v, vector<vector<int>>& ma, int noColors, int target){
    if(t>target) return INT_MAX/2;
    if(idx<0){
        if(t==target) return 0;
        else return INT_MAX/2;
    }
    if(mem[idx][prevColor][t]!=-1) return mem[idx][prevColor][t];
    int ans=INT_MAX/2;
    if(v[idx]==0){
        for(int i=0;i<noColors;i++){
            ans=min(ans,ma[idx][i]+f(idx-1,i+1,prevColor==i+1?t:t+1,v,ma,noColors,target));
        }
    }
    else{
        ans=f(idx-1,v[idx],v[idx]==prevColor?t:t+1,v,ma,noColors,target);
    }

    return mem[idx][prevColor][t]=ans;
}


int minCost(vector<int>& v, vector<vector<int>>& ma, int noHouses, int noColors, int target) {
    memset(mem,-1,sizeof mem);
    int ans=f(noHouses-1, -1,0,v,ma,noColors, target);
    return ans==INT_MAX/2?-1:ans;      
}
```