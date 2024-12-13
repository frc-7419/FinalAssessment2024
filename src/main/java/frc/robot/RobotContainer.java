// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.pathplanner.lib.auto.NamedCommands;
import com.pathplanner.lib.commands.PathPlannerAuto;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.RunHandOff;
import frc.robot.commands.RunIntake;
import frc.robot.commands.RunJoystickHanger;
import frc.robot.commands.RunJoystickHandOffIntake;
import frc.robot.commands.RunJoystickShooter;
import frc.robot.commands.RunShooter;
import frc.robot.commands.RunSwerve;
import frc.robot.subsystems.HandOffSubsystem;
import frc.robot.subsystems.HangerSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.SwerveBase;

public class RobotContainer {
  private final SwerveBase swerveBase = new SwerveBase();
  private final ShooterSubsystem shooter = new ShooterSubsystem();
  private final HandOffSubsystem handoff = new HandOffSubsystem();
  private final IntakeSubsystem intake = new IntakeSubsystem();
  private final HangerSubsystem hanger = new HangerSubsystem();
  private final XboxController operatorController = new XboxController(9);
  private final CommandXboxController driverController = new CommandXboxController(10);
  
  private final RunJoystickShooter runJoystickShooter = new RunJoystickShooter(operatorController, shooter);
  private final RunSwerve runSwerveDrive = new RunSwerve(swerveBase, driverController);
  private final RunJoystickHandOffIntake runJoystickIntakeHandoff = new RunJoystickHandOffIntake(operatorController, intake, handoff);
  private final RunJoystickHanger runJoystickHanger = new RunJoystickHanger(operatorController, hanger);

  private final PathPlannerAuto threeNoteAuton = new PathPlannerAuto("threeNoteAuton");

  private final RunHandOff runHandoff = new RunHandOff(handoff);
  private final RunShooter runShooter = new RunShooter(shooter);
  private final RunIntake runIntake = new RunIntake(intake);

  private final Command runHangerUp = new RunCommand(() -> hanger.setPower(1), hanger);
  private final Command runHangerDown = new RunCommand(() -> hanger.setPower(-1), hanger);

  public RobotContainer() {
    configureBindings();
    configureNamedCommands();
    setDefaultCommand();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return threeNoteAuton;
  }

  private void configureNamedCommands() {
    NamedCommands.registerCommand("Run Shooter", runShooter);
    NamedCommands.registerCommand("Run Handoff", runHandoff);
    NamedCommands.registerCommand("Run Intake", runIntake);
    NamedCommands.registerCommand("Run Hanger Up", runHangerUp);
    NamedCommands.registerCommand("Run Hanger Down", runHangerDown);
  }

  private void setDefaultCommand() {
    swerveBase.setDefaultCommand(runSwerveDrive);
  }
}