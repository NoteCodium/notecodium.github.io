[leetcode.com](https://leetcode.com/problems/partition-to-k-equal-sum-subsets/editorial/)

[Ep16 - Partition to K equal sum subsets | DSA | Codes available in description - YouTube](https://youtu.be/h_6MldQ8vB8?si=GrpTMf_rmIdIggxs)

[Divide an array into 4 equal parts](https://my.supernotes.app/?preview=265317ac-a824-4495-a747-5c7368232fe0)

# Proving the bad time complexity
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/42b746b2-d5a7-40ae-80e6-91cc47860a1a--image.png)

# Better solution
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/d9d5de31-6763-4825-9a23-e84aec3fafda--image.png)

```cpp
bool f(int n,int idx, int sum, int targetSum, int k, vector<int>& v, vector<bool> alreadyPicked){
    if(k<=0) return 1;
    if(sum==targetSum) return f(n,n-1,0,targetSum,k-1,v,alreadyPicked);
    if(sum>targetSum or idx<0) return 0;
    if(alreadyPicked[idx]){
        return f(n,idx-1,sum,targetSum,k,v,alreadyPicked);
    }
    else{
        //pick
        sum+=v[idx];
        alreadyPicked[idx]=1;
        bool op1=f(n,idx-1,sum,targetSum,k,v,alreadyPicked);
        sum-=v[idx];
        alreadyPicked[idx]=0;

        //not pick
        bool op2=f(n,idx-1,sum,targetSum,k,v,alreadyPicked);
        return op1 or op2;
    }
}


bool canPartitionKSubsets(vector<int>& v, int k) {
    int n=v.size();
    int sum=accumulate(v.begin(),v.end(),0);
    if(sum%k) return 0;
    int tagetSum=sum/k;
    sort(v.begin(),v.end());
    vector<bool> alreadyPicked(n,0);
    return f(n,n-1,0,tagetSum,k,v,alreadyPicked);

}
```
# Memoising
1. with string
### MLE

```cpp
bool f(int n,int idx, int sum, int targetSum, int k, vector<int>& v, vector<bool> alreadyPicked, string &taken, unordered_map<string, bool> &mem){
    if(k<=0) return mem[taken]=1;
    if(mem.count(taken)) return mem[taken];
    if(sum==targetSum) return mem[taken]=f(n,n-1,0,targetSum,k-1,v,alreadyPicked,taken,mem);
    if(sum>targetSum or idx<0) return mem[taken]=0;
    if(alreadyPicked[idx]){
        return mem[taken]=f(n,idx-1,sum,targetSum,k,v,alreadyPicked,taken,mem);
    }
    else{
        //pick
        sum+=v[idx];
        alreadyPicked[idx]=1;
        taken[idx]='1';
        bool op1=f(n,idx-1,sum,targetSum,k,v,alreadyPicked,taken,mem);
        sum-=v[idx];
        alreadyPicked[idx]=0;
        taken[idx]='0';

        //not pick
        bool op2=f(n,idx-1,sum,targetSum,k,v,alreadyPicked,taken,mem);
        return mem[taken]=op1 or op2;
    }
}


bool canPartitionKSubsets(vector<int>& v, int k) {
    int n=v.size();
    int sum=accumulate(v.begin(),v.end(),0);
    if(sum%k) return 0;
    int tagetSum=sum/k;
    sort(v.begin(),v.end());
    vector<bool> alreadyPicked(n,0);
    string taken(n, '0');
    unordered_map<string, bool> mem;
    return f(n,n-1,0,tagetSum,k,v,alreadyPicked,taken,mem);

}
```
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/bf1c4912-4d9d-4a01-8a24-49ab3f475abc--image.png)

# With bit masking
still mle, storing numbers instead of strings


```cpp
bool f(int n,int idx, int sum, int targetSum, int k, vector<int>& v, vector<bool> alreadyPicked, int &taken, unordered_map<int, bool> &mem){
    if(k<=0) return mem[taken]=1;
    if(mem.count(taken)) return mem[taken];
    if(sum==targetSum) return mem[taken]=f(n,n-1,0,targetSum,k-1,v,alreadyPicked,taken,mem);
    if(sum>targetSum or idx<0) return mem[taken]=0;
    if(alreadyPicked[idx]){
        return mem[taken]=f(n,idx-1,sum,targetSum,k,v,alreadyPicked,taken,mem);
    }
    else{
        //pick
        sum+=v[idx];
        alreadyPicked[idx]=1;
        // taken[idx]='1';
        taken|=(1<<idx);
        bool op1=f(n,idx-1,sum,targetSum,k,v,alreadyPicked,taken,mem);
        sum-=v[idx];
        alreadyPicked[idx]=0;
        // taken[idx]='0';
        taken^=(1<<idx);
        //not pick
        bool op2=f(n,idx-1,sum,targetSum,k,v,alreadyPicked,taken,mem);
        return mem[taken]=op1 or op2;
    }
}
 
 
bool canPartitionKSubsets(vector<int>& v, int k) {
    int n=v.size();
    int sum=accumulate(v.begin(),v.end(),0);
    if(sum%k) return 0;
    int tagetSum=sum/k;
    sort(v.begin(),v.end());
    vector<bool> alreadyPicked(n,0);
    // string taken(n, '0');
    int taken=0;
    // unordered_map<string, bool> mem;
    unordered_map<int, bool> mem;
    return f(n,n-1,0,tagetSum,k,v,alreadyPicked,taken,mem);
}
```

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/862051ec-1cc6-40e3-9c60-85d10d2c2332--image.png)

# Dp with bitmasking
# Elegant solution by yashesh
That's I know but here the TRICK is  (dp[i]+nums[j])%target;

```cpp
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int totalSum = 0;
        for(int i = 0; i<n; i++){
            totalSum += nums[i];
        }
        if(totalSum%k!=0)   return false;
        int target = totalSum/k;
        int [] dp = new int[1<<n];
        Arrays.fill(dp, -1);
        dp[(1<<n)-1] = 0;
        for(int i = (1<<n)-1; i>=0; i--){
            if(dp[i]==-1)   continue;
            for(int j = 0; j<n; j++){
                if((i&(1<<j))!=0 && dp[i]+nums[j]<=target){
                    dp[i^(1<<j)] = (dp[i]+nums[j])%target;
                }
            }
        }
        return dp[0]==0;
    }
}
```
