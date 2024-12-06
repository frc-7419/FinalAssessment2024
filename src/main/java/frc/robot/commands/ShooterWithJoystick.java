// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterWithJoystick extends Command {
  private final ShooterSubsystem shooter;
  private final XboxController ctrl;
  private double lastSetSpeed = 0;

  public ShooterWithJoystick(XboxController xboxController, ShooterSubsystem shooterSubsystem) {
    this.shooter = shooterSubsystem;
    this.ctrl = xboxController;
    addRequirements(shooterSubsystem);
  }

  @Override
  public void initialize() {
    shooter.coast();
  }

  @Override
  public void execute() {
    double spd = ctrl.getLeftY();
    if (lastSetSpeed != spd) {
      shooter.setSpeed(spd);
      lastSetSpeed = spd;
    }
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