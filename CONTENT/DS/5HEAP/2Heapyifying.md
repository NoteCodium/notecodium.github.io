1. Heapify To build a heap rooted at i if its left and right child are already root of heaps
2. Leaves are already heaps

https://www.geeksforgeeks.org/problems/heap-sort/1

# Bubbling it up

1. level order wise up to down

![image.png](/images/image-366.png)

![image.png](/images/image-367.png)

![image.png](/images/image-368.png)

Leaves are already heaps

```cpp
void buildHeap(int v[], int n)  { 
    //the element at index 0 is already bigger then its parent
    for(int i=1;i<n;i++){
        int j=i;
        //jab jab children apne parent se bada hai toh swap kardo 
        //aur us parent par chale jao kyu ab ho sakta hain 
        //nai inconsistancies ayi hon
        while(j>0 and v[j]>v[(j-1)/2]){
            swap(v[j],v[(j-1)/2]);
            j=(j-1)/2;
        }
    }
}
```

![image.png](/images/image-369.png)



# Building a heap in linear time



lst and rst are heaps and we introduced root as a new element   

![image.png](/images/image-370.png)

- we can build heap rooted at a new node in O(logn) time if the lst and rst are heaps

![image.png](/images/image-371.png)

1. we are going bottom from top this time
2. we have to run our heapify algorithms only on the non leaf nodes  



```cpp
//Top to bottom
//so we will require child indices
    
void heapify(int v[], int n, int i)  {
    if(i>=n/2){
        //the leaf nodes
        return;
    }
 
    int maxIdx=i;
    if(2*i+1<=n-1 and v[2*i+1]>v[maxIdx]) maxIdx=2*i+1;
    if(2*i+2<=n-1 and v[2*i+2]>v[maxIdx]) maxIdx=2*i+2;

    if(maxIdx!=i){
        swap(v[i],v[maxIdx]);
        heapify(v,n,maxIdx);
    }
}

void buildHeap(int v[], int n)  { 
    //first non leaf node
    for(int i=n/2-1;i>=0;i--){
        heapify(v,n,i);
    } 
}
```

![image.png](/images/image-372.png)

# Doing sort with it

https://www.geeksforgeeks.org/problems/heap-sort/1

```cpp
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
						//v[0] contain the root, the biggest element 
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

    

https://neetcode.io/problems/heap