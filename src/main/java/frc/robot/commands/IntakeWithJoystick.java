// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.HandoffSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeWithJoystick extends Command {
  private final XboxController ctrl;
  private final IntakeSubsystem intake;
  private final HandoffSubsystem handoff;
  private boolean wasInterrupted = false;

  public IntakeWithJoystick(XboxController xboxController, IntakeSubsystem intakeSubsystem,
      HandoffSubsystem handoffSubsystem) {
    this.ctrl = xboxController;
    this.intake = intakeSubsystem;
    this.handoff = handoffSubsystem;
    addRequirements(intakeSubsystem, handoffSubsystem);
  }

  @Override
  public void initialize() {
    intake.coast();
    handoff.coast();
    wasInterrupted = false;
  }

  @Override
  public void execute() {
    double val = ctrl.getRightY();
    intake.setSpeed(val);
    handoff.setSpeed(val);
  }

  @Override
  public void end(boolean interrupted) {
    if (interrupted)
      wasInterrupted = true;
    intake.brake();
    handoff.brake();
  }

  @Override
  public boolean isFinished() {
    if (wasInterrupted || ctrl.getAButton()) {
      return true;
    }
    return false;
  }
}