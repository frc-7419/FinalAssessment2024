// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.pathplanner.lib.commands.PathPlannerAuto;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.Constants;
import frc.robot.subsystems.drive.DrivebaseSubsytem;
import frc.robot.subsystems.drive.JoystickSwerveDrive;
import frc.robot.subsystems.hanger.HangerSubsystem;
import frc.robot.subsystems.hanger.RunHanger;
import frc.robot.subsystems.intake.IntakeSubsystem;
import frc.robot.subsystems.intake.RunIntake;
import frc.robot.subsystems.shooter.RunShooter;
import frc.robot.subsystems.shooter.ShooterSubsystem;
import frc.robot.subsystems.wrist.RunWrist;
import frc.robot.subsystems.wrist.SetWristToSetpoint;
import frc.robot.subsystems.wrist.WristSubsystem;

public class RobotContainer {
  private CommandXboxController driverJoystick = new CommandXboxController(Constants.driveJoystickPort);
  private CommandXboxController operatorJoystick = new CommandXboxController(Constants.operatorJoystickPort);
  private WristSubsystem wristSubsystem = new WristSubsystem();
  private IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private HangerSubsystem hangerSubsystem = new HangerSubsystem();
  private DrivebaseSubsytem drivebaseSubsytem = new DrivebaseSubsytem();
  private RunHanger runHanger = new RunHanger(operatorJoystick, hangerSubsystem);
  private RunIntake runIntake = new RunIntake(intakeSubsystem, operatorJoystick);
  private RunShooter runShooter = new RunShooter(shooterSubsystem, operatorJoystick);
  private RunWrist runWrist = new RunWrist(operatorJoystick, wristSubsystem);
  private JoystickSwerveDrive joystickSwerveDrive = new JoystickSwerveDrive(driverJoystick, drivebaseSubsytem);
  

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    operatorJoystick.a().whileTrue(new SetWristToSetpoint(wristSubsystem, 60.0/360.0));
  }

  public Command getAutonomousCommand() {
    return new PathPlannerAuto("ShootingAuto");
  }
  public void setdefaultCommands() {
    wristSubsystem.setDefaultCommand(runWrist);
    intakeSubsystem.setDefaultCommand(runIntake);
    hangerSubsystem.setDefaultCommand(runHanger);    
    shooterSubsystem.setDefaultCommand(runShooter);
    drivebaseSubsytem.setDefaultCommand(joystickSwerveDrive);
  }
}
