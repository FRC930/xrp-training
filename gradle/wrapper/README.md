# XRP Training!!!

This application will work to continue your Java training in a more FRC-based context using Team 930's XRP robots.

Content:
- Environment Setup
- Branch Creation
- Robot Operation
- XRP Project Structure
- Commands
- Servo/Arm
- Mini Project

## For easier reading:
Looking at a large wall of monospace programming font text can be very hard on they eyes, and looking at a much easily readable formatted version would be much preferred. Thankfully, this document is written in *markdown*! Markdown is a language for creating simple documents that can be easily read.

To utilize the convinience of markdown, go into VS Code and *right-click* on this file name in the file explorer.

After, from the dropdown menu, select "Open Preview".

## Environment Setup
1. Make sure your programming environment is set up and up to date
- [930 Programming Documentation](https://sites.google.com/view/team930programmingdoc/organization/environment)
2. Confirm GitHub Desktop is installed
- [Download Website](https://desktop.github.com/download/)
- Login
- Clone this repository (top right-hand "Code" button -> click copy)
3. Confirm all the necessary VS Code extensions are downloaded (should be in environment documentation)
- Java Run
- Gradle
4. Update Extentions and Reload
- Debugger for Java
- Language Support for Java
- Project manager for Java

## Creating a Branch
1. Open the "Current Branch" menu on the top bar of GitHub Desktop, and select "New Branch"
2. Name the branch
- We use \<your first name>-branch for our naming. e.g. luke-branch, ava-branch
3. If not already on branch, switch to it on GitHub Desktop
- On the "Current Branch" menu on the top bar of GitHub Desktop, select -branch under "Recent branches"

## Running the XRPs
Turning on and running the XRPs vary from how we do the same to a typical FRC Robot.
### Hardware:
1. The only external materials needed to run the XRP are:
- A wired Xbox controller (connect to your computer).
- Batteries--similar to an FRC robot, the XRPs need power via batteries to run. These should already be inside the XRPs.
2. To turn on the XRP, look for the "on" switch on the red controller board (should be on the outer edge of the board).
3. You will need to connect to the XRP's wifi. Disconnect from whatever wifi you're currently on, and connect to the XRP's network. The password for the network is "xrp-wpilib" (NOTE: If deploying new code onto the XRPs, deploy that code before connecting to the XRP's wifi).
4. Open the WPI command palette (ctrl + shift + p) and select "Simulate Code" (You may have to start typing for the command to appear).
5. When the sim GUI loads, make sure the selcted controller is the one plugged into your computer.
6. Select "teleop" to run the XRP. You should be able to control the XRP's movement with the joysticks (be mindful that connection gets laggy the longer the XRP is connected),

## Project Structure and Key Files
There are a couple important files on the XRP to understand that translate to our FRC robot code
### Robot.java
- Navigate to the `Robot.java` file (under src/main/java/frc/robot). Skim through the code. What do you think this code is doing? (hint: read the comments)

<details>
    <summary>What does Robot.java do?</summary>

    - Robot.java deals with all of the behind-the-scenes initializations and defines how the robot behaves in each operational mode (autonomous, teleoperated, disabled, test, and simulation). It contols what the robot is continuously doing while it is running.

    - It does this using the "Periodics" and "Init" methods:
    --"Init" methods run once when the program starts. For example, "teleopInit()" will be called and run once when the XRPs begin in the teleoperated mode. Usually code within this method will inturrupt previous commands that the robot is running.
    --"Periodic" methods are run continuously during the program (usually every 20 milliseconds). For example, "teleopPeriodic()" will run continously for as long as the XRP is in the teleoperated mode. Usually code within this method will update controls and reading sensors.

    NOTE: We don't mess with Robot.java very often.
    
</details>

### RobotContainer.java
- Navigate to the `RobotContainer.java` file (under src/main/java/frc/robot). Skim through the code. What do you think this code is doing? (hint: read the comments)

<details>
    <summary>What does RobotContainer.java do?</summary>

    - RobotContainer.java is where we connect the robot's hardware and controls to our code/commands. We spend a lot more time in RobotContainer.java compared to Robot.java

    - A couple important functions of RobotContainer.java:
    --Creates instances of each of the XRP's subsystems (file lines 38-41) that can be passed to commands
    --Configures the controller buttons (file lines 62-78). This is where we connect controller buttons (like Y, A, triggers, bumpers) to actual controls. For example, the button binding for "A" in this code sets the XRP's arm to 135 degrees (file lines 73-74) using the SetAngleCommand().
    --If our XRP performed automonous paths, that logic would be within this file as well (it technically is on file lines 92-94, there just aren't any autos to put into code). On our FRC robots (where we to have autos) this file is where those auto routines would be defined.
    
</details>

## Commands
- You learned in java training that commands are actions that a robot can perform. Look through the pre-written command file ArmDefaultCommand.java (under src/main/java/frc/robot/commands). How do you think we use this command, and where is it used? (hint: right-click on the constructor in the command  (file line 14) and click "Find all References" to see where it's used)

<details>
    <summary>Where are commands used?</summary>

    RobotContainer.java! This is where the commands we create are bound to controller buttons. For ArmDefaultCommand.java specifically, it is positioned where it is one of the first commands the robot runs when it turns on (file line 54). It is not bound to a button, it happens automatically. Looking into the ArmDefaultCommand.java file, the command sets the XRP's arm to 90 degrees.
    
</details>

### Lets try using a command:

1. We are going to use the SetAngleCommand to make the arm go to 180 degrees when the controller button "B" is pressed. Look into the SetAngleCommand.java file (under src/main/java/frc/robot/commands). How do you think this command operates? What parameters are we going to have to input into the command to make it do what we want?

<details>
    <summary>What are our parameters?</summary>

    Our parameters for SetAngleCommand.java is an angle degree (double), and an arm.
    
</details>

2. Go back to RobotContainer.java. Under the last button binding currently in code (file lines 73-75), enter down to make space for a new binding. Make sure indenting is correct!
3. To start a new button binding, call the object (the controller) and which button you want to bind your commands to. Use the pre-written controller bindings as a guide, and try to write the first line of this code segment yourself.

<details>
    <summary>Check your work in #3 here</summary>

    m_controller.b()
    
</details>

4. Now, we need to specify when we want our command to run. While the button is pressed, when it is pressed, or when it isn't pressed. This will act like a boolean (true or false) statement. Use the pre-written controller bindings as a guide, and try to write the specifications for when we want our command to run yourself.
5. Within our boolean, we want to call our SetAngleCommand.java command, as well as the parameters we specified earlier. Use the pre-written controller bindings as a guide, and try to implement the command and set the correct parameters yourself.

<details>
    <summary>Check your work in #4-5 here</summary>

    .whileTrue(new SetAngleCommand(180.0, m_arm));

    NOTE: Whats the difference between .whileTrue() and .onTrue()? .whileTrue will only run your command while the button is being pressed. When you release your finger from the button, the command will stop running. .onTrue will continuously run the command after the button is pressed, and will continue to run that command even after the button is released.
    
</details>

6. Congrats, you made your own button binding using a command! To test your command, refer to the instructions under "Running the XRPs", make sure to deploy your code onto the XRP before you run the robot, otherwise your code will not run.