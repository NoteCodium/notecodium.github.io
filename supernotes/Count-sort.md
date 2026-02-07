[Sort an Array - LeetCode](https://leetcode.com/problems/sort-an-array/description/)
```cpp
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







# Step by step

Frequency based sorting
TC: O(max_element)


If elements till 10^5
![image.png](../images/25ad87dd-e52e-4d27-8172-91d324c918f7--image.png)


# Problem of negative numbers
![image.png](../images/733e75a2-d4d1-4b97-91cb-6c235c999905--image.png)
![image.png](../images/d98f3f2d-de9d-4f23-bd6b-6c76acb8cde2--image.png)

1. this can be used to optimize our space for positive elemets only

![image.png](../images/f2dfba20-abea-4e70-9d81-f640e7fba19f--image.png)


# Shortcomes
1. Sorting pair of integers
![image.png](../images/59625770-9e41-434d-b764-5d40cf270b2f--image.png)

once you cnt 4 frequencies together how you will distinguish between the two pairs

# Next approach TC: O(maxx-minn) or O(n)
![image.png](../images/dcfc2008-2d75-4bdb-a665-f8ebbed9d158--image.png)
![image.png](../images/524dab00-ba51-4b01-ae2d-86aab650aa89--image.png)

![image.png](../images/4a73d17a-5763-4f79-a83a-9998522c3810--image.png)

# Not maintinaing stability, infact highly unstable

# Start from end of the input array to make it stable