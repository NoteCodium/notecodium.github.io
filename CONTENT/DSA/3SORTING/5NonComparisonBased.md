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

https://practice.geeksforgeeks.org/problems/radix-sort/1

```cpp
void radixSort(int v[], int n) { 
    for(int t=0;t<3;t++){
        vector<int> cnt(10,0),aux(n);
        for(int i=0;i<n;i++){
            cnt[(v[i]/int(pow(10,t)))%10]++;
        }
        for(int i=1;i<10;i++){
            cnt[i]+=cnt[i-1];
        }
        for(int i=n-1;i>=0;i--){
            aux[cnt[(v[i]/int(pow(10,t)))%10]-1]=v[i];
            cnt[(v[i]/int(pow(10,t)))%10]--;
        }
        
        for(int i=0;i<n;i++){
            v[i]=aux[i];
        }
    }
} 
```

