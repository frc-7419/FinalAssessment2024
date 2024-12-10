// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.ShooterSubsystem;

public class RunShooterJoystick extends Command {
  private final ShooterSubsystem shooterSubsystem;
  private final XboxController xboxController;
  public RunShooterJoystick(XboxController xboxController, ShooterSubsystem shooterSubsystem) {
    this.shooterSubsystem = shooterSubsystem;
    this.xboxController = xboxController;
    addRequirements(shooterSubsystem);
  }
  @Override
  public void initialize() {
    shooterSubsystem.coast();
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooterSubsystem.setSpeed(xboxController.getLeftY());
  }
  @Override
  public void end(boolean interrupted) {
    shooterSubsystem.brake();
  }
  @Override
  public boolean isFinished() {
    return false;
  }
}
