[leetcode.com](https://leetcode.com/problems/stone-game-iv/description/)

![image.png](../images/80ec2e74-ad78-4249-995d-67c064403c30--image.png)

```cpp
bool f(int x){
    if(x<=0) return 0;
    for(int i=1;i*i<=x;i++){
        if(winnerSquareGame(x-i*i)==0) return 1;
    }
    return 0;
}

bool winnerSquareGame(int n) {
    return f(n);
}
```
