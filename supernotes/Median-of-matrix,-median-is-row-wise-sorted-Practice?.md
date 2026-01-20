[Median in a row-wise sorted Matrix | Practice | GeeksforGeeks ](https://www.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article)


Premium problem in leetcode, better solution?
[leetcode.com](https://leetcode.com/problems/median-of-a-row-wise-sorted-matrix/)

```cpp
#define it(v) v.begin(), v.end()
class Solution{   
public:
    pair<int,int> colunmn_minmax(vector<vector<int>>& ma, int c){ 
        int maxx=INT_MIN,minn=INT_MAX; 
        int rr=ma.size(),cc=ma[0].size(); 
        for(int r=0;r<rr;r++){ 
            maxx=max(maxx,ma[r][c]); 
            minn=min(minn,ma[r][c]); 
        } 
        return {minn,maxx}; 
    } 


    int f(int m,vector<vector<int>>& ma, int rr){
        int count=0; 
        for(int i=0;i<rr;i++){ 
            vector<int> &v=ma[i]; 
            count+=(upper_bound(it(v),m)-v.begin());
        } 
        return count; 
    }
    
    
    int kth(vector<vector<int>>& ma, int k, int rr, int cc) { 
        int m,l=colunmn_minmax(ma,0).first,h=colunmn_minmax(ma,cc-1).second,ans; 
        while(l<=h){ 
            m=(l+h)/2; 
            if(f(m,ma,rr)>=k){ 
                ans=m; 
                h=m-1; 
            } 
            else l=m+1; 
        } 
        return ans; 
        
    } 


    int median(vector<vector<int>> &ma, int rr, int cc){
        int k=(rr*cc)/2;
        if((rr*cc)%2==0){
            return (kth(ma,(k+1),rr,cc)+kth(ma,(k+-1+1),rr,cc))*0.5;
        }
        else{
            return kth(ma,(k+1),rr,cc);
        }
    }
};

```