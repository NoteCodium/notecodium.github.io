[Efficiently sorting numbers in range from 0 to n^2 - 1 | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/efficiently-sorting-number-from-0-to-n2-15444/1)

![image.png](../images/4cbf3794-0614-4840-9acb-aa4e9fbe6fcb--image.png)
vs
![image.png](../images/3e207688-4b76-48ff-933c-093a8adff991--image.png)
 taking b=n

![image.png](../images/3c4a0e61-0d30-4024-94be-d177c7d6c4df--image.png)
This is the representation of the biggest number

After proving any number can be expressed in pnly 2 digits 
![image.png](../images/c2783a73-1702-4130-8f9a-24a43a699e56--image.png)


![image.png](../images/167dc655-4a80-4613-aa4c-c6997e8f16e5--image.png)

![image.png](../images/fb4201d2-6188-4197-a0fa-d1b5f1d85896--image.png)

![image.png](../images/cda2eec7-ff9c-410b-84f6-b14228612df1--image.png)

```cpp
void sort(int v[], int n) {
    int b=n;
    vector<int> cnt(b,0),tmp(b);
    for(int i=0;i<n;i++) cnt[v[i]%b]++;
    for(int i=1;i<n;i++) cnt[i]+=cnt[i-1];
    for(int i=n-1;i>=0;i--){
        tmp[cnt[v[i]%b]-1]=v[i];
        cnt[v[i]%b]--;
    }
    for(int &x:cnt) x=0;
    for(int i=0;i<n;i++) cnt[(tmp[i]/b)%b]++;
    for(int i=1;i<n;i++) cnt[i]+=cnt[i-1];
    for(int i=n-1;i>=0;i--){
        v[cnt[(tmp[i]/b)%b]-1]=tmp[i];
        cnt[(tmp[i]/b)%b]--;
    }
}
```

