// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.pathplanner.lib.commands.PathPlannerAuto;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.RunHandoff;
import frc.robot.commands.RunHanger;
import frc.robot.commands.RunHangerJoystick;
import frc.robot.commands.RunIntake;
import frc.robot.commands.RunIntakeHandoffJoystick;
import frc.robot.commands.RunShooter;
import frc.robot.commands.RunShooterJoystick;
import frc.robot.commands.RunSwerveBase;
import frc.robot.subsystems.HandoffSubsystem;
import frc.robot.subsystems.HangerSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.SwerveBase;

public class RobotContainer {
  // Init all the subsystems commands and required stuff
  private final HandoffSubsystem handoffSubsystem = new HandoffSubsystem();
  private final HangerSubsystem hangerSubsystem = new HangerSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final SwerveBase swerveBase = new SwerveBase();

  private final CommandXboxController joystick = new CommandXboxController(0);
  private final CommandXboxController driver = new CommandXboxController(1);

  private final RunHandoff runHandoff = new RunHandoff(handoffSubsystem);
  private final RunHanger runHanger = new RunHanger(hangerSubsystem, false);
  private final RunHangerJoystick runHangerJoystick = new RunHangerJoystick(hangerSubsystem, joystick);
  private final RunIntake runIntake = new RunIntake(intakeSubsystem);
  private final RunIntakeHandoffJoystick runIntakeHandoffJoystick = new RunIntakeHandoffJoystick(intakeSubsystem, handoffSubsystem, joystick);
  private final RunShooter runShooter = new RunShooter(shooterSubsystem);
  private final RunShooterJoystick runShooterJoystick = new RunShooterJoystick(shooterSubsystem, joystick);
  private final RunSwerveBase runSwerveBase = new RunSwerveBase(swerveBase, driver);

  private final PathPlannerAuto testingAuto = new PathPlannerAuto("testAuto");



  public RobotContainer() {
    setDefaultCommand();
    configureBindings();
    getAutonomousCommand();
  }
  private void setDefaultCommand(){
    hangerSubsystem.setDefaultCommand(runHangerJoystick);
    swerveBase.setDefaultCommand(runSwerveBase);
    shooterSubsystem.setDefaultCommand(runShooterJoystick);
    handoffSubsystem.setDefaultCommand(runIntakeHandoffJoystick);
  }
  private void configureBindings() {}

  public Command getAutonomousCommand() {

    return testingAuto;
  }
}
