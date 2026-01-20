

[leetcode.com](https://leetcode.com/problems/restore-ip-addresses/description/)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/bfb27679-17b8-4441-979a-160e09cb3d3a--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/20371ea9-fb0a-4082-a258-5f359d5a8fbd--image.png)

# R & B
```cpp
bool isValid(string s){
    if(s.size()>3 or s.size()==0) return 0;
    if(s.front()=='0' and s.size()>1) return 0;
    int val=stoi(s);
    return val>=0 and val<=255;
}

void f(int idx, string &s, vector<string> &ans, vector<string> &segments, int segIdx){
    if(idx>=s.size()){
        if(segIdx==3){
            string tmp;
            for(string s: segments){
                tmp+=s;
                tmp.push_back('.');
            }
            tmp.pop_back();
            ans.push_back(tmp);
        }
        return;
    }
    if(segIdx>=4) return;
    string prev=segments[segIdx];
    if(isValid(prev+s[idx])){
        segments[segIdx]+=s[idx];
        f(idx+1,s,ans,segments,segIdx);
        segments[segIdx].pop_back();
    }

    if(isValid(prev)){
        string tmp;
        tmp.push_back(s[idx]);
        segments.push_back(tmp);
        f(idx+1,s,ans,segments,segIdx+1);
        segments.pop_back();
    }

}

vector<string> restoreIpAddresses(string s) {
    int n=s.size();
    vector<string> ans;
    if(n>12 or n<4) return ans;
    vector<string> segments;
    segments.push_back("");
    f(0,s,ans,segments,0);
    return ans;
}
```

# Manipulations

```cpp
class Solution {
public:
    bool isValid(string s){
        if(s.size()>3 or s.size()==0) return 0;
        if(s.front()=='0' and s.size()>1) return 0;
        int val=stoi(s);
        return val>=0 and val<=255;
    }


    vector<string> restoreIpAddresses(string s) {
        int n=s.size();
        vector<string> ans;
        if(n>12 or n<4) return ans;
        //first . after 1 or 2 or 3 digits
        for(int d1=1;d1<=3;d1++){
            if(0+d1-1<n and isValid(s.substr(0,d1))){
                for(int d2=1;d2<=3;d2++){
                    if(d1+d2-1<n and isValid(s.substr(d1,d2))){
                        for(int d3=1;d3<=3;d3++){
                            if(d1+d2+d3-1<n and isValid(s.substr(d1+d2,d3)) and  d1+d2+d3<n and isValid(s.substr(d1+d2+d3,n-(d1+d2+d3))) ){
                                ans.push_back(s.substr(0,d1)+"."+s.substr(d1,d2)+"."+s.substr(d1+d2,d3)+"."+ s.substr(d1+d2+d3,n-(d1+d2+d3)));
                            }
                        }
                    }
                }
            }
        }


        return ans;
    }
};
```

