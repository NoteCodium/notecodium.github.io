```cpp
class Node {
    public:
    T data;
    Node<T> *next;
    Node<T> *child;

    Node(T data) {
        this->data = data;
        next = NULL;
        child = NULL;
    }
};

*****************************************************************/

Node<int> *flattenMultiLinkedList(Node<int> *head) {
    // Write your code here.
}
```


Generics in other languages
more powerful
like macro

compiler write code for you

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/27fc4983-e733-4f91-aa44-c26a7d3237a6--image.png)

typename ==class

evaluated at compile time
this is not a real function, the function is created only when it is called and compiled as source code
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/3eb57967-7967-42c5-93b4-ff8981a4c3b4--image.png)

# Still works
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/fb9e1b16-5823-4a44-83aa-cad4250f8dfe--image.png)

but compiler dependent

# Tough
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/48fd3b4f-d519-41b6-8a12-46cf97f724ad--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/811e3fc5-98c2-408a-a580-47cee4d9fa5a--image.png)