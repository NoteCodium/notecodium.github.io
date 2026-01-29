---
title: 3PCBvsTCB
---

{% raw %}
All processes are being tracked by OS using a table like data structure, Process table:, Each entry in that table is process control block (PCB)

# PCB 

ds  
stack pointer ==> current instruction  
pc==> next instruction 
frame pointer ==> 
metadata  
state⇒ running/waiting  
id   
memory mgmt⇒ memory allocated to the pricess , memory limits  
io ⇒ io devices allocated  
registers  
cpu scheduling information ⇒ priorities in scheduling queue
⇒ list of open file

# TCB

in thread context switch,   
  CPU’s cache state is preserved.
  memory address space preserved  


the following are not preserved  
Program counter,   
registers   
stack

. When a processes is running and it's time slice expires, the
current value of process specific registers would be stored in the PCB and the process would be swapped
out. When the process is scheduled to be run, the register values is read from the PCB and written to the
CPU registers. This is the main purpose of the registers in the PCB.

# Threads have own

- Local variables
- Stack
- Program counter
- Register state

# Shared

- Heap memory
- Code
- Global variables
- Static variables
- File descriptors
- Locks
{% endraw %}
