---
title: 7Tough
---

{% raw %}
Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.

nlogn sol   
![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_96TwoPointers_30Problems_7Tough__att_0001.png)

```python
//n   
//https://youtu.be/p-O7FExDH1M?si=t5ZEC1Ezd9XHmL0P
int n=v.size();
if(n==1) return 0;
int minn=INT_MAX,maxx=INT_MIN;
for(int i=0;i<n;i++){
    if(((i!=0) and (v[i-1]>v[i])) or ((i!=n-1) and (v[i]>v[i+1]))){
        minn=min(v[i],minn);
        maxx=max(v[i],maxx);
    }
}
if(minn==INT_MAX and maxx==INT_MIN){
    return 0;
}
int i=0,j=n-1;
while(i<n and v[i]<=minn) i++;
while(j>=0 and v[j]>=maxx) j--;         
return j-i+1;
```

Contest type Question    
You can increment an element, you can perform the operation k times. Return the maximum possible frequency of an element after atmost k operations

=> It implies you can increase an element multiple times also, the only thing is the limit
is k

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_96TwoPointers_30Problems_7Tough__att_0002.png)

```python
int maxFrequency(vector<int>& v, int k) {
    sort(v.begin(),v.end());
    int n=v.size();
    int l=0,h=0;
    long long sum=0;
    int ans=1;
    while(h<n){
        sum+=v[h];
        while(((h-l+1)*v[h])>sum+k){
            sum-=v[l];
            l++;
        }
        ans=max(ans,h-l+1);
        h++;
    }
    return ans;
}
```
{% endraw %}
