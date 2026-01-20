1. array is stored as a binary tree
2. Not necessary a sorted array
3. Till now we have implemented trees using pointers
4. Each root to leaf path will be sorted
5. We will implement the array as  a tree usig the below formulae
6. ![WhatsApp%20Image%202023-11-18%20at%2018.26.22_e929cd5c.jpg](https://supernotes-resources.s3.amazonaws.com/image-uploads/e9ea8d5c-2d40-48ab-af64-3e7c17f67b7f--WhatsApp%2520Image%25202023-11-18%2520at%252018.26.22_e929cd5c.jpg)
2i+1 and 2*i+2

parent of node having idx (idx-1)//2


1. The binary tree will be Complete binary tree (filled level by level from left to right)
2. For such a tree there is a only one node which has one chldren, rest of all nodes have either 2 children or 0 children (leaves)
3. There will be n//2 nodes (which have 2 or 1 children) and n//2 leave nodes


![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/17902687-ad2d-4d2b-9d87-055e9e299e44--image.png)

1. for heap, every parent will be greater then its children


1. All subtree are individually heap
2. Lets take a tree which is not heap
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/d0441754-06fd-4e97-a6c6-fb8862c86e72--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/32856649-be68-4f61-991f-b5204e9b3fa3--image.png)
Disturbed the left part
1. Leaves are already heaps

# Heapify
To build a heap rooted at i if its left and right child are already root of heaps



