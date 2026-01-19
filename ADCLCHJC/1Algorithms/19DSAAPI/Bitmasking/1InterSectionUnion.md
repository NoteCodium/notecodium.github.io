![image.png](1InterSectionUnion_images/image.png)


![image.png](1InterSectionUnion_images/image.png)


do logo ke beech common fruits nikalne hain


representation of food by a number    


![image.png](1InterSectionUnion_images/image.png)


if the number of things exceed 64 we have to use bitset    
    discusses smewhere


```python
vector<ll> masks(noOFPeople, 0);
for(int i=0;i<noOfPeople;i++){
    ll mask=0;
    int daysWorkerWorked;
    cin>>daysWorkerWorked;
    for(int j=0;j<daysWorkerWorked;j++){
        int day;
        cin>>day;
        mask=(mask|(1<<day));
    }
}

ll ans=0;
//find two person working on maximum no of same days
for(int i=0;<noOfPeople;i++){
    for(int j=i+1;j<noOfPeople;j++){
        ll intersection=masks[i]&masks[j];
        ll commonDays=__builtin_popcount_ll(intersection);
        ans=max(ans,commonDays+totalDays);
    }
}

```




```python

```
