---
title: -1TypesOfOs
---

{% raw %}
Single process ⇒ ms dos

Batch processing  
1. Firstly,	user	prepares	his	job	using	punch	cards.
2. Then,	he	submits	the	job	to	the	computer	operator.
3. Operator	collects	the	jobs	from	different	users	and	sort	the	jobs	into	batches	with
similar	needs.
4. Then,	operator	submits	the	batches	to	the	processor	one	by	one.
5. All	the	jobs	of	one	batch	are	executed	together


Disadvantages
Priorities	cannot	be	set,	if	a	job	comes	with	some	higher	priority.
- May	lead	to	starvation.	(A	batch	may	take	more	time	to	complete)

Multiprogramming  
1. increases CPU utilization by keeping multiple jobs (code and data)
in thememory so that the CPU alwayshas one toexecute in	case	some	job	gets	busy	with	
I/O.
2. single cpu
3. context switching happpens

Multitasking  
1. Able	to	run	more	than	one	task simultaneously

Multi-processing  (windows)

1. more	than	1	CPU	in	a	 single	computer
2. Increases	reliability,	1	CPU	fails,	other can	work

Distributed  
OS	manages	many	bunches of resources, >=1	CPUs, >=1	memory, >=1	GPUs, etc

Loosely connected	independent, interconnected	computer nodes.

networked, communicating, and	physically	separate

Real time   
(atcs (air traffic control system), 
robots, 
nuclear power plant)

Real time error	free,	computations within tight-time	boundaries.
{% endraw %}
