// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystem.ShooterSubsystem;

public class RunShooterJoystick extends Command {
  /** Creates a new RunShooterJoystick. */
  private final XboxController xboxController;
  private final ShooterSubsystem shooterSubsystem;
  public RunShooterJoystick(XboxController xboxController, ShooterSubsystem shooterSubsystem) {
    this.xboxController = xboxController;
    this.ShooterSubsystem = shooterSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  @Override
  public void initialize() {
    shooterSubsystem.coast();
  }

  @Override
  public void execute() {
    shooterSubsystem.runShooter(xboxController.getRightY());
  }

  @Override
  public void end(boolean interrupted) {
    shooterSubsystem.coast();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
