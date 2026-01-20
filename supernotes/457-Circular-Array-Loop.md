![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/407f4c51-0db9-4aa6-92b3-16ddce0a2cb1--image.png)



```cpp
  bool loopExists(vector<int> &v) {
    int n=v.size();
    if(n==1)return 0;
    for (int i = 0; i < n; i++) {
      if(v[i]==0) continue;   
      bool isForward = v[i] > 0;  
      int slow = i, fast = i;
      do {
            slow = findNextIndex(v, isForward, slow,n);  
            fast = findNextIndex(v, isForward, fast,n);  
            if (fast != -1) {
                fast = findNextIndex(v, isForward, fast,n); 
            }
      } while (slow != -1 && fast != -1 && slow != fast);

      if (slow != -1 && slow == fast) {
        return 1;
      }
    }
    return 0;
  }

private:
  int findNextIndex(vector<int> &v, bool isForward, int currentIndex, int n) {
    bool direction = v[currentIndex] > 0;
    if (isForward != direction) {
      return -1;  
    }

    int nextIndex = (((currentIndex + v[currentIndex]) % n)+n)%n;

    if (nextIndex == currentIndex) {
      nextIndex = -1;
    }

    return nextIndex;
  }
```

