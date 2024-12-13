// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.pathplanner.lib.commands.PathPlannerAuto;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.RaiseHanger;
import frc.robot.commands.RaiseHangerBumper;
import frc.robot.commands.RunIntakeHandoff;
import frc.robot.commands.RunIntakeHandoffJoystick;
import frc.robot.commands.ShootNote;
import frc.robot.commands.ShootNoteJoystick;
import frc.robot.commands.SwerveDriving;
import frc.robot.subsystems.HandoffSubsystem;
import frc.robot.subsystems.HangerSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsytem;
import frc.robot.subsystems.SwerveBase;

public class RobotContainer {
  private final IntakeSubsystem intake = new IntakeSubsystem();
  private final HandoffSubsystem handoff = new HandoffSubsystem();
  private final HangerSubsystem hanger = new HangerSubsystem();
  private final ShooterSubsytem shooter = new ShooterSubsytem();
  private final SwerveBase swerves = new SwerveBase();

  private final XboxController driver = new XboxController(0);
  private final XboxController operator = new XboxController(1);

  private final ShootNote shootNote = new ShootNote(shooter);
  private final RunIntakeHandoff intakeHandoff = new RunIntakeHandoff(intake, handoff);
  private final RaiseHanger raiseHanger = new RaiseHanger(hanger);

  private final RunIntakeHandoffJoystick runIntakeHandoffJoystick = new RunIntakeHandoffJoystick(intake, handoff, operator);
  private final ShootNoteJoystick shootNoteJoystick = new ShootNoteJoystick(shooter, operator);
  private final RaiseHangerBumper raiseHangerBumper = new RaiseHangerBumper(hanger, operator);
  private final SwerveDriving swerveDrive = new SwerveDriving(swerves, driver);

  private final PathPlannerAuto pathPlanner = new PathPlannerAuto("Auto");

  public RobotContainer() {
    configureBindings();
    setDefaultCommand();
  }

  private void setDefaultCommand() {
    hanger.setDefaultCommand(raiseHangerBumper);
    intake.setDefaultCommand(runIntakeHandoffJoystick);
    handoff.setDefaultCommand(runIntakeHandoffJoystick);
    shooter.setDefaultCommand(shootNoteJoystick);
    swerves.setDefaultCommand(swerveDrive);
  }
  
  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
