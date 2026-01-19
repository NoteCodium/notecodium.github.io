https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1


![image.png](30MissingNumberDOIT_images/image.png)


popular questions of bits


```python
class Solution {
    public:
    void sort(vector<int> &v) {
        int n=v.size();
        for(int i=0;i<n;i++){
          while(v[i]!=i+1 and v[v[i]-1]!=v[i]){
            int idx=v[i]-1;
            swap(v[i],v[idx]);
          }
        }
      }
    
      vector<int> findTwoElement(vector<int>& v) {
        sort(v);
        int n=v.size();
        vector<int> ans;
        for(int i=0;i<n;i++){
          if(v[i]!=i+1) return {v[i],i+1};
        }
        return {};
      }
  };
```

Once we are done with the cyclic sort, we will iterate through the array to find the number that is not at the correct index. Since only one number got corrupted, the number at the wrong index is the duplicated number and the index itself represents the missing number.


https://leetcode.com/problems/first-missing-positive/description/


Given an unsorted integer array nums.     
Return the smallest      
positive integer that is not present in nums.


![image.png](30MissingNumberDOIT_images/image.png)


# maang


```python
// archieved
void sort(vector<int> &v, int n) {
    for(int i=0;i<n;i++){
        while(v[i]>0 and v[i]<=n and (v[i]!=i+1) and (v[v[i]-1]!=v[i])){
            int idx=v[i]-1;
            swap(v[i],v[idx]);
        }
    }
}

int firstMissingPositive(vector<int>& v) {
    int n=v.size();
    sort(v, n);
    for(int i=0;i<n;i++){
        if(i+1!=v[i]) return i+1;
    }
    return n+1;
}
```

if a number is greater then n (n+1), then offcourse an element from 1 to n is missing


![image.png](30MissingNumberDOIT_images/image.png)


1 se n tak ke heen elements se matlab hain, 


done in array 


https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/63dd9609488110f74a922636


![image.png](30MissingNumberDOIT_images/image.png)


```python
//arcgieved
static vector<int> f(vector<int> &v) {
    int n=v.size();
    for(int i=0;i<n;i++){
        while(v[i]>0 and v[i]<=n and v[i]!=i+1 and v[v[i]-1]!=v[i]){
            int idx=v[i]-1;
            swap(v[i],v[idx]);
        }
    }
    return v;
  }
  
  static vector<int> findNumbers(vector<int> &v, int k) {
      v=f(v);
      vector<int> ans;
      int n=v.size();
      int cnt=0;
      vector<int> extra;
      for(int i=0;i<n;i++){
          if(i+1!=v[i]){
            ans.push_back(i+1);
            cnt++;
            if(cnt==k) break;
            extra.push_back(v[i]);
          }
      }
      int tmp=n;
      while(ans.size()<k){
          ++tmp;
          if(find(extra.begin(),extra.end(),tmp)==extra.end()) ans.push_back(tmp);       
      }
  
      return ans;
  }
```

https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/6393ada834689e585e94a1b9


https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/


```python
//archieved
class Solution {
public:
    vector<int> sort(vector<int> &v) {
      int n=v.size();
      for(int i=0;i<n;i++){
        while(v[i]!=i+1 and v[v[i]-1]!=v[i]){
          int idx=v[i]-1;
          swap(v[i],v[idx]);
        }
      }
      return v;
    }


    vector<int> findDisappearedNumbers(vector<int>& v) {
        v=sort(v);
        int n=v.size();
        vector<int> ans;
        for(int i=0;i<n;i++){
        if(v[i]!=i+1) ans.push_back(i+1);
        }

        return ans;
    }
};
```
