---
title: 3LayersTermTerminology
---

{% raw %}
![image.png](/transfernew/notebook_images/transfernew_9GATETHEORY_Networking_3LayersTermTerminology__att_0001.png)



1. Error Control
Error control refers to techniques and mechanisms used to detect and correct errors in data


Error Detection:


parity checks,  
 checksums,   
  cyclic redundancy checks (CRC). (%)

# Error  
![image.png](/transfernew/notebook_images/transfernew_9GATETHEORY_Networking_3LayersTermTerminology__att_0002.png)

for single bit error  
![image.png](/transfernew/notebook_images/transfernew_9GATETHEORY_Networking_3LayersTermTerminology__att_0003.png)

Hence no of 1 bits always become even

# CRC
no. of bits detected according to polynomical degree , append no. of bits equal to polynomial degree

Error correction:

Hamming Code  


Forward error correction:

# Hamming
![image.png](/transfernew/notebook_images/transfernew_9GATETHEORY_Networking_3LayersTermTerminology__att_0006.png)  
![image-2.png](/transfernew/notebook_images/transfernew_9GATETHEORY_Networking_3LayersTermTerminology__att_0004.png)  
![image-3.png](/transfernew/notebook_images/transfernew_9GATETHEORY_Networking_3LayersTermTerminology__att_0005.png)

![image.png](/transfernew/notebook_images/transfernew_9GATETHEORY_Networking_3LayersTermTerminology__att_0007.png)

transmission:

In protocols like TCP, error control ensures damaged packets are retransmitted using mechanisms like Automatic Repeat Request (ARQ).

# Flow control

2. Flow Control
Flow control ensures that the sender does not overwhelm the receiver by sending data faster than it can be processed. It manages the rate of data transmission to prevent congestion and buffer overflow.

Stop-and-Wait:

The sender transmits one frame and waits for acknowledgment before sending the next.  


Sliding Window Protocol:


Allows multiple frames to be sent before requiring acknowledgment, improving efficiency.
The sender and receiver maintain a "window" of acceptable frames to manage data flow.
Buffering:

Temporarily stores incoming data in a buffer to prevent loss if the receiver is busy.

# ARQ  
Automatic 
repeat 
request


stop and wait  
sliding window


sequence number

# Access Control

3. Access Control
Access control regulates who or what can access resources (e.g., data, devices, or services) in a system or network. It ensures security and prevents unauthorized access.  

which device has control over the link at any given time

Firewalls

we are sharing thwe same link to transfer the data

![image.png](/transfernew/notebook_images/transfernew_9GATETHEORY_Networking_3LayersTermTerminology__att_0008.png)

# PURE ALOHA

![image.png](/transfernew/notebook_images/transfernew_9GATETHEORY_Networking_3LayersTermTerminology__att_0009.png)
{% endraw %}
