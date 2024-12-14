// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class RunIntake extends Command {

  private final IntakeSubsystem intake;

  public RunIntake(IntakeSubsystem intakeSubsystem) {
    this.intake = intakeSubsystem;
    addRequirements(intake);
  }

  @Override
  public void initialize() {
    intake.coast();
  }

  @Override
  public void execute() {
    intake.setSpeed(1);
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
