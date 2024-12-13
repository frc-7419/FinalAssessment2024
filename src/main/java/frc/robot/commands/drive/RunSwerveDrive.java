// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.drive.DriveBaseSubsystem;

public class RunSwerveDrive extends Command {
  private final DriveBaseSubsystem driveBase;
  private final CommandXboxController xboxController;
  public RunSwerveDrive(DriveBaseSubsystem driveBase, CommandXboxController xboxController) {
    this.driveBase = driveBase;
    this.xboxController = xboxController;
    addRequirements(driveBase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveBase.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveBase.setSwerveUsingJoystick(xboxController.getLeftX(), xboxController.getLeftY(), xboxController.getRightX());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveBase.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}