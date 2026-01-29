---
title: 0EH
---

{% raw %}
thread can not return even exceptions to each other, they have different call stacks

# Demonstration

```python
public class Main{
    public static main void(String[] args){
        try{
            new Thread(new Worker()).start();
            Thread.sleep(2000);
        }
        catch(Exception e){
            System.out.println("Successfully caught");
        }
    }
}
```

```python
public class Worker implements Runnable{
    @Override
    public void run(){
        throw new RuntimeException("Exception from worker");
    }
}
```

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_5CONCURRENCY_2synchronizersPPA_0EH__att_0001.png)

Successfully caught never printed
{% endraw %}
