[leetcode.com](https://leetcode.com/problems/next-permutation/description/)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/14ad1e96-4bfa-4091-b823-010bed7e9b30--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/a13e05f3-2aa1-4053-8d75-7e4b07dded5a--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/ef43986a-3172-4701-bd2a-fbec0bd2e010--image.png)

```cpp
void nextPermutation(vector<int>& v) { 
    int n=v.size(); 
    int i=n-2; 
    //n-1 th element will always be in decreasing order
    ////  1 2 3 xxx5 4 3 2 
    while(i>=0 and v[i]>=v[i+1]) i--;
    //i will be the first eleemnt which will be less then its right
    //if the entire series is in decreasing order i will become -1
    if(i>=0){ 
        int j=n-1; 
        while(j>i){ 
            if(v[i]<v[j]){ 
                swap(v[j],v[i]); 
                break; 
            } 
            j--; 
        } 
    }  
    int p1=i+1 , p2=n-1; 
    reverse(v.begin()+p1,v.begin()+p2+1);

}
```
