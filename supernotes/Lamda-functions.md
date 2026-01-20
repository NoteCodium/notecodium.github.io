# Examples
```cpp
sort(ma.begin(),ma.end(),[](vector<int> &a, vector<int> &b){
    return a[1]<b[1];
});
```
```cpp
#include <functional>

// Define a lambda function that compares two elements
auto cmp = [](int a, int b) {
  return a > b; // This is for a max heap. For a min heap, use a < b.
};

// Use the lambda function with a priority_queue
std::priority_queue<int, std::vector<int>, decltype(cmp)> pq(cmp);
```

1.  We use `decltype(cmp)` to automatically deduce the type of the comparison function.

1. inline, anonymous functions
2. Lambdas are a way to create small, disposable functions without the need to explicitly define a separate function using the traditional function declaration syntax.
```cpp
[capture_clause](parameter_list) -> return_type {
    // function body
}
```

1. `capture_clause`: Specifies which variables from the surrounding scope the lambda function can access. It captures variables by value [x]` or by reference `[&x]`
2. You can also capture all variables used in the lambda function by value `[=]` or by reference `[&]`, or not capture any variables `[]`.
3.   [=] not working
```cpp
#include <iostream>

int main() {
    int x = 10;
    int y = 20;

    // Define a lambda that captures all variables by value
    auto lambda = [=]() {
        return x + y;
    };

    int result = lambda();
    std::cout << "Result: " << result << std::endl;

    return 0;
}

```

1. if the lambda function doesn't take any parameters, you can omit this part.
2.  If the lambda doesn't return a value, you can omit this part or use auto.
   # Example 
   [leetcode.com](https://leetcode.com/problems/find-all-people-with-secret/description/)

```cpp
class Solution {
public:

    class dsu {
    public:
        vector<int> par, size;
        int secret;
        dsu(int n) {
            par.resize(n);
            size.resize(n, 1);
            for (int i = 0; i < n; i++) {
                par[i] = i;
            }
        }

        int find(int x) {
            if (par[x] != x) {
                par[x] = find(par[x]);
            }
            return par[x];
        }

        bool sameRoot(int i, int j) {
            return find(i) == find(j);
        }

        void union_(int i, int j) {
            if (sameRoot(i, j)) {
                return;
            }
            int xRoot = find(i), yRoot = find(j);
            if (size[xRoot] < size[yRoot]) {
                swap(xRoot, yRoot);
            }
            par[yRoot] = xRoot;
            size[xRoot] += size[yRoot];
        }
    };



    vector<int> findAllPeople(int n, vector<vector<int>>& meetings, int firstPerson) {
        dsu d(n);
        d.union_(0, firstPerson);
        d.secret = d.find(0);
        sort(meetings.begin(), meetings.end(), [&d](vector<int>& a, vector<int>& b) {
            if(a[2]!=b[2])return a[2] < b[2];
            int cnta=0,cntb=0;
            if(d.find(a[0])==d.secret) cnta++;
            if(d.find(a[1])==d.secret) cnta++;
            if(d.find(b[0])==d.secret) cntb++;
            if(d.find(b[1])==d.secret) cntb++;
            return cnta>cntb;
        });

        for(auto m: meetings){
            cout<<m[0]<<" "<<m[1]<<" "<<m[2]<<endl;
        }


        
        
        vector<int> ans = {0, firstPerson};
        for (const auto& v : meetings) {
            if(d.find(v[0])==d.secret or d.find(v[1])==d.secret){
                if(d.find(v[0])!=d.secret) ans.push_back(v[0]);
                if(d.find(v[1])!=d.secret) ans.push_back(v[1]);
                d.union_(v[0],v[1]);                
            }
        }
        sort(ans.begin(),ans.end());
        return ans;
    }
};
```
