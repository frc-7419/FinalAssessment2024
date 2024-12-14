// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Commands.HangerCommand;
import frc.robot.Commands.IntakeCommand;
import frc.robot.Commands.RunShooter;
import frc.robot.Commands.ShooterCommand;
import frc.robot.Commands.SwerveCommand;
import frc.robot.Subsystems.HandoffSubsystem;
import frc.robot.Subsystems.HangerSubsystem;
import frc.robot.Subsystems.IntakeSubsystem;
import frc.robot.Subsystems.ShooterSubsystem;
import frc.robot.Subsystems.SwerveSubsystem;

public class RobotContainer {
  private final ShooterSubsystem shooter = new ShooterSubsystem();
  private final IntakeSubsystem intake = new IntakeSubsystem();
  private final HandoffSubsystem handoff = new HandoffSubsystem();
  private final HangerSubsystem hanger = new HangerSubsystem();

  private final SwerveSubsystem swerve = new SwerveSubsystem();

  private final XboxController opController = new XboxController(0);
  private final XboxController driveController = new XboxController(1);
  
  private final SwerveCommand swerveCommand = new SwerveCommand(driveController, swerve);
  private final ShooterCommand shooterCommand = new ShooterCommand(opController, shooter);
  private final IntakeCommand intakeCommand = new IntakeCommand(opController, intake, handoff);
  private final HangerCommand hangerCommand = new HangerCommand(opController, hanger);

  private final RunShooter runShooter = new RunShooter(shooter);
  
  public RobotContainer() {


    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
