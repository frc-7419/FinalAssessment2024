package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Subsystems.HandoffSubsystem;


public class HandoffCommand extends Command {
    // making an object handoffSubsystem of type HandoffSubsystem
    private final HandoffSubsystem handoffSubsystem;
    // making an object ctrl of type XboxController
    private final XboxController ctrl;
    // making a variable of type double storing the last known speed
    private double lastSetSpeed = 0;
    
    // defining the objects
    public void handoffUsingRB(XboxController xboxController, HandoffSubsystem handoffSubsystem) {
        this.handoff = handoffSubsystem;
        this.ctrl = xboxController;
        addRequirements(hangoffSubsystem);
    }
    
    // Setting the motors to coast
    @Override
    public void initialize() {
        handoff.coast();
    }
    
    // Setting the power to motors
    @Override
    public void execute() {
        double spd = ctrl.getLeftY();
        if (lastSetSpeed != spd) {
            handoff.runHandoffMotors(spd);
            lastSetSpeed = spd;
        }
    }
    
    // Setting the motors to brake
    @Override
    public void end(boolean interrupted) {
        handoff.brake();
    }
    
    @Override
    public boolean isFinished() {
        return false;
    }   
}
