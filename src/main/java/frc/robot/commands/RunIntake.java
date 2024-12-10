// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.drive.DriveBaseSubsystem;
import frc.robot.subsystems.handoff.HandoffSubsystem;
import frc.robot.subsystems.intake.IntakeSubsystem;

public class RunIntake extends Command {
  private XboxController joystick;
  private HandoffSubsystem handoffSubsystem;
  private IntakeSubsystem intakeSubsystem;

  public RunIntake(XboxController joystick, HandoffSubsystem handoffSubsystem, IntakeSubsystem intakeSubsystem) {
    this.joystick = joystick;
    this.handoffSubsystem = handoffSubsystem;
    this.intakeSubsystem = intakeSubsystem;
    addRequirements(handoffSubsystem, intakeSubsystem);
  }

  @Override
  public void initialize() {
    handoffSubsystem.coast();
    intakeSubsystem.coast();
  }

  @Override
  public void execute() {
    intakeSubsystem.setSpeed(joystick.getRightY());
    handoffSubsystem.setSpeed(joystick.getRightY());
  }

  @Override
  public void end(boolean interrupted) {
    handoffSubsystem.brake();
    intakeSubsystem.brake();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}