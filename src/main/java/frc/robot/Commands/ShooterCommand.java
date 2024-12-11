package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterCommand extends Command{
    private final ShooterSubsystem shooterSubsystem;
    private final XboxController ctrl;
    private double lastSetSpeed = 0;

    public ShooterUsingJoystick(XboxController xboxController, ShooterSubsystem shooterSubsystem) {
        this.shooter = shooterSubsystem;
        this.ctrl = xboxController;
        addRequirements(shooterSubsystem);
    }

  @Override
  public void initialize() {
    shooter.coast();
  }

  @Override
  public void execute() {
    double spd = ctrl.getLeftY();
    if (lastSetSpeed != spd) {
      shooter.setSpeed(spd);
      lastSetSpeed = spd;
    }
  }

  @Override
  public void end(boolean interrupted) {
    shooter.brake();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}

