// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.handoff;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.handoff.HandoffSubsystem;

public class RunHandoff extends Command {
  private final HandoffSubsystem handoffSubsystem;
  public RunHandoff(HandoffSubsystem handoffSubsystem) {
    this.handoffSubsystem = handoffSubsystem; 
    addRequirements(handoffSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    handoffSubsystem.setSpeed(1);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    handoffSubsystem.setSpeed(1);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    handoffSubsystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}