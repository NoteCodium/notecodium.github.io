[](https://leetcode.com/problems/number-of-laser-beams-in-a-bank/description/?envType=daily-question&envId=2024-01-03)


![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/2baf7acc-a990-4d4a-9f8b-b192944a2af2--image.png)


```cpp
int f(string &s){
    int cnt=0;
    for(char c: s) if(c=='1') cnt++;
    return cnt;
}

int numberOfBeams(vector<string>& vos) {
    int n=vos.size();
    int ans=0;
    int prev=0,curr;
    for(int i=0;i<n;i++){
        curr=f(vos[i]);
        if(curr!=0){
            ans+=(prev*curr);
            prev=curr;
        }
    }
    return ans;
}
```