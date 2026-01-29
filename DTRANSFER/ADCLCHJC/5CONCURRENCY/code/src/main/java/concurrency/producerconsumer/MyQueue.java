package code.src.main.java.concurrency.producerconsumer;
// package CONCURRENCY.old;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {
    private int front, rear;
    private final List<Integer> list;
    //doubt
    private final int capacity;

    public MyQueue(int capacity) {
        this.front = -1;
        this.rear = 0;
        this.list = new ArrayList<>();
        this.capacity = capacity;
    }

    public boolean isFull(){
        return front-rear+1==capacity;
    }

    public void push(Integer x){
        if(isFull()){
            throw new RuntimeException("Overflow");
        }

        list.add(x);
        front++;
    }
    
    public Integer pop(){
        if(isEmpty()){
            throw new RuntimeException("Underflow");
        }
        Integer ans= list.get(rear++);
        return ans;
    }

    public boolean isEmpty(){
        return front-rear+1==0;
    }


}
