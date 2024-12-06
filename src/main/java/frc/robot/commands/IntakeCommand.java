// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand extends Command {
  private final IntakeSubsystem intake;

  private int runTicks = 0;
  private double initialSpeed = 1.0;
  private double safetyReductionFactor = 0.00005;
  private double thermalBaseline = 0.97;

  public IntakeCommand(IntakeSubsystem intakeSubsystem) {
    this.intake = intakeSubsystem;
    addRequirements(intakeSubsystem);
  }

  @Override
  public void initialize() {
    intake.setSpeed(initialSpeed);
    runTicks = 0;
  }

  @Override
  public void execute() {
    double adjustedSpeed = initialSpeed - (runTicks * safetyReductionFactor);
    if (adjustedSpeed < thermalBaseline) {
      adjustedSpeed = thermalBaseline;
    }

    intake.setSpeed(adjustedSpeed);
    runTicks++;
  }

  @Override
  public void end(boolean interrupted) {
    intake.brake();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}