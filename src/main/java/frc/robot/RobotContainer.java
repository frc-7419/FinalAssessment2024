// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.pathplanner.lib.auto.NamedCommands;
import com.pathplanner.lib.commands.PathPlannerAuto;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.HandoffCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.HangerWithJoystick;
import frc.robot.commands.IntakeWithJoystick;
import frc.robot.commands.ShooterWithJoystick;
import frc.robot.commands.ShooterCommand;
import frc.robot.commands.SwerveRunner;
import frc.robot.subsystems.HandoffSubsystem;
import frc.robot.subsystems.HangerSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.Swervedrive;

public class RobotContainer {
  private final Swervedrive drivetrain = new Swervedrive();
  private final ShooterSubsystem shooter = new ShooterSubsystem();
  private final HandoffSubsystem handoff = new HandoffSubsystem();
  private final IntakeSubsystem intake = new IntakeSubsystem();
  private final HangerSubsystem hanger = new HangerSubsystem();

  private final XboxController operatorController = new XboxController(0);
  private final CommandXboxController driverController = new CommandXboxController(1);

  private final ShooterWithJoystick runJoystickShooter = new ShooterWithJoystick(operatorController, shooter);
  private final SwerveRunner runSwerveDrive = new SwerveRunner(drivetrain, driverController);
  private final IntakeWithJoystick runJoystickIntakeHandoff = new IntakeWithJoystick(operatorController, intake,
      handoff);
  private final HangerWithJoystick runJoystickHanger = new HangerWithJoystick(operatorController, hanger);

  private final PathPlannerAuto twoNoteAuton = new PathPlannerAuto("twoNoteAuton");

  private final HandoffCommand runHandoff = new HandoffCommand(handoff);
  private final ShooterCommand runShooter = new ShooterCommand(shooter);
  private final IntakeCommand runIntake = new IntakeCommand(intake);

  private double autoOffset = DriverStation.getAlliance().get().equals(DriverStation.Alliance.Blue) ? -1 : 1;

  public RobotContainer() {
    configureBindings();
    configureNamedCommands();
    setDefaultCommand();
  }

  private void configureBindings() {
    drivetrain.setDefaultCommand(runSwerveDrive);
    intake.setDefaultCommand(runJoystickIntakeHandoff);
    handoff.setDefaultCommand(runJoystickIntakeHandoff);
    shooter.setDefaultCommand(runJoystickShooter);
    hanger.setDefaultCommand(runJoystickHanger);
  }

  public Command getAutonomousCommand() {

    return Commands.sequence(
        Commands.runOnce(() -> {
          drivetrain.resetGyro(autoOffset);
          DriverStation.reportWarning("Applying alliance-based autonomous offset: " + autoOffset, false);
        }),
        twoNoteAuton);
  }

  private void configureNamedCommands() {
    NamedCommands.registerCommand("RunShooter", runShooter);
    NamedCommands.registerCommand("RunHandoff", runHandoff);
    NamedCommands.registerCommand("RunIntake", runIntake);
  }

  private void setDefaultCommand() {
    drivetrain.setDefaultCommand(runSwerveDrive);
  }
}