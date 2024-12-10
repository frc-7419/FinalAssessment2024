// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.RunDriveTrain;
import frc.robot.commands.RunHanger;
import frc.robot.commands.RunIntake;
import frc.robot.commands.RunShooter;
import frc.robot.constants.Constants;
import frc.robot.subsystems.drive.DriveBaseSubsystem;
import frc.robot.subsystems.handoff.HandoffSubsystem;
import frc.robot.subsystems.hanger.HangerSubsystem;
import frc.robot.subsystems.intake.IntakeSubsystem;
import frc.robot.subsystems.shooter.ShooterSubsystem;

public class RobotContainer {
  private final CommandXboxController driver = new CommandXboxController(Constants.ControllerConstants.kDriveControllerPort);
  private final XboxController operator = new XboxController(Constants.ControllerConstants.kOperatorControllerPort);

  private final DriveBaseSubsystem drivetrain = new DriveBaseSubsystem();
  private final HandoffSubsystem handoffSubsystem = new HandoffSubsystem();
  private final HangerSubsystem hangerSubsystem = new HangerSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();

  private final RunDriveTrain swerveDrive = new RunDriveTrain(driver, drivetrain);
  private final RunHanger hanger = new RunHanger(operator, hangerSubsystem);
  private final RunIntake intake = new RunIntake(operator, handoffSubsystem, intakeSubsystem);
  private final RunShooter shooter = new RunShooter(operator, shooterSubsystem);

  public RobotContainer() {
    configureBindings();
    setDefaultCommand();
  }

  private void configureBindings() {

  }

  private void setDefaultCommand() {
    drivetrain.setDefaultCommand(swerveDrive);
    intakeSubsystem.setDefaultCommand(intake);
    hangerSubsystem.setDefaultCommand(hanger);
    shooterSubsystem.setDefaultCommand(shooter);
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
