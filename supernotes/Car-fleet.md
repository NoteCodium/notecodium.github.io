[Car Fleet - LeetCode](https://leetcode.com/problems/car-fleet/description/)



![image.png](../images/ab53e22c-ffbf-4a55-b610-07f48215784f--image.png)

![image.png](../images/3ec67f98-cee4-452d-9f5a-1a7f6b296682--image.png)

After intersection their speed will be equal to the speed of the lower car

![image.png](../images/a918e70b-09f4-4d99-b8b4-b3880be7be64--image.png)



![image.png](../images/42ee35af-3e79-4f60-ad03-ed8cd7000467--image.png)

[Car Fleet - Leetcode 853 - Python - YouTube](https://youtu.be/Pr6T-3yB9RM?si=p0tUApZDau0_rrmS)


```cpp
int carFleet(int k, vector<int>& p, vector<int>& s) {
    int n = p.size();
    
    vector<pair<int, double>> v;
    for (int i = 0; i < n; i++) {
        double time = (double) (k- p[i]) / s[i];
        v.push_back({p[i], time});
    }
    sort(v.begin(), v.end());
    
    stack<double> times;
    
    for (int i = n - 1; i >= 0; i--) {
        double time = v[i].second;
        if (times.empty() || time > times.top()) {
            times.push(time);
        }
    }
    return times.size();
    
}
```