// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystem.SwerveDriveSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
public class SwerveDriveCommand extends Command {
  private final XboxController xboxController;
  private final SwerveDriveSubsystem swerveDriveSubsystem;
  private double xSpeed;
  private  double ySpeed;
  private double rotation;
  /** Creates a new SwerveDriveCommand. */
  public SwerveDriveCommand(SwerveDriveSubsystem swerveDriveSubsystem,XboxController xboxController,double rotation, double xSpeed, double ySpeed) {
    this.swerveDriveSubsystem = swerveDriveSubsystem;
    this.xboxController = new XboxController(0);
    this.rotation = rotation;
    this.xSpeed = xSpeed;
    this.ySpeed = ySpeed;

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    swerveDriveSubsystem.drive(0,0,0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    xSpeed = xboxController.getLeftX();
    ySpeed = xboxController.getLeftY();
    rotation = xboxController.getRightX();
    swerveDriveSubsystem.drive(xSpeed,ySpeed,rotation);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    swerveDriveSubsystem.drive(0,0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
