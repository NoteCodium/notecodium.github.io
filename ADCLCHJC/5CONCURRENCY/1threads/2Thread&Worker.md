```python
public class Worker implements Runnable{
    @Override
    public void run(){
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName());
    }
}
```

```python
Thread.currentThread().getName()
```

```python
public class Main{
    public static void main(String[] args){
        Worker worker = new Worker();
        Thread thread = new Thread(worker);
        thread.start();
        System.out.println(Thread.currentThread().getName());
    }
}
```

![image.png](2Thread&Worker_images/image.png)

