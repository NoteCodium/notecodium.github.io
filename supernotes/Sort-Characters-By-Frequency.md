[Sort Characters By Frequency - LeetCode](https://leetcode.com/problems/sort-characters-by-frequency/description/)

```coo
static bool cmp(pair<char, int> &a, pair<char, int> &b){
    return a.second>b.second;
}

string frequencySort(string s) {
    unordered_map<char, int> m;
    for(char c: s) m[c]++;
    vector<pair<char, int>> v(it(m));
    sort(it(v),cmp); 
    string sorted;
    for(auto p:v){
        int times=p.second;
        while(times--) sorted+=p.first;
    }
    return sorted;
}   

```