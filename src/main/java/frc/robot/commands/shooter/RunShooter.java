// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.shooter.ShooterSubsystem;

public class RunShooter extends Command {
  private final ShooterSubsystem shooterSubsystem;
  private final XboxController joystick;

  public RunShooter(ShooterSubsystem shooterSubsystem, XboxController joystick) {
    this.shooterSubsystem = shooterSubsystem;
    this.joystick = joystick;
    addRequirements(shooterSubsystem);
  }

  @Override
  public void initialize() {
    shooterSubsystem.coast();
  }

  @Override
  public void execute() {
    shooterSubsystem.setSpeed(joystick.getLeftY());
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