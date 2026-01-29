---
title: 2Types
---

{% raw %}
QA testing

Developer testing

manual testing  
i made up some changes, are we going to test all the features again  
test cases wala tests ??

Unit testing  
test your react component in isolation  
mock all our dependencies

integration testing  
full flow  
![image.png](/transfernew/notebook_images/transfernew_9GATETHEORY_Testing_2Types__att_0001.png)

![image.png](/transfernew/notebook_images/transfernew_9GATETHEORY_Testing_2Types__att_0002.png)

End to end 
	1. Sigup to full
	2. Cypress, pupetteer, selenium

User testing

Performance testing

1. System Testing
Definition: System Testing is a type of testing where the entire application is tested as a whole to ensure that it meets the specified requirements. It validates the functionality, performance, and behavior of the system in its integrated environment.

Purpose:

To verify that the system works as expected in its complete state.
To check that the integrated components function correctly together.
Key Aspects:

End-to-End Testing: Tests the flow of the application from start to finish.
Environment: Performed in an environment that closely resembles the production setup.
Testing Types:
Functional Testing (verifies features work as intended).
Non-Functional Testing (e.g., performance, security, load testing).
Example:

A banking application:
Test Case: Logging in, transferring money, and logging out.
Expected Result: The correct amount should be transferred, and the account balance should update appropriately.
Test scenarios might include testing under normal usage, edge cases, and with high user traffic.

2. User Acceptance Testing (UAT)
Definition: UAT is the final phase of testing conducted by the end-users or clients to verify that the software meets their business requirements and is ready for deployment.

Purpose:

To ensure the software works as intended in real-world scenarios.
To validate that the software solves the users' actual problems.
Key Aspects:

Performed by end-users, business analysts, or clients.
Focused on real-world scenarios, not just functionality.
Serves as a final approval before production deployment.
Example:

In a ride-sharing app:
Test Case: A user books a ride, pays through the app, and rates the driver.
UAT Feedback: If users find the payment gateway confusing, adjustments may be required.

10. Smoke Testing
Purpose: To verify that critical functionalities work correctly before conducting more detailed tests.
Performed by: QA engineers.
Example: Verifying basic functions like logging in, navigating pages, and accessing features after a new build.
{% endraw %}
