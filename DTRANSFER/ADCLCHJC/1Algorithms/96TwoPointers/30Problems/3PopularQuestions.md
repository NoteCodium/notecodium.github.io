---
title: 3PopularQuestions
---

{% raw %}
search suggestion system

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_96TwoPointers_30Problems_3PopularQuestions__att_0001.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_96TwoPointers_30Problems_3PopularQuestions__att_0002.png)

next_permutation   
https://leetcode.com/problems/next-permutation/

1 2 9 13 11

As long as it is increasing from right, that is the biggest permutation which can be made with the numbers   
n-1 will always be increasing   
starting jorney from n-2

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_96TwoPointers_30Problems_3PopularQuestions__att_0003.png)    
 while(i>=0 and v[i]>=v[i+1]) i--;
    //i will be the first eleemnt which will be less then its right    
    //if the entire series is in decreasing order i will become -1

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_96TwoPointers_30Problems_3PopularQuestions__att_0004.png)

```python
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
```

```python
//complete code
class Solution{ 
    public: 
        void nextPermutation(vector<int>& v) { 
            int n=v.size(); 
            int i=n-2; 
            //n-1 th element will always be greater then the right
            ////  1 2 3 xxx5 4 3 2 
            while(i>=0 and v[i]>=v[i+1]) i--;
            //i will be the first eleemnt which will be less then its right
            if(i>=0){ 
                int j=n-1; 
                while(i<j){ 
                    if(v[j]>v[i]){ 
                        swap(v[j],v[i]); 
                        break; 
                    } 
                    j--; 
                } 
            }  
            int p1=i+1 , p2=n-1; 
            reverse(v.begin()+p1,v.begin()+p2+1);
        } 
    };
```

kind of prev_permutation   
https://leetcode.com/problems/previous-permutation-with-one-swap/description/   
https://www.youtube.com/watch?v=qwFSeqYH6jc

1. With one swap, construct that permutation which is lexicographically shorter then it, but it should be the biggest amongst all the ones

Sol.	
Input: arr = [1,9,4,6,7]
Output: [1,7,4,6,9]
Explanation: Swapping 9 and 7.

1. If from right is it is continuously decreasing (it means from left side it is continuously increasing, we wont be able to return lexigraphically less then it)

```python
while(i>=0 and v[i]<=v[i+1]) i--;
//i will point to element which is not in decreasing order from right, 
//now swap it with the first 
//element on the right which is smallet them it ?
```

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_96TwoPointers_30Problems_3PopularQuestions__att_0005.png)

```python
int i=n-2;
while(i>=0 and v[i]<=v[i+1]) i--;
//i will point to element which is not in decreasing order from right
if(i>=0){
        int j=n-1;
        while(j>i){
            if(v[j]<v[i]){
                swap(v[i],v[j]);
                break;
            }
            j--;
        }
    }
```

q. Sort an array of 0,1 and 2

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_96TwoPointers_30Problems_3PopularQuestions__att_0006.png)

0,l,m,h,n-1 now these are broken a little illogically    
0 to l-1   
l to m-1   
m to h (unsorted hain to illogical heen hoga)  IS Uncle MDH unsorted mh    
h+1 to n-1

initialization    
m== 0   
h== n-1

l===0

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_96TwoPointers_30Problems_3PopularQuestions__att_0007.png)

intuition

Doing with some space   
![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_96TwoPointers_30Problems_3PopularQuestions__att_0008.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_96TwoPointers_30Problems_3PopularQuestions__att_0009.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_96TwoPointers_30Problems_3PopularQuestions__att_0010.png)

end will point to first non 2 position from right

start will point to last 0 position from lefts

```python
class Solution {
    public:
        void sortColors(vector<int>& v) {
            int n=v.size();
            int start=0,end=n-1;
            int p=0;
            while(p<=end){
                if(v[p]==2){
                    swap(v[p],v[end]);
                    end--;
                }
                else if(v[p]==0){
                    swap(v[p],v[start]);
                    start++; 
                    p++;
                }
                else{
                    p++;
                }
            }
        }
    };
```

# Mountain subarray

Longest Mountain subarray


The key point is that each element in the array is visited at most twice:

Once during the forward iteration of the outer loop.
At most once more either in the backward loop (for ascending elements) or in the forward loop (for descending elements).

```python
int ans=0;
for(int i=1;i<=n-2;){
    if(v[i-1]<v[i] and v[i]>v[i+1]){
    //probable peak
        int cnt=1;
        //length of peak

        int j=i;
        //going left
        while(j>0 and v[j-1]<v[j]){
            cnt++;
            j--;
        }
        //going right
        while(i<=n-2 and v[i]>v[i+1]){
            cnt++;
            i++;
        }
        ans=max(ans,cnt);
    }
    else{
        i++;
    } 
}
```

Validate an array is mountain or not (remember this is asking about the array, not the subarray)   
So there will be only one peak

```python
bool validMountainArray(vector<int>& v) {
    int n=v.size();
    if(n<3) return 0;
    for(int i=1;i<=n-2;){
        if(v[i-1]<v[i] and v[i]>v[i+1]){
        //find the peak
            int j=i;
        //going left
            while(j>0 and v[j-1]<v[j]){
                j--;
            }
            if(j!=0) return 0;
        //going right
            while(i<=n-2 and v[i]>v[i+1]){
                i++;
            }
            if(i!=n-1) return 0;
            else return 1;
        }
        else i++;
    }
    return 0;
}
```
{% endraw %}
