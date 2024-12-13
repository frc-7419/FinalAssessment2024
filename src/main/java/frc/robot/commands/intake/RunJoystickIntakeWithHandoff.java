package frc.robot.commands.intake;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.intake.IntakeSubsystem;
import frc.robot.subsystems.handoff.HandoffSubsystem;
import edu.wpi.first.wpilibj.XboxController;

public class RunJoystickIntakeWithHandoff extends Command {
  private final IntakeSubsystem intakeSubsystem;  
  private final HandoffSubsystem handoffSubsystem;
  private final XboxController xboxController;
  public RunJoystickIntakeWithHandoff(IntakeSubsystem intakeSubsystem, HandoffSubsystem handoffSubsystem, XboxController xboxController) {
    this.intakeSubsystem = intakeSubsystem; 
    this.handoffSubsystem = handoffSubsystem;
    this.xboxController = xboxController;
    addRequirements(intakeSubsystem, handoffSubsystem);
  }

  @Override
  public void initialize() {
    intakeSubsystem.coast();
    handoffSubsystem.coast();
  }

  @Override
  public void execute() {
    intakeSubsystem.setPower(xboxController.getRightY());
    handoffSubsystem.setSpeed(xboxController.getRightY());
  }

  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.brake();
    handoffSubsystem.brake();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}