package frc.robot.commands.hanger;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.hanger.HangerSubsystem;

public class RunJoystickHanger extends Command {
  private final HangerSubsystem hangerSubsystem;  
  private final XboxController xboxController;
  public RunJoystickHanger(HangerSubsystem hangerSubsystem, XboxController xboxController) {
    this.hangerSubsystem = hangerSubsystem; 
    this.xboxController = xboxController;
    addRequirements(hangerSubsystem);
  }

  @Override
  public void initialize() {
    hangerSubsystem.coast();
  }

  @Override
  public void execute() {
    if (xboxController.getRightBumper()) {
        hangerSubsystem.setSpeed(0.5);
      } else if (xboxController.getLeftBumper()){
        hangerSubsystem.setSpeed(-0.5);
    }
  }

  @Override
  public void end(boolean interrupted) {
    hangerSubsystem.brake();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
