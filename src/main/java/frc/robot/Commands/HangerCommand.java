package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Subsystems.HangerSubsystem;

public class HangerCommand extends Command{
  // making an object hangerSubsystem of type HangerSubsystem
  private final HangerSubsystem hangerSubsystem;
  // making an object ctrl of type XboxController
  private final XboxController ctrl;
  // making a variable of type double storing the last known speed
  private double lastSetSpeed = 0;

  // Defining the object
  public void HangerUsingLT(XboxController xboxController, HangerSubsystem hangerSubsystem) {
    this.hanger = hangerSubsystem;
    this.ctrl = xboxController;
    addRequirements(hangerSubsystem);
  }

  // Setting the motors to coast
  @Override
  public void initialize() {
    hanger.coast();
  }

  // Setting the power to the motors
  @Override
  public void execute() {
    double spd = ctrl.getLeftY();
    if (lastSetSpeed != spd) {
      hanger.runHangerMotors(spd);
      lastSetSpeed = spd;
    }
  }

  // Setting the motors to brake
  @Override
  public void end(boolean interrupted) {
    hanger.brake();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}

