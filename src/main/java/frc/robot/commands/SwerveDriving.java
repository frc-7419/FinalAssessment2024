// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.SwerveBase;

public class SwerveDriving extends Command {
  /** Creates a new SwerveDriving. */
  private final SwerveBase swerveBase;
  private final XboxController controller;
  public SwerveDriving(SwerveBase swerveBase, XboxController controller) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.swerveBase = swerveBase;
    this.controller = controller;
    addRequirements(swerveBase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    swerveBase.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    swerveBase.setSwerveWithJoystick(controller.getLeftX(), controller.getLeftY(), controller.getRightX());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    swerveBase.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
