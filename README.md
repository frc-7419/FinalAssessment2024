# FinalAssessment2024
## How to start
- Clone the repo
- Make a branch with the branch name as ```Firstname-Lastname```(names should be capitalized, example:``````) if your branch is incorrectly named or you make multiple you will lose points
- You can make as many commits and pushes as you want to your branch, when you are done make sure to push all of your code
- We will check you latest commit to grade it
- This is due Friday as a result the latest time you can commit is Friday, December 6, 11:59 PM PST
## Objective
#### Overall
- Write an entire robot in WPILib 2024, you will have to install any needed [vendor libraries](https://docs.wpilib.org/en/stable/docs/software/vscode-overview/3rd-party-libraries.html) needed yourself, for example REV or CTRE(phoenix 6) libraries
#### Specific
- Swerve drive drivebase
- Shooter
- Intake
- Handoff
- Hanger
## Hardware specifciations
#### Swerve
- Eight motors
- Four absolute encoders (CTRE CANCoder)
- One gyro (pigeon2)
- Four modules, a modules consists of a turn motor a drive motor and an absolute encoder which give the angle of the wheel
- Offsets for absolute encoders are as follows, they are providied in degrees: front left 98.35, front right 3.5, back left 34.84, back right 74.19
- After offsets are applied then all motors will go forward if a positive value is given, backwards if negative
#### Shooter
- Two motors
- Top motor is a Falcon 500, negative values spin it in such a way so the note shoots out
- Bottom motor is a Falcon 500, negative values spin it in such a way so the note shoots out
#### Intake
- Two motors
- Both motors are on the same axle, both are NEO Vortex, positive spin the motor in such a way that a note would be intaked into the robot
#### Handoff
- Two motors
- Top motor is a NEO Vortex, positive values spin it in such a way so that the note moves towards the shooter mechanism
- Bottom motor is a NEO Vortex, negative values spin it in such a way so that the note moves towards the shooter mechanism
#### Hanger
- One motor
- Controlled by a Kraken motor, negative values will spin the Kraken motor such that the hanger will move up
- Hanger always magically start fully down
## Requirements
#### Output some info about the robot to smartdashboard
- Swerve module drive motor speed and wheel angle
- Temperature for all motors
- Anything else you feel needs to be outputted, we will not mark you off if you don't add much else other than what is stated above
#### Be able to fully control the swerve drive through the drive joystick
- Left x is left and right velocity
- Left y is forward backward velocity
- Right x is rotational velocity
- Translation must be field relative
- The robot should be able to rotate while translating
#### Have pathplanner setup with a test path
- PID constants do not need to be correct, just push a temporary value
- Robot width and length need to be taken into account
#### Be able to control the intake and handoff with the operator joystick
- Right y is velocity of the intake and handoff, up(positive) should intake the node into the robot
#### Be able to control the shooter with the operator joystick
- Left Y is velocity of the shooter, up(positive) should shoot the note out
#### Be able to control the hanger with the operator joystick
- Holding down right bumper moves it up
- Holding down left bumper moves it down
#### Have auton commands to move mechanisms given a unit(can be whatever you want)
- Have a command that spins the shooter
- Have a command that spins the intake
- Have a command that spins the handoff
- Have a command that moves the hanger up and down
## Things we grade on (Rubric)
- Giving appropriate scoping to variables, e.g. a joystick reference declared in a class that extends Command is private
- Making sure to put final keyword on things that don't or shouldn't change
- Lack of syntax errors (your code should build successfully)
- Following proper naming conventions
- Not having uneccessary variables
- Not doing things in a weird and over complicated way
- How fully your code satifies the requirements
- Your code not theoratically causing physical damage to the robot when run
