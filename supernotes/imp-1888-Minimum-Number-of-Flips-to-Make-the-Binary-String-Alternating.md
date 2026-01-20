[Just a moment...](https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/description/)

# Observations
1. Given a size, there will be 2 unique strings alternating corresponding to it
2.

# Brute force
```cpp
    int comp(string &s, string &alt,int n){
        int ans=0;
        for(int i=0;i<n;i++){
            if(s[i]!=alt[i]) ans++;
        }
        return ans;
    }

    void lr1(string &s){
        int n=s.size();
        int tmp=s[0];
        for(int i=1;i<n;i++) s[i-1]=s[i];
        s[n-1]=tmp;
    }

    int minFlips(string s) {
        //brute force
        int n=s.size();
        string alt1,alt2;
        for(int i=0;i<n;i++){
            if(i%2==0){
                alt1+='1';
                alt2+='0';
            }
            else{
                alt1+='0';
                alt2+='1';
            }
        }

        int cnt=n;
        int ans=INT_MAX;
        while(cnt--){
            lr1(s);
            int ans1=comp(s,alt1,n);
            int ans2=comp(s,alt2,n);
            ans=min({ans,ans1,ans2});
        }
        return ans;
    }
``` 
[Minimum Number of Flips to make Binary String Alternating - Sliding Window - Leetcode 1888 - Python - YouTube](https://youtu.be/MOeuK6gaC2A?si=xOD1zbelOfCUyofy)

[LeetCode Weekly Contest 244 Question 3:Minimum Number of Flips to Make the Binary String Alternating - YouTube](https://youtu.be/YnZDv2PlnBc?si=q8VjPO5ZDAP-pwvA)


# Optimized

```cpp
int comp(string &s, string &alt,int n){
    int ans=0;
    for(int i=0;i<n;i++){
        if(s[i]!=alt[i]) ans++;
    }
    return ans;
}

int minFlips(string s) {
    int n=s.size();
    string alt1,alt2;
    for(int i = 0; i < n; i++) {
        alt1 += i % 2 ? '0' : '1';
        alt2 += i % 2 ? '1' : '0';
    }
    int ans=INT_MAX;

    int ans1=comp(s,alt1,n);
    int ans2=comp(s,alt2,n);
    ans=min({ans,ans1,ans2});

    //processing for generating subsequent windows
    s+=s;

    for(int i = n; i < 2*n; i++) {
        alt1 += i % 2 ? '0' : '1';
        alt2 += i % 2 ? '1' : '0';
    }

    //subsequent windows
    int l=1,h=n;
    while(h<2*n){
        if(s[l-1]!=alt1[l-1]) ans1--;
        if(s[l-1]!=alt2[l-1]) ans2--;
        if(s[h]!=alt1[h]) ans1++;
        if(s[h]!=alt2[h]) ans2++;
        ans=min({ans,ans1,ans2});
        l++,h++;
    }

    return ans;
}
```

