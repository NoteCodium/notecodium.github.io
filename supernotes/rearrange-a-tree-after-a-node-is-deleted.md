[Delete Node in a BST - LeetCode](https://leetcode.com/problems/delete-node-in-a-bst/description/)

1. can be many ways
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/2a30c614-9d5a-49ab-b57c-f69a3aa97390--image.png)

# Brute force
1. generate an array out of tree
2. delete element 
3. generate tree out of array

Always track the parent of the node to be deleted

# Method
### Leaf node:
1. Easiest to delete


### Type 2: Single children node
![WhatsApp%20Image%202023-11-14%20at%2011.33.52_afd5f369.jpg](https://supernotes-resources.s3.amazonaws.com/image-uploads/9c79c2a4-23e3-4bb4-9327-a49bedd37db9--WhatsApp%2520Image%25202023-11-14%2520at%252011.33.52_afd5f369.jpg)

1. similarly for a node having lst only


### Type 3: node have both lst and rst
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/3629ebff-d0e8-4e92-9142-141d39bc30b7--image.png)

bring 18, the largest node of the lat
or
the smallest node of the rst

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/fca91d3e-f425-42dc-bcce-2d67fc3de184--image.png)