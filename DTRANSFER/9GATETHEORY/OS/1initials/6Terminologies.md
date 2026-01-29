---
title: 6Terminologies
---

{% raw %}
# Zombie process   
(do sanity check)
parent should wait, system call wait, for the child to finish to see it is completed successfully or not

when child is completed, resources are freed, return exit code to parent  


process whose exit is not read by the parent because the parent has not called wait, the parent process have died, resources freed but still in process table
{% endraw %}
