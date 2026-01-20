[Number of Subsequences That Satisfy the Given Sum Condition - LeetCode](https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/)

```cpp
int moda(int a, int b, int cm=mod) {a = a % cm; b = b % cm; return (((a + b) % cm) + cm) % cm;}
int mpow(int base, int exp, long long cmod=mod){base %= cmod;long long result = 1;while (exp > 0) {if (exp & 1) result = ((long long)result * base) % cmod;base = ((long long)base * base) % cmod;exp >>= 1;}return result;}    

//Return the number of non-empty subsequences 
//sum of the minimum and maximum element <=k     
int numSubseq(vector<int>& v, int k) {
    sort(v.begin(),v.end());
    int n=v.size();
    int ans=0;
    int l=0,h=n-1;
    while(l<=h){
        int sum=v[l]+v[h];
        if(sum<=k){
            int len=h-l+1;
            ans=moda(ans,mpow(2,len-1));
            //for each l there will be these many possibilities
            l++;
        }
        else h--;
    }
    return ans;
}

```

