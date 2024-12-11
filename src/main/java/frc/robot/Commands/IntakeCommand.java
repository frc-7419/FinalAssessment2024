package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand extends Command{
    private final IntakeSubsystem intakeSubsystem;
    private final XboxController ctrl;
    private double lastSetSpeed = 0;
    
    public IntakeUsingJoystick(XboxController xboxController, IntakeSubsystem intakeSubsystem) {
        this.intake = intakeSubsystem;
        this.ctrl = xboxController;
        addRequirements(intakeSubsystem);
    }
    
    @Override
    public void initialize() {
        intake.coast();
    }
    
    @Override
    public void execute() {
        double spd = ctrl.getLeftY();
        if (lastSetSpeed != spd) {
        intake.setSpeed(spd);
        lastSetSpeed = spd;
        }
    }
    
    @Override
    public void end(boolean interrupted) {
        intake.brake();
    }
    
    @Override
    public boolean isFinished() {
        return false;
    }
}
