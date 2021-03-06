Toy Robot Simulator - Problem Description
=========================================

The application is a simulation of a toy robot moving on a square table top,
of dimensions 5 units x 5 units.

Description
-----------

- The application is a simulation of a toy robot moving on a square tabletop,
  of dimensions 5 units x 5 units.
- There are no other obstructions on the table surface.
- The robot is free to roam around the surface of the table, but must be
  prevented from falling to destruction. Any movement that would result in the
  robot falling from the table must be prevented, however further valid
  movement commands must still be allowed.

Create an application that can read in commands of the following (textual) form:

    PLACE X,Y,F
    MOVE
    LEFT
    RIGHT
    REPORT

- PLACE will put the toy robot on the table in position X,Y and facing NORTH,
  SOUTH, EAST or WEST.
- The origin (0,0) can be considered to be the SOUTH WEST most corner.
- The first valid command to the robot is a PLACE command, after that, any
  sequence of commands may be issued, in any order, including another PLACE
  command. The application should discard all commands in the sequence until
  a valid PLACE command has been executed.
- MOVE will move the toy robot one unit forward in the direction it is
  currently facing.
- LEFT and RIGHT will rotate the robot 90 degrees in the specified direction
  without changing the position of the robot.
- REPORT will announce the X,Y and F of the robot. This can be in any form,
  but standard output is sufficient.

- A robot that is not on the table can choose the ignore the MOVE, LEFT, RIGHT
  and REPORT commands.
- Input can be from a file, or from standard input, as the developer chooses.
- Provide test data to exercise the application.
- The application must be a command line application.

Constraints
-----------

- The toy robot must not fall off the table during movement. This also
  includes the initial placement of the toy robot.
- Any move that would cause the robot to fall must be ignored.

Example Input and Output
------------------------

### Example a

    PLACE 0,0,NORTH
    MOVE
    REPORT

Expected output:

    0,1,NORTH

### Example b

    PLACE 0,0,NORTH
    LEFT
    REPORT

Expected output:

    0,0,WEST

### Example c

    PLACE 1,2,EAST
    MOVE
    MOVE
    LEFT
    MOVE
    REPORT

Expected output

    3,3,NORTH

Deliverables
------------

Please provide your source code, and any test code/data you using in
developing your solution.

Please engineer your solution to a standard you consider suitable for
production. It is not required to provide any graphical output showing the
movement of the toy robot.

Please do not put your name in any of the submitted code since this makes it harder for us to review your submission anonymously.

Toy Robot Simulator - README
============================

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for testing purposes. 
There are two ways for running the ToyRobotApplication:

## 1. Execute the runnable JAR file in command prompt
### Prerequisites
Install Java on your computer if it isn't installed. You can't run JAR files without Java installed on your computer. If you don't already have Java installed, go to Java's website at https://www.java.com/en/download/ and click the Free Java Download button below the latest version of Java, then install Java once it downloads.
You may have to restart your computer for Java to be fully implemented.

In terms of the application is command line based program, therefore it required few more steps to run it in command prompt.

Step1: 
Open command prompt, and please make sure the working directory is directed to as same as the file path.
For example: the Demo.jar placed in desktop, the path should be : C:\Users\<User Name>\Desktop\JAR File;
then in the command prompt should use "cd C:\Users\<User Name>\Desktop\JAR File" to direct to the same directory

Step2:
- Typing "java -jar Demo.jar" to execute the JAR file

Then the program will run directly by displaying the instructions to guide you put commands for testing.
========Instructions======== <br>
PLACE X,Y,F <br>
MOVE <br>
LEFT <br>
RIGHT <br>
REPORT <br>
EXIT <br>
Please enter your command : <br>
$> <br>

- Typing "java -jar Demo_ParaFile.jar Sernario_Test1.para 0", that is able to choose a file doing auto-testing
Note:
Para0: file name
Para1: 0 = not able to continue, 1 = is able to continue



## 2. Run the project in Eclipse
### Prerequisites
Install Eclipse on your computer if it isn't installed.

### Installing
Step 0: Install JDK
Step 1: Download Eclipse from https://www.eclipse.org/downloads.
        Version:Neon.3 Release (4.6.3)
Step 2: Unzip
        To install Eclipse, simply unzip the download file into a directory of your choice (e.g., "d:\myproject").
        
There is no need to run any installer. Moreover, you can simply delete the entire Eclipse directory when it is no longer needed (without running any un-installer). You are free to move or rename the directory. You can install (unzip) multiple copies of Eclipse in the same machine.

### Running the program
Simply press the green button to run it as an application, the the instructions will display in the console tab.

## Development
Basically, I use Java language for developing because I would like to show how well I understand the object-oriented concept and applied design patterns in order to make the code is more scaled and easy to maintain.

### System Architecture
In the ToyRobot\Documentation_ToyRobot Dev\Class Diagram folder, ToyRobot Simulator_Ver01 shows a brief picture that how I structure those classes and decided to have a abstract class TableItem that allows ToyRobot to inheritance. The idea is that once the program required another item is able to place on table top as well; for implementing the extra requirements, only need to create a new class that inheritance from TableItem.
After that, I made a abstract class Command in order to implement PLACE, MOVE, RIGHT, LEFT by following the same structure that reduced duplicate code.

### Design Patterns
In the system, I basically applied Singleton on Simulator and ToyRobot classes and intended following MVC (Model-View-Controller) patterns which named separate packages to distinguish each other.
- Controller: manipulate model objects
  Simulator manipulate ToyRobot's attributes via Command objects
- Model: store data
  ToyRobot store the positions and facing data in order to report to views.
- View: display information
  ErrorMessage_View package 
  
The purpose that applied Singleton on ToyRobot is to make sure there is once one instance in the system which required in the problem description. The advantage is that the instance is able to across the whole system and not allowed to modify. Therefore, it can ensure the data is from the same one source.

### TDD - JUnit
To be honest, this is my first time trying TDD even though the courses I have done already taught us how to use JUnit for unit testing. But writing unit tests does not mean TDD. I believe what I lock of is more details on system structure and define valid/invalid inputs to start with. Overall, the project workflows are:

Design - loop(Develop - Unit Test - JUnit - Debug) - Documentation

Moreover, I know TDD should write test cases for every single function and included boundary input testing. However, I am under one week time constraint that set by myself that pretend undertaking a real task working in the industry. I suppose it is not only to demonstrate the programming capability but also to show my time management skills that probably get the balance between code quality and functionality. 

--add an alternative testing method
It allows system take two parameters to run configurations; 
Para0: file name
Para1: exit system or not (0=not able to continue, 1=is able to continue)
Note: system will exit if the file has exit commands in; and after the auto-testing, the robot is already placed on table.

## Refactor Plan
Have a state controller to check the simulator current state in order to ensure the user execute PLACE command first.
<li> design state diagram
<li> state controller to define all the state
<li> simulator inheritance from the state machine
<li> implement each state methods to ensure it follows the state diagram

## Authors

* **Loso Lai** - *Initial work* - [toy-robot](https://github.com/rmit-s3579161-loso-lai/toy-robot)

See also the list of [commits](https://github.com/rmit-s3579161-loso-lai/toy-robot/commits/master) which is the log of development.

