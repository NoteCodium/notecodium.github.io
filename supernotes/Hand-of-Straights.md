[Hand of Straights - LeetCode](https://leetcode.com/problems/hand-of-straights/description/)


![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/fb29cb86-3e7c-4098-bcf5-2daaa4433da5--image.png)

same io 
[Divide Array in Sets of K Consecutive Numbers - LeetCode](https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/description/)

[Hand of Straights - Leetcode 846 - Python - YouTube](https://www.youtube.com/watch?v=amnrMCVd2YI)

```cpp
bool isNStraightHand(vector<int>& v, int g) {
    int n=v.size();
    if(n%g) return 0;
    map<int, int> m;
    for (int x: v) {
        m[x]++;
    }
    
    while (!m.empty()) {
        int curr = m.begin()->first;
        for (int i = 0; i < g; i++) {
            if (m[curr + i] == 0) {
                return 0;
            }
            m[curr + i]--;
            if (m[curr + i] < 1) {
                m.erase(curr + i);
            }
        }
    }
    
    return 1;
}
```
