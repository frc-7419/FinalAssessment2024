// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.HangerSubsystem;

public class RunHangerJoystick extends Command {
  /** Creates a new RunHangerJoystick. */
  private final HangerSubsystem hangerSubsystem;
  private final CommandXboxController joystick;
  public RunHangerJoystick(HangerSubsystem hangerSubsystem, CommandXboxController joystick) {
    this.hangerSubsystem = hangerSubsystem;
    this.joystick = joystick;
    addRequirements(hangerSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    hangerSubsystem.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
