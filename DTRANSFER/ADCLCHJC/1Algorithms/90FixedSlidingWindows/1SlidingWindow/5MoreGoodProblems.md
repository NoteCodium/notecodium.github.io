---
title: 5MoreGoodProblems
---

{% raw %}
https://leetcode.com/problems/k-radius-subarray-averages/description/

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_90FixedSlidingWindows_1SlidingWindow_5MoreGoodProblems__att_0001.png)

```python
class Solution {
    public:
        vector<int> getAverages(vector<int>& v, int k) {
            //ws=(i+k)-i+1 + i-(i-k)+1+ -1
            //ws= 2k+1
            //i-k to i to i+k
            int n=v.size();
            vector<int> ans(n,-1);
            if(n<2*k+1){
                return ans;
            }
    
            int ws=2*k+1;
            long sum=0;
            for(int i=0;i<=ws-2;i++){
                sum+=v[i];
            }
            //i-k==0
            //i+k==n-1
            for(int i=ws-1,j=k;j<=n-1-k;i++,j++){
                sum+=v[i];
                ans[j]=sum/ws;
                sum-=v[i-ws+1];
            }
            return ans;
        }
    };
```

https://codeforces.com/contest/1341/problem/B

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_90FixedSlidingWindows_1SlidingWindow_5MoreGoodProblems__att_0002.png)

```python
void solve(){
    ll n,k;
    inp(n,k);
    vinp(v,n);
    ll ws=k-2;
    vl transformedV(n);

    for(int i=1;i<=n-2;i++){
        if(v[i-1]<v[i] and v[i]>v[i+1]){
            transformedV[i]=1;
        }
        else{
          transformedV[i]=0;              
        }
    }
    transformedV[0]=transformedV[n-1]=0;
    ll peaks=0;
    for(int i=1;i<=ws-1;i++){
        if(transformedV[i]==1){
            peaks++;
        }
    }
    //windows size=ws-1

    ll minI=-1,maxPeaks=0;
    
    //from here we start building
    //our actual windows
    for(int i=ws;i<=n-2;i++){
        if(transformedV[i]==1){
            peaks++;
        }
        if(peaks>maxPeaks){
            maxPeaks=peaks;
            minI=i-ws;
            //for the actual k sized window
        }
        if(transformedV[i-ws+1]==1){
            peaks--;
        }        
    }
    cout<<maxPeaks+1<<" "<<((minI==-1)?1:minI+1);
    pri();
    
}
```
{% endraw %}
