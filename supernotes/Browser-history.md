can be done by ll also
[Design Browser History - LeetCode](https://leetcode.com/problems/design-browser-history/description/)
# Stack

```cpp
class BrowserHistory {
    stack<string> his, fut;
    string curr;
public:
    BrowserHistory(string homepage) {
        curr = homepage;
    }
    
    void visit(string url) {
        his.push(curr);
        curr=url;
        fut=stack<string>();
    }
    
    string back(int steps) {
        while(steps > 0 and !his.empty()) {
            fut.push(curr);
            curr = his.top();
            his.pop();
            steps--;
        }
        return curr;
    }
    
    string forward(int steps) {
        while(steps > 0 && !fut.empty()) {
            his.push(curr);
            curr = fut.top();
            fut.pop();
            steps--;
        }
        return curr;
    }
};

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory* obj = new BrowserHistory(homepage);
 * obj->visit(url);
 * string param_2 = obj->back(steps);
 * string param_3 = obj->forward(steps);
 */
```