// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.shooter;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;

public class RunShooterWithPID extends Command {
  /** Creates a new RunShooterWithPID. */
  private ShooterSubsystem shooterSubsystem;
  private PIDController shooterPidController = new PIDController(12, 0, 0.25);

  public RunShooterWithPID(ShooterSubsystem shooterSubsystem, double rpm) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.shooterSubsystem = shooterSubsystem;
    shooterPidController.setSetpoint(rpm);
    shooterPidController.setTolerance(50);
    addRequirements(shooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
