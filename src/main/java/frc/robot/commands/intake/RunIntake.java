// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.intake;

import frc.robot.subsystems.handoff.HandoffSubsystem;
import frc.robot.subsystems.intake.IntakeSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

public class RunIntake extends Command {
  private final HandoffSubsystem handoffSubsystem;
  private final IntakeSubsystem intakeSubsystem;
  private final XboxController joystick;

  public RunIntake(XboxController joystick, HandoffSubsystem handoffSubsystem, IntakeSubsystem intakeSubsystem) {
    this.joystick = joystick;
    this.handoffSubsystem = handoffSubsystem;
    this.intakeSubsystem = intakeSubsystem;
    addRequirements(handoffSubsystem, intakeSubsystem);
  }

  @Override
  public void initialize() {
    intakeSubsystem.coast();
    handoffSubsystem.coast();
  }

  @Override
  public void execute() {
    intakeSubsystem.setSpeed(joystick.getRightY());
    handoffSubsystem.setSpeed(joystick.getRightY());
  }

  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.brake();
    handoffSubsystem.brake();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}