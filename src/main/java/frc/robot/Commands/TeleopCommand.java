// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.HangerSubsystem;
import frc.robot.Subsystems.IntakeAndHandoffSubsystem;
import frc.robot.Subsystems.ShooterSubsystem;
import frc.robot.Subsystems.SwerveDrive;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class TeleopCommand extends Command {
  private final XboxController driveJoystick, operatorJoystick;
  private final HangerSubsystem hangerSubsystem;
  private final IntakeAndHandoffSubsystem intakeAndHandoffSubsystem;
  private final ShooterSubsystem shooterSubsystem;
  private final SwerveDrive swerveDrive;
  /** Creates a new TeleopCommand. */
  public TeleopCommand(HangerSubsystem hanger, IntakeAndHandoffSubsystem intakeAndHandoff, ShooterSubsystem shooter, SwerveDrive swerve) {
    driveJoystick = new XboxController(1);
    operatorJoystick = new XboxController(2);
    hangerSubsystem = hanger;
    intakeAndHandoffSubsystem = intakeAndHandoff;
    shooterSubsystem = shooter;
    swerveDrive = swerve;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    hangerSubsystem.coast();
    intakeAndHandoffSubsystem.coast();
    shooterSubsystem.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intakeAndHandoffSubsystem.setSpeed(operatorJoystick.getRightY());
    if (operatorJoystick.getLeftBumperButton() && !operatorJoystick.getRightBumperButton()) {
      hangerSubsystem.setSpeed(-1);
    } else if (!operatorJoystick.getLeftBumperButton() && operatorJoystick.getRightBumperButton()) {
      hangerSubsystem.setSpeed(1);
    } else {
      hangerSubsystem.setSpeed(0);
    }
    shooterSubsystem.setSpeed(operatorJoystick.getLeftY());
    swerveDrive.setSpeed(new ChassisSpeeds(driveJoystick.getLeftX() * 4, driveJoystick.getLeftY() * 4, driveJoystick.getRightX()));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
