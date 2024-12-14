package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Subsystems.ShooterSubsystem;

public class ShooterCommand extends Command{
  // making an object shooter of type ShooterSubsystem
  private  ShooterSubsystem shooter;
  // making an object ctrl of type XboxController
  private  XboxController ctrl;
  // making a variable of type double storing the last known speed
  private double lastSetSpeed = 0;

  // Defining the object
  public void ShooterUsingJoystick(XboxController xboxController, ShooterSubsystem shooterSubsystem) {
    this.shooter = shooterSubsystem;
    this.ctrl = xboxController;
    addRequirements(shooterSubsystem);
  }

  // Setting the motors to coast
  @Override
  public void initialize() {
    shooter.coast();
  }

  // Setting the power to the motors
  @Override
  public void execute() {
    double power = ctrl.getLeftY();
    if (lastSetSpeed != power) {
      shooter.runShootersMotors(power);
      lastSetSpeed = power;
    }
  }

  // Setting the motors to brake
  @Override
  public void end(boolean interrupted) {
    shooter.brake();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}

