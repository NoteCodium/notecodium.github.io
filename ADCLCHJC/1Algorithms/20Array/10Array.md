# Theory


Rotate k units in cw direction:  
![image.png](10Array_images/image.png)


the starting index of the parts will be  
1. 0   (the length of this portion is n-k, with last number having idx of n-k-1)
2. n-k (this part have lenght of k as asked in question)


![image.png](10Array_images/image.png)  



# Problems


Given a circular array, find the max sum of a subarray 


https://leetcode.com/problems/maximum-sum-circular-subarray/description/


```python
int ans1=kadaneMaxSum(v);
int sumArray=accumulate(it(v),0);
int minSumSubarray=kadaneMinSum(v);
//but if all the elements are negative
//sumArray==minSumSubarray
//in these scenerios, you will get
//sumArray-minSumSubarray==0, which is not true
if(sumArray==minSumSubarray){
    return ans1;
}
int ans2=sumArray-minSumSubarray;
return max(ans1,ans2);
```

```python
//kadane Max sum
int currSum=0;
int ans=-inf;
for(int x: v){
    currSum+=x;
    if(currSum>ans){
        ans=currSum;
    }
    if(currSum<0){
        currSum=0;
    }
}
return ans;
```

Find max difference bw two consecutive elements in sorted form  


https://leetcode.com/problems/maximum-gap/description/


```python
int minn=*min_element(it(v)),maxx=maxEl(v);
if(n==1 or minn==maxx){
    return 0;
}
int minValOfMaxDifBwConsecutiveElem=(maxx-minn)/(n-1);
if((maxx-minn)%(n-1)){
    minValOfMaxDifBwConsecutiveElem++;
}
//A little unintuitive: No. of buckets will also be n
vi minOfBuc(n,inf),maxOfBuc(n,-inf);
```

```python
//Filling the buckets
for(int x: v){
    int bucNo=(x-minn)/minValOfMaxDifBwConsecutiveElem;
    minOfBuc[bucNo]=min(minOfBuc[bucNo],x);
    maxOfBuc[bucNo]=max(maxOfBuc[bucNo],x);
}
```

```python
//finding the answer with the filled buckets
int ans=-inf;
int prev=inf;
for(int i=0;i<n;i++){
    //the bucket do not have any element
    if(maxOfBuc[i]==-inf){
      continue;
    }
    //if prev is  not populated so far
    if(prev==inf){
      prev=maxOfBuc[i];
      continue;
    }
    ans=max(ans,minOfBuc[i]-prev);
    prev=maxOfBuc[i];
}
```

An array contains elements from 0 to n-1  
An array can be divided into some chunks  
Sort the individual chunks  
concatanate the sorted chunks  
The result should be a sorted array  
Maximise the number of chunks  


https://leetcode.com/problems/max-chunks-to-make-sorted/description/


Max answer when the array is sorted, can be divided into n chunks  
Worst case sorted in descending order, in that case only 1 chunk  



```python
int chunks=0;
int l=0,h=0;
while(h<n){
    if(canBeChunked(v,l,h)){
      chunks++;
      l=h+1;
      h=l;
    }
    else{
        h++;
    }
}
```

```python
//canBeChunked
for(int k=i;k<=j;k++){
    if(v[k]<i or v[k]>j){
      return 0;
    }
}
return 1;
```

optimized solution with a observation  
![image.png](10Array_images/image.png)


whenever idx==pre_max    
    chunks++


```python
int chunks=0;
int curMax=-inf;
for(int i=0;i<n;i++){
  curMax=max(curMax,v[i]);
  if(curMax==i){
    chunks++;
  }
}
```

https://leetcode.com/problems/trapping-rain-water/description/


How much water a solid histogram can trap


![image.png](10Array_images/image.png)


```python
vi preMax=preMaxCalc(v),postMax=postMaxCalc(v);
int trappedWater=0;
for(int i=1;i<=n-2;i++){
  int heightLeft=preMax[i-1],heightRight=postMax[i+1];
  int decide=min(heightLeft,heightRight);
  if(decide>v[i]){
    trappedWater+=decide-v[i];
  }
}
```

Q Sum of all subsequences in an array


![image.png](10Array_images/image.png)


```python
int sumArray=sumArrayCalc(v);
//Change this sum according to modulo
return modm(mpow(2,n-1),sumArray);
```

sum of all the subarrays of the array


![image.png](10Array_images/image.png)


```python
for(int i=0;i<n;i++){
    int contributionOfEachEl=modm(v[i],modm((i+1),(n-i)));
    ans=moda(ans,contributionOfEachEl);
  }
```

# Missing problem on AZ


![image.png](10Array_images/image.png)


![image.png](10Array_images/image.png)


Find link of above problem


https://maang.in/problems/Count-Distinct-Char-in-Substrings-62?resourceUrl=cs99-cp512-pl3478-rs62


the string consisit of lowercase letters only  
score of a substring == no. of distant chars in it  
Find sum of all the score of substrings in a string  



There can be this many subarrays each can have a maximum score of 26


![image.png](10Array_images/image.png)


Solution  
![image.png](10Array_images/image.png)


```python
void solve(){
    iinp(n);
    sinp(s);
    vl prev(26,-1);
    ll totNumOfSubarrays=13*n*(n+1);
    ll ans=0;
    for(ll i=0;i<n;i++){
        char c=s[i];
        ll len=i-prev[c-'a']-1;
        // a b c d e a
        // 0 1 2 3 4 5
        //b c d e 
        //i-prevIdxOfa-1
        ans+=totNumOfSubarrays-(len*(len+1))/2;
        prev[c-'a']=i;        
    }
    for(ll i=0;i<26;i++){
        ll len=n-prev[i]-1;
        ans+=(totNumOfSubarrays-(len*(len+1))/2;)
    }
    cout<<totNumOfSubarrays<<endl;
}
```

# The famous codeforces question    



find its link by ppa


![image.png](10Array_images/image.png)


# MAANG


Perplex code-o-fiesta     
[Programming Problems and Competitions :: HackerRank](https://www.hackerrank.com/contests/code-o-fiesta-2-0/challenges/perplex)     


