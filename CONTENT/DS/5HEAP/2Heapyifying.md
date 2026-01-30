1. Heapify To build a heap rooted at i if its left and right child are already root of heaps
2. Leaves are already heaps

https://www.geeksforgeeks.org/problems/heap-sort/1

# Bubbling it up

1. level order wise up to down

![image.png](/images/image-366.png)

![image.png](/images/image-367.png)

![image.png](/images/image-368.png)

Leaves are already heaps

```
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

After this do the neetcode problem    

https://neetcode.io/problems/heap

lst and rst are heaps and we introduced root as a new element   

![image.png](/images/image-370.png)

- we can build heap rooted at a new node in O(logn) time if the lst and rst are heaps

![image.png](/images/image-371.png)

1. we are going bottom from top this time
2. we have to run our heapify algorithms only on the non leaf nodes  

