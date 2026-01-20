[practice.geeksforgeeks.org](https://practice.geeksforgeeks.org/problems/generate-binary-numbers-1587115620/1)

```cpp
queue<ll> q;
q.push(1);
while(n--){
  ll x=q.front();q.pop();
  q.push(x*10);
  q.push(x*10+1);
}
```