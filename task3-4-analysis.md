#Assignment 2: Task 3 and Task 4

##Task 3: Analysis of current design (Single Responsibility Principle and Separation of Concerns)

###1. DrawPanel.java
**Current Problem** It is highly coupled with "Volve240". And it also hardcoded with only one "volvoImage" and "volvoPoint", which violates Open-Closed Principle. If we want to add another class, we must modify this class. 
**Solution** Abstraction class should be better here, such as "Car" 

###2. CarController.java
**Current Problem** In terms of SRP and SoC principles, this class served a lot of functions, including ActionListener, TimerListener and gas related logic. 
**Solution**

##Task 4: New UML Design
![New UML Design]()

###Motivation for the New Design 


