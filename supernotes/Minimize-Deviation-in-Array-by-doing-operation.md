[leetcode.com](https://leetcode.com/problems/minimize-deviation-in-array/description/)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/991e5940-3270-42a1-b719-ea270dd1c002--image.png)

The deviation of the array is the maximum difference between any two elements in the array.

Return the minimum deviation the array can have after performing some number of operations.


# Obervations
1. Odd numbers in the array will oscillate between x and 2x
2. even no divide by 2, now what it becomes next decides its fate

```cpp
int minimumDeviation(vector<int>& v) {
    priority_queue<int> pq;
    int minn=INT_MAX, diff=INT_MAX;
    //increase maxima
    //after increasing all the odds by *2,
    //we could not furthur increase the minima
    for(int x: v){
        if(x%2) x*=2;
        minn=min(minn,x);
        pq.push(x);
    } 

    //as long as maxima is even we can decrease the maxima
    
    while(pq.top()%2==0){
        int maxx=pq.top();pq.pop();
        diff=min(diff,maxx-minn);
        minn=min(minn,maxx/2);
        pq.push(maxx/2);
    }
    return min(diff,pq.top()-minn);

}
```




