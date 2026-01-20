[Sliding Window Median - LeetCode](https://leetcode.com/problems/sliding-window-median/description/)


1. Solve it  without multiset when learning other medians
2. 

```cpp
class MedianFinder {
    multiset<int,greater<int>> decreasingL;
    multiset<int> increasingH;
public:
    MedianFinder() {
    }
    void removeNum(int x){
        if(decreasingL.find(x)!=decreasingL.end()) decreasingL.erase(decreasingL.find(x));
        else increasingH.erase(increasingH.find(x));
    }


    void addNum(int x) {
        //steps to always maintain an order
        decreasingL.insert(x);
        increasingH.insert(*decreasingL.begin());decreasingL.erase(decreasingL.begin());

        //maintain size
        if(decreasingL.size()<increasingH.size()){
            decreasingL.insert(*increasingH.begin());increasingH.erase(increasingH.begin());
        }
    }
    
    double findMedian() {
        return decreasingL.size()>increasingH.size()?*decreasingL.begin():(*decreasingL.begin()*0.5+*increasingH.begin()*0.5);
    }
};

```
