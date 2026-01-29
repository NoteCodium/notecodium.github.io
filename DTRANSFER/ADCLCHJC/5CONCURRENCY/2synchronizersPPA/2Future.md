---
title: 2Future
---

{% raw %}
# Future

custom implementation

```python
public class Main {
    public static void main(String[] args) {
        CustomFutureReturnRunnable customFutureReturnRunnable=
            new CustomFutureReturnRunnable();
        //The naming can confuse you
        //Just see the block below

        new Thread(customFutureReturnRunnable).start();
        String ans= customFutureReturnRunnable.get();
        System.out.println(ans);
    }
}
```

```python


//CustomFutureReturnRunnable is still just like a Worker
//A class that implements Runnable
public class CustomFutureReturnRunnable implements Runnable{

    private String output;
    private boolean isDone;

    public CustomFutureReturnRunnable(){
        isDone=false;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        output="Done";
        isDone=true;
    }

    public String get(){
        while(!isDone){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return output;
    }

}
```

inbuilt

```python
FutureTask<String> futureTask=new FutureTask<>(new CustomCallable());
new Thread(futureTask).start();
System.out.println(futureTask.get()); 
```

```python
public class CustomCallable implements Callable<String>{
    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "Hi from CustomCallable";
    } 
}
```

```python
FutureTask<?>
//if something is not returning a future, i.e. a Runnable,  then we can use it
```

CustomCallable which is different from Runnable is made a FutureTask  

FutureTask is just like a Worker

We can get a value from futureTask.get()

UTH
![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_5CONCURRENCY_2synchronizersPPA_2Future__att_0001.png)
{% endraw %}
