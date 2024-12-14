// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.ShooterSubsystem;

public class RunShooter extends Command {
  /** Creates a new RunShooter. */
  private final ShooterSubsystem shooter;
  public RunShooter(ShooterSubsystem shooterSubsystem) {
    shooter = shooterSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooter.run(1);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooter.run(1);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooter.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    shooter.brake();
    return false;
  }
}
