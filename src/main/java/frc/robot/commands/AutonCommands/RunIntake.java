// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutonCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystem.IntakeSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class RunIntake extends Command {
  private final IntakeSubsystem intakeSubsystem;
 
  public RunIntake(IntakeSubsystem intakeSubsystem) {
   this.intakeSubsystem = intakeSubsystem;
  }

  public void initialize() {
    intakeSubsystem.coast();
  }
  @Override
  public void execute() {
    intakeSubsystem.runIntake(1);
  }
  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}