# TC

![](../../../images/20260111_045947_image.png)

# Bubble sort

1. Iteration 1/ Pass 1
2. n-1 pairwise comparisons
3. Biggest element/biggest bubble in the end

![](../../../images/20260111_044343_image.png)

![](../../../images/20260111_045842_image.png)



```cpp
class Solution {
public:
    vector<int> sortArray(vector<int>& v) {
        //Bubble sort
        int n=v.size();
        for(int iter=1;iter<=n-1;iter++){
            //no. of swaps== n-iter
            int sorted =1;
            for(int noOfSwaps=1;noOfSwaps<=n-iter;noOfSwaps++){
                if(v[noOfSwaps-1]>v[noOfSwaps]){
                    swap(v[noOfSwaps-1],v[noOfSwaps]);
                    sorted=0;
                }
            }
            if(sorted){
                break;
            }
        }
        return v;
    }
};
```
