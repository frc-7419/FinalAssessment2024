package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Subsystems.ShooterSubsystem;

public class HandoffCommand extends Command {
    private final HandoffSubsystem handoffSubsystem;
    private final XboxController ctrl;
    private double lastSetSpeed = 0;
    
    public void handoffUsingRB(XboxController xboxController, HandoffSubsystem handoffSubsystem) {
        this.handoff = handoffSubsystem;
        this.ctrl = xboxController;
        addRequirements(hangoffSubsystem);
    }
    
    @Override
    public void initialize() {
        handoff.coast();
    }
    
    @Override
    public void execute() {
        double spd = ctrl.getLeftY();
        if (lastSetSpeed != spd) {
            handoff.setSpeed(spd);
            lastSetSpeed = spd;
        }
    }
    
    @Override
    public void end(boolean interrupted) {
        handoff.brake();
    }
    
    @Override
    public boolean isFinished() {
        return false;
    }   
}
