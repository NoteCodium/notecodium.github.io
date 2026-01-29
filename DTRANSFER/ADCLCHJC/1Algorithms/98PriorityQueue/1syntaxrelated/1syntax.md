---
title: 1syntax
---

{% raw %}
```python
auto cmp=[&](auto, auto ){

}

priority_queue<T,vector<T>,decltype(cmp)> pq(cmp);  
```

```python
priority_queue<int, vector<int>, greater<int>> pq;
set<int, greater<int>> se;
sort(it(v), greater<int>()); //sort easy hain to kisi tarah to mushkil banayenge
```

Starting from basics of PQ Syntax

```python

// Start with a structure named cmp
struct cmp{

};

// Bracket operator overloaded
struct cmp{
	bool operator()(int &a, int &b){
		return a>b;
	}
};

int main(){
	priority_queue<int, vector<int>, cmp> pq;
}
```

inline

```python
auto cmp=[&](auto &a, ){
//check input
//lamda capture
};

// For intializing with a vector
priority_queue<int> pq(v.begin(),v.end());

priority_queue<int, vector<int>, decltype(cmp)> pq(cmp);
// Note the redundancy

//mixture of above two concepts
priority_queue<int,vector<int>,decltype(cmp)> pq(v.begin(),v.end(),cmp);
//check this

sort(it(v),[](auto &a, ){});

//set requires the comparator to accept constant reference
auto cmp=[&](const auto &a, ){
    //check input
    //lamda capture
    };

set<int, decltype(cmp)> se(cmp);
//see the similaraity with priority queue
```
{% endraw %}
