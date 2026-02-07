# ^
1. will be minimum of sorted and onsecutive
see prrof in ppa

2. Max by trie



# Sum of NC2 pairs of ^ ka popcount

![image.png](../images/fe7d7525-739f-4a20-8764-d2887b5c3f41--image.png)

![image.png](../images/7c0a2fce-a87c-4fa5-b3d9-03e7d5876c0c--image.png)

![image.png](../images/8aa8491f-0700-4355-a94f-038691445cda--image.png)

```cpp
ll ans=0;
ll mask=1ll<<31;
while(mask){
  int cnt=0;
  for(int x v) if(x & mask) cnt++;
  ans+=cnt*(n-cnt);
  mask>>=1;
}
```
