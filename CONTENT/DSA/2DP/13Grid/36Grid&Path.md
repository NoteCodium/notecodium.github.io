---
title: 36Grid&Path
---

{% raw %}
do the maths version

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_40DP_13Grid_36Grid_Path__att_0001.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_40DP_13Grid_36Grid_Path__att_0002.png)

Solve the below problem using maths

https://leetcode.com/problems/unique-paths/description/
![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_40DP_13Grid_36Grid_Path__att_0003.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_40DP_13Grid_36Grid_Path__att_0004.png)

kisi cell par do jagha se pahuch sakte hon

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_40DP_13Grid_36Grid_Path__att_0005.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_40DP_13Grid_36Grid_Path__att_0006.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_40DP_13Grid_36Grid_Path__att_0007.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_40DP_13Grid_36Grid_Path__att_0008.png)

q.2         
https://leetcode.com/problems/unique-paths-ii/description/      
![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_40DP_13Grid_36Grid_Path__att_0009.png)

base condition will change  
![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_40DP_13Grid_36Grid_Path__att_0010.png)

```python
  vector<vector<int>> dp(rr,vector<int> (cc,0)); 
  dp[0][0]= ma[0][0]==1 ? 0:1;  
  for(int r=0;r<rr;r++){ 
      for(int c=0;c<cc;c++){ 
          if(r==0 and c==0) continue;   
          if(ma[r][c]) continue;   
          int ans=0;   
          if(c>0) ans+=dp[r][c-1]; 
          if(r>0) ans+=dp[r-1][c]; 
          dp[r][c]=ans;  
      } 
  } 
  return dp[rr-1][cc-1]; 
```

q. Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.   

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_40DP_13Grid_36Grid_Path__att_0011.png)

https://leetcode.com/problems/minimum-path-sum/description/

```python
class Solution {
    public:
        int f(int r,int c,vector<vector<int>> &ma, int rr, int cc){
            if(r==rr-1 and c==cc-1) return ma[rr-1][cc-1];
            if(r>=rr or c>=cc) return INT_MAX;
            return ma[r][c]+min(f(r+1,c,ma,rr,cc),f(r,c+1,ma,rr,cc));
        }
                
        int minPathSum(vector<vector<int>>& ma) {
            int rr=ma.size(),cc=ma[0].size();
            return f(0,0,ma,rr,cc);
        }  
    };
```

```python
class Solution {
    public:
                
        int minPathSum(vector<vector<int>>& ma) {
            int rr=ma.size(),cc=ma[0].size();
            vector<vector<int>> dp(rr, vector<int>(cc, 0));
            dp[0][0]=ma[0][0];
            for(int i=0;i<rr;i++){
                for(int j=0;j<cc;j++){
                    if(i==0 and j==0) continue;
                    int minn=INT_MAX;
                    if(i-1>=0) minn=min(minn,dp[i-1][j]);
                    if(j-1>=0) minn=min(minn,dp[i][j-1]);
                    dp[i][j]=ma[i][j]+minn;
                }
            }
            return dp[rr-1][cc-1];
        }  
    };
```

Writing like this will be more logical

```python
class Solution {
    public:
        int f(int r,int c,vector<vector<int>> &ma, int rr, int cc){
            if(r==0 and c==0) return ma[0][0];
            if(r<0 or c<0) return INT_MAX;
            return ma[r][c]+min(f(r-1,c,ma,rr,cc),f(r,c-1,ma,rr,cc));
        }
                
        int minPathSum(vector<vector<int>>& ma) {
            int rr=ma.size(),cc=ma[0].size();
            return f(rr-1,cc-1,ma,rr,cc);
        }  
    };
```

# FAANG

q. printing the path 
I think present in cses no that was a graph problem

https://leetcode.com/problems/unique-paths/description/

```python
class Solution {
    public:
        int minPathSum(vector<vector<int>>& ma) {
    
        int rr=ma.size(),cc=ma[0].size(); 
        vector<vector<pair<int,char>>> dp(rr,vector<pair<int,char>>(cc,{'$',-1})); 
        dp[0][0].first=ma[0][0]; 
        for(int i=0;i<rr;i++){ 
            for(int j=0;j<cc;j++){ 
                if(i==0 and j==0) continue; 
                int min1=INT_MAX,min2=INT_MAX; 
                if(i-1>=0) min1=dp[i-1][j].first; 
                if(j-1>=0) min2=dp[i][j-1].first; 
                dp[i][j].second = min1<min2?'d':'r'; 
                dp[i][j].first=ma[i][j]+min(min1,min2); 
            } 
        } 
        int i=rr-1,j=cc-1;
        string revPath;
        while(!(i==0 and j==0)){
            char c= dp[i][j].second;
            revPath.push_back(c);
            if(c=='d'){
                i--;
            }
            else{
              j--;              
            }
        }
        reverse(it(revPath));
        print(revPath);
    
    
        return dp[rr-1][cc-1].first; 
        }
    };
```

```python
//doubt what is this
// The optimal way will to keep storing all the paths in a single vector, and pushing that vector into a vector of vector when we reach the destination
//This is kind of R and B
void f(ll i, ll j){
    if(d2[i][j]) return;
    if(i==n-1 and j==m-1){
        ans.push_back(v);
        v.clear();
    }
    
    v.push_back({r,c});
    if(i==n-1) f(i,j+1);
    else if(j==m-1) f(i+1,j);
    else{
	    f(i,j+1);
	    f(i+1,j);
    }
    v.pop_back({r,c});
}
```
{% endraw %}
