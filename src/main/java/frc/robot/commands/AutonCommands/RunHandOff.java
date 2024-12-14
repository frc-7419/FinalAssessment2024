// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutonCommands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystem.HandOffSubsystem;

public class RunHandOff extends Command {
  private final HandOffSubsystem handOffSubsystem;

  public RunHandOff(HandOffSubsystem handOffSubsystem) {
    handOffSubsystem.runHandOff(0);
    this.handOffSubsystem = handOffSubsystem;
  }

  @Override
  public void initialize() {
    this.handOffSubsystem.coast();
  }

  @Override
  public void execute() {
    handOffSubsystem.runHandOff(1);
    }


  @Override
  public void end(boolean interrupted) {
    handOffSubsystem.runHandOff(0);
    handOffSubsystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}