// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.pathplanner.lib.commands.PathPlannerAuto;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.RunHandoff;
import frc.robot.commands.RunShooter;
import frc.robot.commands.RunShooterJoystick;
import frc.robot.commands.RunSwerve;
import frc.robot.subsystems.HandoffSubsystem;
import frc.robot.subsystems.HangerSubsystem;
import frc.robot.commands.RunHangerJoystick;
import frc.robot.commands.RunIntake;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.SwerveBase;


public class RobotContainer {
  private final PathPlannerAuto pathPlanner = new PathPlannerAuto("RandAuto");
  private final IntakeSubsystem intake = new IntakeSubsystem();
  private final HangerSubsystem hanger = new HangerSubsystem();
  private final ShooterSubsystem shooter = new ShooterSubsystem();
  private final SwerveBase swerves = new SwerveBase();
  private final HandoffSubsystem handoff = new HandoffSubsystem();
  private final XboxController driver = new XboxController(2);
  private final XboxController operator = new XboxController(3);

  private final RunShooter shootNote = new RunShooter(shooter);
  private final RunHandoff intakeHandoff = new RunHandoff(handoff);
  private final RunHangerJoystick raiseHanger = new RunHangerJoystick(driver, hanger);

  private final RunIntake runIntakeHandoffJoystick = new RunIntake(intake);
  private final RunShooterJoystick shootNoteJoystick = new RunShooterJoystick(operator, shooter);
  private final SwerveBase swerveDrive = new SwerveBase();

  
  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}

