---
title: 2Permutations
---

{% raw %}
Generate permutations of a given array with distinct elements.

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_80RandB_Generate_2Permutations__att_0001.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_80RandB_Generate_2Permutations__att_0002.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_80RandB_Generate_2Permutations__att_0003.png)

swapping the starting element with all the elements till the end

```python
void f(idx){
	if(idx==n-1){
		ans.pb(v);
		return;
	}
	for(int i=idx;i<n;i++){
		swap(s[idx],s[i]);
		f(i+1);
		swap(s[idx],s[i]);
	}
}
```
{% endraw %}
