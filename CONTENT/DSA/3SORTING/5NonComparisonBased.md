![image.png](/images/image-89.png)



# Count sort

```
vector<int> sortArray(vector<int>& v) {
    int n=v.size();
    vector<int> ans(n);
    int maxx=*max_element(v.begin(),v.end()),minn=*min_element(v.begin(),v.end());
    int range=maxx-minn+1;
    vector<int> freq(range,0);
    for(int x: v){
        freq[x-minn]++;
    }
    for(int i=1;i<range;i++){
        freq[i]+=freq[i-1];
    }

    //do it reverse to make it stable
    for(int x: v){
        ans[freq[x-minn]-1]=x;
        freq[x-minn]--;
    }
    return ans;
}
```





# Radix sort

