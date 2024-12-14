package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Subsystems.IntakeSubsystem;

public class IntakeCommand extends Command{
    // making an object intakeSubsystem of type IntakeSubsystem
    private IntakeSubsystem intake;
    // making an object ctrl of type XboxController
    private XboxController ctrl;
    // making a variable of type double storing the last known speed
    private double lastSetSpeed = 0;
    
    // Defining the object
    public void IntakeUsingJoystick(XboxController xboxController, IntakeSubsystem intakeSubsystem) {
        this.intake = intakeSubsystem;
        this.ctrl = xboxController;
        addRequirements(intakeSubsystem);
    }
    
    // Setting the motors to coast
    @Override
    public void initialize() {
        intake.coast();
    }
    
    // Setting the power to the motors
    @Override
    public void execute() {
        double spd = ctrl.getLeftY();
        if (lastSetSpeed != spd) {
        intake.runIntakeMotors(spd);
        lastSetSpeed = spd;
        }
    }
    
    // Setting the motors to brake
    @Override
    public void end(boolean interrupted) {
        intake.brake();
    }
    
    @Override
    public boolean isFinished() {
        return false;
    }
}
