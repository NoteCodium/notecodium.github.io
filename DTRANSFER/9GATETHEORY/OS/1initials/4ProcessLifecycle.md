---
title: 4ProcessLifecycle
---

{% raw %}
1. program available to run
2. os select the program and convert it to process
3. give it to cpu

1. new process wants to executed
2. os allocates resources

address space load    code to memory

allocate stack and heap space

# Job queue

1. new⇒ 
2. Processes in new state (made from the process defined above)
3. Present in secondary memory
4. Job Schedular (Long term schedular (LTS)) picks process from the pool and
loads them into memory for execution

![image.png](/DTRANSFER/notebook_images/DTRANSFER_9GATETHEORY_OS_1initials_4ProcessLifecycle__att_0001.png)

# JOB QUEUE -> READY QUEUE  
long term schedular

device queue⇒ waiting for io

1. ready state

⇒ Present in main memory

CPU Schedular (Short-term schedular) picks process from ready queue and
dispatch it to CPU.

![{D65FABB9-3851-4649-9C5F-17AD1F9F2444}.png](/DTRANSFER/notebook_images/DTRANSFER_9GATETHEORY_OS_1initials_4ProcessLifecycle__att_0002.png)

# Termination

voluntary

1. exit()

involuntary

1. os kill (the process has done some unauthorised access)
2. parent kill the child (in online judge)

after killing exit code 0 to parent

# Process killing by signals

SIGTERM
{% endraw %}
