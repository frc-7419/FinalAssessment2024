// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import com.pathplanner.lib.auto.NamedCommands;
import com.pathplanner.lib.commands.PathPlannerAuto;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.intake.RunJoystickIntakeWithHandoff;
import frc.robot.commands.intake.RunIntake;
import frc.robot.commands.handoff.RunHandoff;
import frc.robot.commands.hanger.RunJoystickHanger;
import frc.robot.commands.shooter.RunJoystickShooter;
import frc.robot.commands.shooter.RunShooter;
import frc.robot.commands.drive.RunSwerveDrive;
import frc.robot.subsystems.handoff.HandoffSubsystem;
import frc.robot.subsystems.hanger.HangerSubsystem;
import frc.robot.subsystems.intake.IntakeSubsystem;
import frc.robot.subsystems.shooter.ShooterSubsystem;
import frc.robot.subsystems.drive.DriveBaseSubsystem;

public class RobotContainer {
  private final DriveBaseSubsystem driveBase =  new DriveBaseSubsystem();
  private final ShooterSubsystem shooter = new ShooterSubsystem();
  private final HandoffSubsystem handoff = new HandoffSubsystem();
  private final IntakeSubsystem intake = new IntakeSubsystem();
  private final HangerSubsystem hanger = new HangerSubsystem();
  
  private final XboxController xboxOperatorController = new XboxController(0);
  private final CommandXboxController xboxDriverController = new CommandXboxController(1);
  private final RunJoystickShooter runJoystickShooter = new RunJoystickShooter(shooter, xboxOperatorController);
  private final RunSwerveDrive runSwerveDrive = new RunSwerveDrive(driveBase, xboxDriverController);
  private final RunJoystickIntakeWithHandoff runJoystickIntakeHandoff = new RunJoystickIntakeWithHandoff(intake, handoff, xboxOperatorController);
  private final RunJoystickHanger runJoystickHanger = new RunJoystickHanger(hanger, xboxOperatorController);

  private final PathPlannerAuto randomAuton = new PathPlannerAuto("RandomAuton");

  private final RunHandoff runHandoff = new RunHandoff(handoff);
  private final RunShooter runShooter = new RunShooter(shooter);
  private final RunIntake runIntake = new RunIntake(intake);

  private final Command runHangerUp = new RunCommand (
    () -> hanger.setSpeed(0.5), hanger
  );
  private final Command runHangerDown = new RunCommand (
    ()->hanger.setSpeed(-0.5), hanger
  );

  public RobotContainer() {
    configureBindings();
    configureNamedCommands();
    setDefaultCommand();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return randomAuton;
  }
  private void configureNamedCommands(){
    NamedCommands.registerCommand("RunShooter",runShooter);
    NamedCommands.registerCommand("RunHandoff",runHandoff);
    NamedCommands.registerCommand("RunIntake",runIntake);
    NamedCommands.registerCommand("RunHangerUp",runHangerUp);
    NamedCommands.registerCommand("RunHangerDown",runHangerDown);
  }
  private void setDefaultCommand(){
    driveBase.setDefaultCommand(runSwerveDrive);
  }
}