---
title: 1HeapifyingWagera
---

# Doing sort with it

https://www.geeksforgeeks.org/problems/heap-sort/1

```python
    void heapify(vector<int>& v, int n, int i)  {
        if(i>=n/2) return;
        int maxx=i;
        if(v[2*i+1]>v[maxx]) maxx=2*i+1;
        if(2*i+2<=n-1 and v[2*i+2]>v[maxx]) maxx=2*i+2;
        if(maxx!=i){
            swap(v[i],v[maxx]);
            heapify(v,n,maxx);
        }
    }
    
    void buildHeap(vector<int>& v, int n)  { 
        for(int i=n/2-1;i>=0;i--){
            heapify(v,n,i);
        }
    }
    
    void sortHeap(vector<int>& v, int n) {
        for(int i=n-1;i>=0;){
            swap(v[0],v[i]);
            i--;
            heapify(v,i+1,0);
        }
    }
    
    public:
    void heapSort(vector<int>& v, int n){
        buildHeap(v,n);
        sortHeap(v,n);
    }
```



All the data is stored in the array actually, just for accessing it we use the concepts of tree



![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_4HeapPriorityQueue_1HeapifyingWagera__att_0009.png)

insert    

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_4HeapPriorityQueue_1HeapifyingWagera__att_0010.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_4HeapPriorityQueue_1HeapifyingWagera__att_0011.png)

mind you are using 0 based indexing

Bubbling up a single element only takes logn

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_4HeapPriorityQueue_1HeapifyingWagera__att_0012.png)

# deleteRoot

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_4HeapPriorityQueue_1HeapifyingWagera__att_0013.png)

do size--,   

but you have disturbed the heap property.

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_4HeapPriorityQueue_1HeapifyingWagera__att_0014.png)

invoke heapify at the root

genericDelete

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_4HeapPriorityQueue_1HeapifyingWagera__att_0015.png)

???

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_4HeapPriorityQueue_1HeapifyingWagera__att_0016.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_4HeapPriorityQueue_1HeapifyingWagera__att_0017.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_4HeapPriorityQueue_1HeapifyingWagera__att_0018.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_4HeapPriorityQueue_1HeapifyingWagera__att_0019.png)

invoke deleteRoot

{% endraw %}