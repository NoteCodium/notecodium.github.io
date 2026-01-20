[Just a moment...](https://leetcode.com/problems/kth-missing-positive-number/description/)

[BS-16. Kth Missing Positive Number | Maths + Binary Search - YouTube](https://youtu.be/uZ0N_hZpyps?si=Y1eCIrlSH4cOGTbD)




# Brute force with logic
```cpp
int findKthPositive(vector<int>& v, int k) {
    int n=v.size();
    int cnt=0;
    int ans=k;
    for(int i=0;i<n;i++){
        if(v[i]<=ans) ans++;
        else break;
    }
    return ans;
}
```
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/70067dbb-144c-4299-9d91-be2ea4c6addf--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/312009de-1e8c-4f7c-92cc-6dfcf128aa97--image.png)

1. we know for each index how many elements till that idx is missing
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/121b5e4e-4291-4519-82ac-8099516150db--image.png)

```cpp
int findKthPositive(vector<int>& v, int k) {
    int n=v.size();
    int l=0,h=n-1;

    //total elements missing in array 
    int totalMissingElements=v[n-1]-n;
    if(k>totalMissingElements) return v[n-1]+(k-totalMissingElements);

    int totalMissingElementsBeforeArrayStart=v[0]-1;
    if(k<=totalMissingElementsBeforeArrayStart) return k;

    int ansIdx;
    while(l<=h){
        int m=(l+h)/2;
        int missingTillM=v[m]-(m+1);    
        if(missingTillM<k){
            ansIdx=m;
            l=m+1;
        }
        else h=m-1;
    }
    return v[ansIdx]+k-(v[ansIdx]-(ansIdx+1));
}
```

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/e84f08b5-7aa0-49d8-99ca-b9e23f43e054--image.png)
