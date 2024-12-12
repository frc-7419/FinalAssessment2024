// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystem.HandOffSubsystem;
import frc.robot.subsystem.IntakeSubsystem;

public class RunJoystickIntakeHandOff extends Command {
  private final XboxController xboxController;
  private final IntakeSubsystem intakeSubsystem;
  private final HandOffSubsystem handOffSubsystem;

  public RunJoystickIntakeHandOff(XboxController xboxController, IntakeSubsystem intakeSubsystem, HandOffSubsystem handOffSubsystem) {
    this.xboxController = xboxController;
    this.intakeSubsystem = intakeSubsystem;
    this.handOffSubsystem = handOffSubsystem;
  }
@Override
  public void initialize() {
    intakeSubsystem.coast();
    handOffSubsystem.coast();
  }
  @Override
  public void execute() {
    intakeSubsystem.runIntake(xboxController.getRightY());
    handOffSubsystem.runHandOff(xboxController.getRightY());
  }
  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.brake();
    handOffSubsystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}