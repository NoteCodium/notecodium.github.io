[Minimum Number of Days to Make m Bouquets - LeetCode](https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/)

```cpp
int f(int m, vector<int> v, int flowers, int n){
    int no=0;
    for(int &x: v){
        if(x<=m) x=1;
        else x=0;
    } 
    int cnt=0;
    for(int i=0;i<n;i++){
        if(!v[i]){
            cnt=0;
            continue;
        }
        cnt++;
        if(cnt==flowers){
            no++;
            cnt=0;
        }
    }
    return no;
}

int minDays(vector<int>& v, int no, int flowers) {
    int n=v.size();
    if(no>n/flowers) return -1;
    int l=*min_element(v.begin(),v.end()),h=*max_element(v.begin(),v.end());
    int ans=-1;
    while(l<=h){
        int m=(l+h)/2;
        if(f(m,v,flowers,n)>=no){
            ans=m;
            h=m-1;
        }
        else l=m+1;
    }
    return ans;

}
```