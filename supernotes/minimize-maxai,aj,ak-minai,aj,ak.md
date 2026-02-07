[Minimize the absolute difference | InterviewBit](https://www.interviewbit.com/problems/minimize-the-absolute-difference/)

![Sketch%2024-11-2022%201039.png](../images/0765e73c-14cf-45fe-b216-68dc5bbe2916--Sketch%2024-11-2022%201039.png)


![image.png](../images/2be3f922-66c0-48e0-982a-f1109e0d8be1--image.png)
since we cant decrese the maximum

```cpp
int ans=INT_MAX;
int i=0,j=0,k=0;
while(i<A.size() and j<B.size() and k<C.size()){
    int a=A[i],b=B[j], c=C[k];
    int minn=min({a,b,c}),maxx=max({a,b,c});
    ans=min(maxx-minn,ans);
    if(a==minn) i++;
    else if(b==minn) j++;
    else k++;
}
```
we stop whenever any of the pointer crosses the array boundary, it would has been the minimum among the theee, which is crossing. Now, moving the other two will just going to increase the maxima since your minima is fixed and stuck in the array end

