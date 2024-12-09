// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.HandOffSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class RunJoystickIntakeHandoff extends Command {
  private final XboxController xboxController;
  private final IntakeSubsystem intakeSubsystem;
  private final HandOffSubsystem handOffSubsystem;
  public RunJoystickIntakeHandoff(XboxController xboxController, IntakeSubsystem intakeSubsystem, HandOffSubsystem handOffSubsystem) {
    this.xboxController = xboxController;
    this.intakeSubsystem = intakeSubsystem;
    this.handOffSubsystem = handOffSubsystem;
    addRequirements(intakeSubsystem, handOffSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intakeSubsystem.coast();
    handOffSubsystem.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intakeSubsystem.setPower(xboxController.getRightY());
    handOffSubsystem.setPower(xboxController.getRightY());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.brake();
    handOffSubsystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}