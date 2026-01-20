Start sorting from last digit
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/18f10d94-adef-45b9-ae25-c22e3d96dc05--image.png)

At each level sorting with the help of counting sort
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/22a7f9d7-994b-416c-b6fd-2ff9045853dd--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/4fc9c922-553f-4af6-b75e-18f108807cfa--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/cc41de22-4695-4774-85f7-9ab775ee789d--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/01b2a46e-99c1-49f8-849d-a55e5470de99--image.png)



for any base
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/0f953267-8047-4e7c-b2c9-a9e067d2defb--image.png)

[Radix Sort | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/radix-sort/1)

```cpp
void radixSort(int v[], int n) { 
    for(int t=0;t<3;t++){
        vector<int> cnt(10,0),aux(n);
        for(int i=0;i<n;i++){
            cnt[(v[i]/int(pow(10,t)))%10]++;
        }
        for(int i=1;i<10;i++){
            cnt[i]+=cnt[i-1];
        }
        for(int i=n-1;i>=0;i--){
            aux[cnt[(v[i]/int(pow(10,t)))%10]-1]=v[i];
            cnt[(v[i]/int(pow(10,t)))%10]--;
        }
        
        for(int i=0;i<n;i++){
            v[i]=aux[i];
        }
    }
} 
```

