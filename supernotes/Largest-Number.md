[Largest Number - LeetCode](https://leetcode.com/problems/largest-number/description/)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/aba89f38-54cc-4bca-a7b5-ef6a05807a16--image.png)

# Edge case when all 0

0, 0, 0 

will return 000

1. thinking why a> b will not work due to 30 and 3
2. a+b> b+ a


```cpp
static bool cmp(string &a, string &b){
    return a+b>b+a;
}

string largestNumber(vector<int>& v) {
    vector<string> vos;
    int n=v.size();
    for(int x: v){
        vos.push_back(to_string(x));
        if(x==0) n--;
    } 
    if(n==0) return "0";
    sort(vos.begin(),vos.end(),cmp);
    string ans;
    for(string s: vos) ans=ans+s;
    return ans;
}
```