// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.HandoffSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class RunJoystickIntakeHandoff extends Command {
  /** Creates a new RunJoystickIntakeHandoff. */
  private final XboxController xboxController;
  private final IntakeSubsystem intakeSubsystem;
  private final HandoffSubsystem handoffSubsystem;
  public RunJoystickIntakeHandoff(XboxController xboxController, IntakeSubsystem intakeSubsystem, HandoffSubsystem handoffSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.xboxController = xboxController;
    this.handoffSubsystem = handoffSubsystem;
    this.intakeSubsystem = intakeSubsystem;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    handoffSubsystem.coast();
    intakeSubsystem.coast();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    handoffSubsystem.setSpeed(xboxController.getRightY());
    intakeSubsystem.setSpeed(xboxController.getRightY());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    handoffSubsystem.brake();
    intakeSubsystem.brake();
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
