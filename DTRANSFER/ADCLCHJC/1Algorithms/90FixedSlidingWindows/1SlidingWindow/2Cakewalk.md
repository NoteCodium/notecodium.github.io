---
title: 2Cakewalk
---

{% raw %}
![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_90FixedSlidingWindows_1SlidingWindow_2Cakewalk__att_0001.png)   
https://www.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_90FixedSlidingWindows_1SlidingWindow_2Cakewalk__att_0002.png)

```python
int minSwap(int v[], int n, int k) {
    int ws=0;
    for(int x: v) if(x<=k) ws++;
    if(ws==0) return 0;
    int cnt=0,maxx=0;
    for(int i=0;i<=ws-2;i++) if(v[i]<=k) cnt++;
    for(int i=ws-1;i<n;i++){
        if(v[i]<=k) cnt++;
        maxx=max(maxx,cnt);
        if(v[i-ws+1]<=k) cnt--;
    }
    return ws-maxx;
}
```
{% endraw %}
