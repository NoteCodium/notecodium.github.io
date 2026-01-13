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

		//understood clearly till here

    for(int i=1;i<range;i++){
        freq[i]+=freq[i-1];
    }

    //do it reverse to make it stable
    for(int x: v){
				//one less then then the cumulative frequency will be the position
        ans[freq[x-minn]-1]=x;
        freq[x-minn]--;
    }
    return ans;
}
```

TC and SC as of Now 

![image.png](/images/image-156.png)



vs



```
    for(int x: v){
        freq[x-minn]++;
    }
```





- More disadvantages

Objects as input lets take example pair as input

![image.png](/images/image-157.png)

Not itirating or frequency array but on the original array

![image.png](/images/image-158.png)

![image.png](/images/image-159.png)







![image.png](/images/image-160.png)

![image.png](/images/image-161.png)

The first occurence of 2 will be place at last











It is linear only if the difference between elements is small









# Radix sort