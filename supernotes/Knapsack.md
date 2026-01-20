[Fractional Knapsack | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1)
```cpp
static bool cmp(Item &a, Item &b){
    return a.value*b.weight>b.value*a.weight;
}


double fractionalKnapsack(int k, Item v[], int n){
    sort(v,v+n,cmp);
    double ans=0;
    for(int i=0;i<n;i++){
        if(k-v[i].weight>=0){
            k-=v[i].weight;
            ans+=v[i].value;
        }
        else{
            ans+=(k*(v[i].value*1.0)/v[i].weight);
            break;
        }
    }
    return ans;
}
```