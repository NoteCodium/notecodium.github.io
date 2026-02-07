[Just a moment...](https://leetcode.com/problems/minimize-max-distance-to-gas-station/description/)

it doesnt make sense to place the gas station outside the range
![image.png](../images/9f4f8f36-4bf3-4fe6-be47-c38dcc2f061a--image.png)

You are doiing no good to the internal distances

![image.png](../images/89762aaf-8d95-492f-8d1f-aad7d5cfb97e--image.png)

![image.png](../images/335cb2ed-1e38-4658-9db3-b5d4272b583f--image.png)

# In the end
![image.png](../images/4101295e-8e37-4b30-9516-2482e9390d69--image.png)

![image.png](../images/5d70406b-2fcb-4e97-b219-699f520f621a--image.png)

[BS-20. Minimise Maximum Distance between Gas Stations | 3 Approaches | Heap | Binary Search - YouTube](https://youtu.be/kMSBvlZ-_HA?si=5Wum-bST-q5BcfvW)

```cpp
double minmaxGasDist(vector<int>& v, int k) {
//minimise the maximum consecutive distance
    int n=v.size();
    vector<int> newStations(n-1,0);
    for(int newStation=1;newStation<=k;newStation++){
        long double maxSection=-1;
        int idx=-1;
        for(int i=1;i<n;i++){
            long double diff=v[i]-v[i-1];
            long double sectionLen=(long double)diff/(newStations[i-1]+1);
            if(sectionLen>maxSection){
                maxSection=sectionLen;
                idx=i-1;
            }
        }
        newStations[idx]++;
    }

    long double ans=-1;
    for(int i=1;i<n;i++){
        long double diff=v[i]-v[i-1];
        long double sectionLen=(long double)diff/(newStations[i-1]+1);
        ans=max(ans,sectionLen);
    }
    return ans;
}
```
![image.png](../images/65445dba-96ab-4501-9900-8e2da84eb72c--image.png)

![image.png](../images/38504b45-39d7-481a-8056-876a4ae648fa--image.png)

wrong
![image.png](../images/430a3014-9884-4c41-b5bd-1d41e1f8f670--image.png)

![image.png](../images/d7902172-1195-42de-b0f8-f6b82791af09--image.png)



```cpp
bool f(vector<int>& v, long double m,int k, int n){
    int cnt=0;
    for(int i=1;i<n;i++){
        int noInBetween=(int)(v[i]-v[i-1])/m;
        if((long double)(v[i]-v[i-1])==noInBetween*m) noInBetween--;
        cnt+=noInBetween;
    }
    return cnt<=k;
}

double minmaxGasDist(vector<int>& v, int k) {
//minimise the maximum consecutive distance
    int n=v.size();
    long double l=0,h=-1;
    for(int i=1;i<n;i++) h=max(h,(long double)v[i]-v[i-1]);
    long double ans=h;
    while(h-l>1e-6){
        long double m=(l+h)/2;
        if(f(v,m,k,n)){
            ans=m;
            h=m;
        }
        else l=m;
    }
    return ans;
}
```
