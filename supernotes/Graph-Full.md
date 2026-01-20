[Just a moment...](https://leetcode.com/problems/find-the-celebrity/description/)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/91245dda-8350-4efa-ace4-c5cf9f5f9ce4--image.png)


do many questions of MST

Evernotes topic remaining
0. ppa, striver, neetcode
1. Simple graph: Graph without any self loop and multiple edges
  2. If a cycle exist in simple graph, its length will be more then 2

minesweeper
[Minesweeper - LeetCode](https://leetcode.com/problems/minesweeper/)

ppa cf
[Problem - 3A - Codeforces](https://codeforces.com/problemset/problem/3/A)
[Problem - 329B - Codeforces](https://codeforces.com/problemset/problem/329/B)
[SPOJ.com - Problem CHUNK2](https://www.spoj.com/problems/CHUNK2/)
[Problem - B - Codeforces](https://codeforces.com/contest/60/problem/B)
[SPOJ.com - Problem MAKEMAZE](https://www.spoj.com/problems/MAKEMAZE/)

[Problem - 510B - Codeforces](https://codeforces.com/problemset/problem/510/B)

{% raw %}
```cpp
vector<vector<ll>> knight={{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
```
{% endraw %}

{% raw %}
```cpp
vector<vector<ll>> dir={{1,0},{-1,0},{0,1},{0,-1}};
```
{% endraw %}
{% raw %}
```cpp
vector<vector<ll,ll>> king={{1,0},{-1,0},{0,1},{0,-1},{1,-1},{1,1},{-1,1},{-1,-1}};
```
{% endraw %}
# (R,C)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/9ce0dfa6-2eac-4c2c-b0fc-43b76ab190da--image.png)

{% raw %}
```cpp
vector<pair<vector<ll>, char>> dir= {{{1,0},'D'},{{-1,0},'U'},{{0,1},'R'},{{0,-1},'L'}};
```
{% endraw %}

```cpp
bool isValid(ll r, ll c , ll rr, ll cc){
	return r>=0 and r<rr and c>=0 and c<cc;	
}
```

```cpp
for(int r=0;r<rr;r++){
    for(int c=0;c<cc;c++){
        
    }
} 
```

# Edges in worst case
1. (v*(v-1))//2   VC2
2. in n*m matrix, n*m*4//2


# You can convert 2d graph to a 1d graph 

```cpp
map<pair<int,int>,int> m;
```
# Sparse graph having v vertices have
v sqrt v edges
