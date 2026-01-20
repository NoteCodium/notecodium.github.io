[leetcode.com](https://leetcode.com/problems/design-circular-queue/)
```cpp
class MyCircularQueue {
private:
    vector<int> v;
    int n;
    int cnt;
    int front;
    int back;

public:
    MyCircularQueue(int k) {
        v.resize(k);
        n=k;
        cnt=0;
        front=0;
        back=-1;
    }
    
    bool enQueue(int value) {
        if(isFull()) return 0;
        back=(back+1)%n;
        cnt++;
        v[back]=value;
        return 1;
    }
    
    bool deQueue() {
        if(isEmpty()) return 0;
        cnt--;
        front=(front+1)%n;
        return 1;
    }
    
    int Front() {
        if(isEmpty()) return -1;
        return v[front];        
    }
    
    int Rear() {
        if(isEmpty()) return -1;
        return v[back];
    }
    
    bool isEmpty() {
        return cnt==0;
    }
    
    bool isFull() {
        return cnt==n;
    }
};

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue* obj = new MyCircularQueue(k);
 * bool param_1 = obj->enQueue(value);
 * bool param_2 = obj->deQueue();
 * int param_3 = obj->Front();
 * int param_4 = obj->Rear();
 * bool param_5 = obj->isEmpty();
 * bool param_6 = obj->isFull();
 */
```