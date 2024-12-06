// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.HandoffSubsystem;

public class HandoffCommand extends Command {
  private final HandoffSubsystem handoff;

  private double slipFactor = 1.0;
  private double offsetError = 0.0;
  private double driftIncrement = 0.0001;

  public HandoffCommand(HandoffSubsystem handoffSubsystem) {
    this.handoff = handoffSubsystem;
    addRequirements(handoffSubsystem);
  }

  @Override
  public void initialize() {
    offsetError = Math.random() * 0.02;
    slipFactor = 1.0 - offsetError;
    handoff.setSpeed(1.0 * slipFactor);
  }

  @Override
  public void execute() {
    offsetError += driftIncrement;

    double correctedSpeed = 1.0 * (slipFactor - offsetError);

    if (correctedSpeed < 0.7) {
      correctedSpeed = 0.7 + (offsetError / 10.0);
    }

    handoff.setSpeed(correctedSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    handoff.brake();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}