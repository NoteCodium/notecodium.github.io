# Quick Sort

![image.png](/images/image-69.png)

![image.png](/images/image-70.png)

![image.png](/images/image-71.png)

![image.png](/images/image-72.png)

Worst TC of Quick sort occur when the list is sorted in ascending order or descending order

![image.png](/images/image-74.png)

![image.png](/images/image-75.png)

![image.png](/images/image-76.png)

```
class Solution {
public:
    vector<int> sortArray(vector<int>& v) {
        //Quick sort
        int n=v.size();
        qs(v,0,n-1);
        return v;
    }

    int f(vector<int>& v, int l, int h){
        int pivot=v[l];
        int i=l,j=h;
        while(i<j){
            while(v[i]<=pivot and i<h){
                i++;
            }
            while(v[j]>pivot and j>l){
                j--;
            }
            if(i<j){
                swap(v[i],v[j]);
            }
        }
        swap(v[l],v[j]);
        return j;
    }

    void qs(vector<int>& v, int l, int h){
        if(l<h){
            int pivotIdx=f(v,l,h);
            qs(v,l,pivotIdx-1);
            qs(v,pivotIdx+1,h);            
        }
    }

};
```





# Randomized

do its numerical problems 

```
class Solution {
public:
    vector<int> sortArray(vector<int>& v) {
        //Quick sort
        srand(time(0)); // Seed for random pivot
        int n=v.size();
        qs(v,0,n-1);
        return v;
    }

    int f(vector<int>& v, int l, int h){
        int randomIdx = l + rand() % (h - l + 1);
        swap(v[l], v[randomIdx]); // Move random pivot to start
        int pivot=v[l];
        int i=l,j=h;
        while(i<j){
            while(v[i]<=pivot and i<h){
                i++;
            }
            while(v[j]>pivot and j>l){
                j--;
            }
            if(i<j){
                swap(v[i],v[j]);
            }
        }
        swap(v[l],v[j]);
        return j;
    }

    void qs(vector<int>& v, int l, int h){
        if(l<h){
            int pivotIdx=f(v,l,h);
            qs(v,l,pivotIdx-1);
            qs(v,pivotIdx+1,h);            
        }
    }

};
```

# Randomized

```
int randomIdx = l + (rand() % (h - l + 1));
//rand() % (h - l + 1) generates a number between 0 and range-1
```

