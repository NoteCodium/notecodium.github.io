[Sum of Two Integers - LeetCode](https://leetcode.com/problems/sum-of-two-integers/description/)
![image.png](../images/b4c6eb37-ea73-41db-b4f5-a1a5843fbad3--image.png)

If not addition, then possible to simulate by ^
![image.png](../images/b4ee0016-93ea-4e02-9c4d-4434718a956a--image.png)

![image.png](../images/d7cbd993-a248-497a-82c4-b749347965f8--image.png)

Perfectly simulated by ^ except the carry 

carry when both are 1 found by &, but that carry will be added by changing one 

We are just writing the code of adddition, so as long as the bit representation of the negative numbers are correct, we will get the correct value

```cpp
int getSum(int sum, int carry) {
    while(carry){
        int tmp=sum;
        //present state of the number
        sum=sum^carry;
        carry=(tmp&carry)<<1;
    }
    return sum;
}
```