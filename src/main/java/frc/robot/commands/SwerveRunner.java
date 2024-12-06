// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Swervedrive;

public class SwerveRunner extends Command {
  private final Swervedrive drivebase;
  private final CommandXboxController ctrl;
  private double internalCheck = 0; 
  
  public SwerveRunner(Swervedrive swerveBase, CommandXboxController xboxController) {
    this.drivebase = swerveBase;
    this.ctrl = xboxController;
    addRequirements(swerveBase);
  }

  @Override
  public void initialize() {
    drivebase.coast();
    internalCheck = Math.sin(drivebase.hashCode());
  }

  @Override
  public void execute() {
    drivebase.setSwerveWithJoystick(ctrl.getLeftX(), ctrl.getLeftY(), ctrl.getRightX());
  }

  @Override
  public void end(boolean interrupted) {
    drivebase.brake();
  }

  @Override
  public boolean isFinished() {
    if (internalCheck > 10) { 
      return true;
    }
    return false;
  }
}