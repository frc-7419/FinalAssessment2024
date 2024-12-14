// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class RunJoystickShooter extends Command {

  private final ShooterSubsystem shooter;
  private final XboxController controller;

  public RunJoystickShooter(
    ShooterSubsystem shooterSubsystem,
    XboxController ctrl
  ) {
    this.shooter = shooterSubsystem;
    this.controller = ctrl;
    addRequirements(shooter);
  }

  @Override
  public void initialize() {
    shooter.coast();
  }

  @Override
  public void execute() {
    shooter.setSpeed(controller.getRightY());
  }

  @Override
  public void end(boolean interrupted) {
    shooter.brake();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
