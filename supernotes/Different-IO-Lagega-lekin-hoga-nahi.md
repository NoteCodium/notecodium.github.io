[Rearrange String (hard)](https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/63a1e63eb231098e09f3c6b1)

Given a string, find if its letters can be rearranged in such a way that no two same characters come next to each other.

```cpp
string rearrangeString(const string &s) {
  string ans;
  unordered_map<char,int> m;
  for(char c: s) m[c]++;
  vector<pair<int,char>> tmp;
  for(auto p: m) tmp.push_back({p.second,p.first});
  priority_queue<pair<int,char>> pq(tmp.begin(),tmp.end());
  while(!pq.empty()){
    vector<pair<int,char>> tmp2;
    while(!pq.empty()){
      auto p=pq.top();pq.pop();
      ans+=p.second;
      if(p.first-1>0) tmp2.push_back({p.first-1,p.second});
    }
    for(auto pp: tmp2) pq.push(pp);  
  }
  return ans;
}
```

Will give you wrong answer at
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/331b2c23-34e3-4f79-84ce-e3e398832fa7--image.png)


```cpp
string rearrangeString(const string &s) {
  string ans;
  unordered_map<char,int> m;
  for(char c: s) m[c]++;
  vector<pair<int,char>> tmp;
  for(auto p: m) tmp.push_back({p.second,p.first});
  priority_queue<pair<int,char>> pq(tmp.begin(),tmp.end());
  while(!pq.empty()){
    vector<pair<int,char>> tmp2;
    int req_len=2;
    int curr_len=0;
    while(curr_len!=req_len){
      auto p=pq.top();pq.pop();
      ans+=p.second;
      if(p.first-1>0) tmp2.push_back({p.first-1,p.second});
      curr_len++;
      if(pq.empty()) break;
    }
    for(auto pp: tmp2) pq.push(pp);  
  }
  return ans;
}
```


# Nice solution
```coo
using namespace std;

#include <iostream>
#include <queue>
#include <string>
#include <unordered_map>
#include <vector>

class Solution {
public:
  struct valueCompare {
    char operator()(const pair<int, int> &x, const pair<int, int> &y) {
      return y.second > x.second;
    }
  };

  string rearrangeString(const string &str) {
    unordered_map<char, int> charFrequencyMap;
    for (char chr : str) {
      charFrequencyMap[chr]++;
    }

    priority_queue<pair<char, int>, vector<pair<char, int>>, valueCompare> maxHeap;

    // add all characters to the max heap
    for (auto entry : charFrequencyMap) {
      maxHeap.push(entry);
    }

    pair<char, int> previousEntry(-1, -1);
    string resultString = "";
    while (!maxHeap.empty()) {
      pair<char, int> currentEntry = maxHeap.top();
      maxHeap.pop();
      // add the previous entry back in the heap if its frequency is greater than zero
      if (previousEntry.second > 0) {
        maxHeap.push(previousEntry);
      }
      // append the current character to the result string and decrement its count
      resultString += currentEntry.first;
      currentEntry.second--;
      previousEntry = currentEntry;
    }

    // if we were successful in appending all the characters to the result string, 
    // return it
    return resultString.length() == str.length() ? resultString : "";
  }
};

int main(int argc, char *argv[]) {
  Solution sol;
  cout << "Rearranged string: " << sol.rearrangeString("aappp") << endl;
  cout << "Rearranged string: " << sol.rearrangeString("Programming") 
      << endl;
  cout << "Rearranged string: " << sol.rearrangeString("aapa") << endl;
}

```
