// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.HandoffSubsystem;

public class RunHandoff extends Command {
  private final HandoffSubsystem handoffSubsystem;
  public RunHandoff(HandoffSubsystem handoffSubsystem) {
    this.handoffSubsystem = handoffSubsystem; 
    addRequirements(handoffSubsystem);
  }
  @Override
  public void initialize() {
    handoffSubsystem.setSpeed(0.8);
  }
  @Override
  public void execute() {
    handoffSubsystem.setSpeed(0.8);
  }
  @Override
  public void end(boolean interrupted) {
    handoffSubsystem.brake();
  }
  @Override
  public boolean isFinished() {
    return false;
  }
}
