[Just a moment...](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/)

```cpp
int f(int m, vector<int>& v, int days){
    int n=v.size();
    int ansDays=0;
    int tmpWei=0;
    for(int i=0;i<n;i++){
        if(v[i]>m) return 0;
        if (tmpWei + v[i] > m) {
            ansDays++;
            tmpWei = v[i];
        } 
        else{
            tmpWei += v[i];
        } 
    }
    if(tmpWei) ansDays++;
    return ansDays<=days;
}


int shipWithinDays(vector<int>& v, int days) {
    int l=1,h=INT_MAX,ans=-1;
    while(l<=h){
        int m=l+(h-l)/2;
        if(f(m,v,days)){
            ans=m;
            h=m-1;
        }
        else l=m+1;
    }
    return ans;
}
```