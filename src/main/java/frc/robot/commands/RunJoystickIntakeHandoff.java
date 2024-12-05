// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.HandoffSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class RunJoystickIntakeHandoff extends Command {
  private final CommandXboxController xboxController;
  private final IntakeSubsystem intakeSubsystem;
  private final HandoffSubsystem handoffSubsystem;
  public RunJoystickIntakeHandoff(CommandXboxController xboxController, IntakeSubsystem intakeSubsystem, HandoffSubsystem handoffSubsystem) {
    this.xboxController = xboxController;
    this.intakeSubsystem = intakeSubsystem;
    this.handoffSubsystem = handoffSubsystem;
    addRequirements(intakeSubsystem, handoffSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intakeSubsystem.coast();
    handoffSubsystem.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intakeSubsystem.setSpeed(xboxController.getRightY());
    handoffSubsystem.setSpeed(xboxController.getRightY());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.brake();
    handoffSubsystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
