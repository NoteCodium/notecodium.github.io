![image.png](../images/1c0b3c56-2961-4ad0-855c-b020d3bb7edb--image.png)

![image.png](../images/c94cd667-5be0-43d5-bcd0-4986640892fa--image.png)
![image.png](../images/33d40fc4-a043-4f95-bc07-cbd41df0451c--image.png)

![image.png](../images/30d3cfbc-69a2-4cae-8bf7-957555775d0c--image.png)

```cpp
vector<int> shuffle(vector<int>& v, int n) {
    for(int i=0;i<n;i++){
        v[i]<<=10;
        v[i]|=v[i+n];
    }
    int j=2*n-1;
    for(int i=n-1;i>=0;i--){
        int mask=(1<<10)-1;
        int y=v[i]&mask;
        int x=v[i]>>=10;
        v[j]=y;
        v[j-1]=x;
        j-=2;
    }
    return v;
}
```
