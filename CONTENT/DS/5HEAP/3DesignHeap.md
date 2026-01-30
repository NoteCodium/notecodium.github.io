https://neetcode.io/problems/heap

```cpp
class MinHeap {
    public:
        MinHeap() {}
    
        void push(int val) {
    
        }
    
        int pop() {
    
        }
    
        int top() {
    
        }
    
        void heapify(const vector<int>& arr) {
    
        }
    };
```

https://www.geeksforgeeks.org/problems/min-heap-implementation/1



```cpp
class MinHeap {
private:
    void heapify(vector<int>& v, int n, int i)  {
        if(i>=n/2) return;
        int minn=i;
        if(v[2*i+1]<v[minn]) minn=2*i+1;
        if(2*i+2<=n-1 and v[2*i+2]<v[minn]) minn=2*i+2;
        if(minn!=i){
            swap(v[i],v[minn]);
            heapify(v,n,minn);
        }
    }
    
    void buildHeap(vector<int>& v, int n)  { 
        for(int i=n/2-1;i>=0;i--){
            heapify(v,n,i);
        }
    }

    vector<int> heap;

    void bubbleItUp(int idx, vector<int>& v){
        int j=idx;
        while(j>0 and v[j]<v[(j-1)/2]){
            swap(v[j],v[(j-1)/2]);
            j=(j-1)/2;
        }
    }

    void deleteRoot(){
        int n=heap.size();
        swap(heap[0],heap[n-1]);
        heap.pop_back();
        heapify(heap,n-1,0);
    }   

public:
    MinHeap() {}

    void push(int val) {
        heap.push_back(val);
        int n=heap.size();
        bubbleItUp(n-1,heap);
    }

    int pop() {
        if(!heap.size()){
            return -1;
        }
        int ans=heap[0];
        deleteRoot();
        return ans;
    }

    int top() {
        if(!heap.size()){
            return -1;
        }
        return heap[0];
    }

    void heapify(const vector<int>& v) {
        int n=v.size();
        heap=v;
        buildHeap(heap,n);
    }
};

```