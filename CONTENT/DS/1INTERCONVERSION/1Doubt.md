# interconversion stack and Queue

## Stack → Queue (by two stacks) 

### (expensive pop) and maintaining top

[https://leetcode.com/problems/implement-queue-using-stacks/description/](https://leetcode.com/problems/implement-queue-using-stacks/description/)

### ![image.png](/images/image-269.png)

for peek maintaing the front_element variable, instead of doing the whole pop operatrion O(n) 

```
class MyQueue {
private:
    stack<int> s1,s2;
    int front;
public:
    MyQueue() {
        
    }
    
    void push(int x) {
        if(s1.empty()) front=x;
        s1.push(x);
    }
    
    int pop() {
        if(empty()) return -1;
        int ans;
        while(!s1.empty()){
            s2.push(s1.top());
            s1.pop();
        }
        ans=s2.top();
        s2.pop();
        while(!s2.empty()){
            if(s1.empty()) front=s2.top();
            s1.push(s2.top());
            s2.pop();
        }
        return ans;
    }
    
    int peek() {
        if(empty()) return -1;
        return front;
    }
    
    bool empty() {
        return s1.empty();
    }
};
```

### Both amortized O(1)

https://www.youtube.com/watch?v=3Et9MrMc02A

![image.png](/images/image-270.png)

![image.png](/images/image-274.png)



![image.png](/images/image-272.png)

![image.png](/images/image-273.png)

O(n)

![image.png](/images/image-275.png)

![image.png](/images/image-276.png)







```
class MyQueue {
private:
    stack<int> in,out;

    void transferIn2Out(){
        while(!in.empty()){
            out.push(in.top());
            in.pop();
        }
    }

public:
    MyQueue() {
        
    }
    
    void push(int x) {
        in.push(x);
    }
    
    int pop() {
        if(out.empty()) transferIn2Out();
        int x=out.top();
        out.pop();
        return x;
        
    }
    
    int peek() {
        if(out.empty()) transferIn2Out();
        return out.top();
    }
    
    bool empty() {
        return in.empty() and out.empty();
    }
};
```













