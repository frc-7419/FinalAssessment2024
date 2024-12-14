// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.SwerveBase;

public class RunSwerve extends Command {

  private final SwerveBase swerveBase;
  private final CommandXboxController controller;

  public RunSwerve(SwerveBase swerve, CommandXboxController ctrl) {
    this.swerveBase = swerve;
    this.controller = ctrl;
    addRequirements(swerveBase);
  }

  @Override
  public void initialize() {
    swerveBase.coast();
  }

  @Override
  public void execute() {
    swerveBase.setSwerve(
      controller.getLeftX(),
      controller.getLeftY(),
      controller.getRightX()
    );
  }

  @Override
  public void end(boolean interrupted) {
    swerveBase.brake();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
