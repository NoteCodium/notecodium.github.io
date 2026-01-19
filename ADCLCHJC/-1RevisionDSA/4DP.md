lis


```python
//len
//strictly is
int lengthOfLIS(vector<int>& v) {
    int n=v.size();
    vector<int> tmp;
    tmp.push_back(v[0]);
    for(int i=1;i<n;i++){
        int x=v[i];
        if(x>tmp.back()) tmp.push_back(x);
        else{
            int idx=lower_bound(tmp.begin(), tmp.end(),x)-tmp.begin();
            tmp[idx]=x;
        }
    }
    return tmp.size();
}
```

```python
//non strictly is 
int lengthOfLIS(vector<int>& v) {
    vector<int> tmp;
    tmp.push_back(v[0]);
    int n=v.size();
    for(int i=1;i<n;i++){
        if(v[i]>=tmp.back()) tmp.push_back(v[i]);
        else{
            int idx=upper_bound(tmp.begin(), tmp.end(),v[i])-tmp.begin();
            tmp[idx]=v[i];
        }
    }
    return tmp.size();
}
```

```python
//q. longest decreasing subsequence non-strictly
int LDS(vector<int> v){
    int n=v.size();
    vector<int> tmp;
    tmp.push_back(v[0]);
    for(int i=1;i<n;i++){
        int x=v[i];
        if(x<tmp.back()) tmp.push_back(x);
        else{
            int idx = lower_bound(tmp.begin(), tmp.end(), x, greater<int>()) - tmp.begin();
            tmp[idx]=x;
        }
    }
    return tmp.size();
}
```

```python
// Filling the dp vector in nlogn      
//non-strictly
//where dp[i] is the length of the list ending at i
vector<int> tmp,dp(n);
tmp.push_back(v[0]);
dp[0]=1;
for(int i=1;i<n;i++){
    int x=v[i];
    if(x>=tmp.back()){
        tmp.push_back(x);
        dp[i]=tmp.size();
    } 
    else{
        int idx=upper_bound(tmp.begin(), tmp.end(),x)-tmp.begin();
        tmp[idx]=x;
        //this is the only tricky part
        dp[i]=idx+1;
    }
}
```

```python
//no of lis
class Solution {
    public:
        int findNumberOfLIS(vector<int>& v) {
            int n=v.size(); 
            int len=1; 
            vector<int> dp(n,1),count(n,1);
            for(int i=1;i<n;i++){ 
                for(int j=0;j<i;j++){ 
                    if(v[j]<v[i]){
                        ////////////////////////imp
                        if(dp[j]+1>dp[i]){
                            dp[i]=dp[j]+1;
                            count[i]=count[j];
                        }
                        else if(dp[j]+1==dp[i]){
                            count[i]+=count[j]; 
                        } 
                        ////////////////////////imp
                    } 
                } 
                len=max(len,dp[i]); 
            }
            int ans=0;
            for(int i=0;i<n;i++) if(dp[i]==len) ans+=count[i];
            return ans;
        }
    };
```

```python
//construct lis
#define it(v) v.begin(), v.end() 
class Solution {
  public:
        vector<int> constructLis(vector<int>& v,vector<int>& hash,int lastIdx){
            vector<int> lis;
            while(hash[lastIdx]!=-1){
                lis.push_back(v[lastIdx]);
                lastIdx=hash[lastIdx];
            }
            lis.push_back(v[lastIdx]);
            reverse(it(lis));
            return lis;
        }
        
        vector<int> getLIS(vector<int>& v) {
            int n=v.size();
            vector<int> dp(n,1),hash(n,-1);
            int maxLen=1;
            int lastIdx=0;
            for(int i=1;i<n;i++){
                for(int prevIdx=0;prevIdx<i;prevIdx++){
                    if(v[prevIdx]<v[i] and 1+dp[prevIdx]>dp[i]){
                        dp[i]=1+dp[prevIdx];
                        hash[i]=prevIdx;
                    }
                }
                if(dp[i]>maxLen){
                    maxLen=dp[i];
                    lastIdx=i;
                }
            }
            
            return constructLis(v,hash,lastIdx);
        }

};

```
