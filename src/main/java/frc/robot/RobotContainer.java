// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot;
import com.pathplanner.lib.commands.PathPlannerAuto;
import com.pathplanner.lib.auto.NamedCommands;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.AutonCommands.RunHandOff;
import frc.robot.commands.AutonCommands.RunIntake;
import frc.robot.commands.AutonCommands.RunShooter;

import frc.robot.commands.RunHangerJoystick;
import frc.robot.commands.RunJoystickIntakeHandOff;
import frc.robot.commands.RunShooterJoystick;
import frc.robot.commands.SwerveDriveCommand;

import frc.robot.subsystem.HandOffSubsystem;
import frc.robot.subsystem.IntakeSubsystem;
import frc.robot.subsystem.HangerSubsystem;
import frc.robot.subsystem.ShooterSubsystem;
import frc.robot.subsystem.SwerveDriveSubsystem;

public class RobotContainer {
  private final IntakeSubsystem intake = new IntakeSubsystem();
  private final ShooterSubsystem shooter = new ShooterSubsystem();
  private final HandOffSubsystem handoff = new HandOffSubsystem();
  private final HangerSubsystem hanger = new HangerSubsystem();
  private final SwerveDriveSubsystem swerveDriveSubsystem =  new SwerveDriveSubsystem();
  private final XboxController operatorController = new XboxController(2);
  
  private final CommandXboxController driverController = new CommandXboxController(3);
  
  private final RunShooterJoystick runShooterJoystick = new RunShooterJoystick(operatorController, shooter);
  private final SwerveDriveCommand swerveDriveCommand = new SwerveDriveCommand(swerveDriveSubsystem, driverController,4.3, 6.2, 3.7);
  private final RunJoystickIntakeHandOff runJoystickIntakeHandoff = new RunJoystickIntakeHandOff(operatorController, intake, handoff);
  private final RunHangerJoystick runJoystickHanger = new RunHangerJoystick(operatorController, hanger);

  private final RunIntake runIntake = new RunIntake(intake);
  private final RunHandOff runHandoff = new RunHandOff(handoff);
  private final RunShooter runShooter = new RunShooter(shooter);

  private final PathPlannerAuto threeNoteAuton = new PathPlannerAuto("Two Note Auton");

  public RobotContainer() {
    configureBindings();
    configureNamedCommands();
    setDefaultCommand();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return threeNoteAuton;
  }
  private void configureNamedCommands(){
    NamedCommands.registerCommand("Run Intake",runIntake);
    NamedCommands.registerCommand("Run Shooter",runShooter);
    NamedCommands.registerCommand("Run Handoff",runHandoff);
  }

  private void setDefaultCommand(){
    swerveDriveSubsystem.drive(5.2,3.8,5.2);
  }


}