#Assignment 2: Task 3 and Task 4

***Task 3: Analysis of current design (Single Responsibility Principle and Separation of Concerns)***

***1. DrawPanel.java***\
**Responsibilities** 
This class is to render the car in the screen. \
**Reason to Change** 
1. This class has two array lists and violates open-closed principle. Because it hardcoded the image path for Volvo and Saab. If we need to add a new car, we must modify this class.
2. Keeping images and points in two array lists rely on index. This may cause mismatching problems. 


***2. CarController.java***

**Responsibilities** 
This class handles gas, brake, turbo button logic. It also manages the timer to updates cars' coordinates and trigger the view to repaint. \
**Reasons to change**
1. In terms of SRP and SoC principles, this class served a lot of functions, including ActionListener, TimerListener and gas related logic.
2. It also violates Open Close principle. Since it used instanceof in setTurboOn(), it means that we need to modify controller when adding a new turbo car. 
3. To make it easier to read, maybe it would be better to extract car features to car. Then timer and other calculation into one class.

***3.CarView.java***\
**Responsibilities**
This class builds the GUI and listen to button clicks. \
**Reasons to change**
1. CarView class should not include what would happen when buttons is clicked. This violates SRP. 
2. It also violates SoC. Because it handles user input, for example, gasAmount from spinnerModel and a lot of carControllers' part. 


***Task 4: New UML Design***\
![UML design](src/pics/UML new design.png)

**Motivation for the New Design**\
To meet the principles of SRP, SoC and Coupling. Here are some suggestions for design.
1. Split "CarController" class into CarController and TimeLoop. So CarController manages user input, while TimeLoop handles with timer related to car.move().
2. Make "DrawPanel" class extensible. It means that it needs an abstract Car class to handle everything. We dont need to modify whenever a new car is added. This meets OCP. 
3. Decouple 


