// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.HangerSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class HangerCommand extends Command {
  private final HangerSubsystem hangerSubsystem;
  private final Timer timer;
  private final double speed, durationSeconds;
  /** Creates a new HangerCommand. */
  public HangerCommand(HangerSubsystem hanger, double speed, double durationSeconds) {
    // Use addRequirements() here to declare subsystem dependencies.
    hangerSubsystem = hanger;
    timer = new Timer();
    this.speed = speed;
    this.durationSeconds = durationSeconds;
    addRequirements(hangerSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    hangerSubsystem.coast();
    timer.restart();
    hangerSubsystem.setSpeed(speed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    hangerSubsystem.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer.get() >= durationSeconds;
  }
}
