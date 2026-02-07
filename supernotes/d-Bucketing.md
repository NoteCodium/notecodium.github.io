![image.png](../images/aff7ae54-9efe-403f-af74-4f4d27da58fd--image.png)
[Maximum Gap - LeetCode](https://leetcode.com/problems/maximum-gap/description/)
![image.png](../images/dad98f99-45d0-449b-9182-1f4fd0b96897--image.png)
![image.png](../images/5fbacafc-a129-48fe-9735-d62173e305bc--image.png)
![image.png](../images/84b7a86a-c0f6-4ac8-b997-ed36fbe7ed68--image.png)
![image.png](../images/ac56b80e-c5e0-48ac-a7b8-142fe03419b6--image.png)
![image.png](../images/857cf1a4-4d5c-4199-bd34-59c53d8bfe0e--image.png)
![image.png](../images/0df41add-4643-4f76-a2eb-c688db932186--image.png)

# Generating BUCKETS

![image.png](../images/3c6bfd11-a46d-400a-a619-19594d91a780--image.png)

If there are elements in the array which belong to this range, those will not belong to the answer, because we proved the minimum answer is 10

![image.png](../images/56768d7a-50d2-47ed-a6dc-a802d15db17c--image.png)

![image.png](../images/9fff718b-e85a-4c8b-a93a-d1cc290fc58a--image.png)

![image.png](../images/7cdd7697-680c-4a14-b6c4-920da95c378a--image.png)

![image.png](../images/aa4627b5-c0a3-4215-9b81-efc91b4994c0--image.png)

![image.png](../images/b251b458-d857-437c-9d67-6e669d853aa2--image.png)


```cpp
 int n= v.size();
 if(n<2) return 0;

int minn=*min_element(it(v)), maxx=*max_element(it(v));
if(minn==maxx) return 0;

int gap=(maxx-minn)/(n-1);
if((maxx-minn)%(n-1)) gap++;

//the buckets 0 to n-1
vector<int> minArr(n,INT_MAX),maxArr(n,INT_MIN);


for(int x: v){
//Traversing all the elements and filling the minArr and maxArr
    int buckNo=(x-minn)/gap;
    minArr[buckNo]=min(minArr[buckNo],x);
    maxArr[buckNo]=max(maxArr[buckNo],x);
}
```


```CPP
int ans=INT_MIN, prev=INT_MIN;


//itirating over the n buckets
for(int i=0;i<n;i++){
    if(minArr[i]==INT_MAX) continue;
    //we dont have any anything inside our this bucket

    //if it comes to this region, it means the bucket
    //have some memebers
    
    if(prev==INT_MIN) prev=maxArr[i];
    //if we dont have a valid prev, then for the firstime 
    //for gaining a prev, then only the comparison start
  
    else{
        ans=max(ans,minArr[i]-prev);
        prev=maxArr[i];
    }
}
```
