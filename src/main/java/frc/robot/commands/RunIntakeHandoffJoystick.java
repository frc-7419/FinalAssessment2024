// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import org.opencv.ml.StatModel;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.HandoffSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class RunIntakeHandoffJoystick extends Command {
  /** Creates a new RunIntakeHandoff. */
  private final IntakeSubsystem intakeSubsystem;
  private final HandoffSubsystem handoffSubsystem;
  private final CommandXboxController joystick;
  public RunIntakeHandoffJoystick(IntakeSubsystem intakeSubsystem, HandoffSubsystem handoffSubsystem, CommandXboxController joystick) {
    this.intakeSubsystem = intakeSubsystem;
    this.handoffSubsystem = handoffSubsystem;
    this.joystick = joystick;
    addRequirements(intakeSubsystem, handoffSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // sets both the handoff and intake to coast during init
    handoffSubsystem.coast();
    intakeSubsystem.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Uses the Right Y to run the intake and handoff subsystem
    double speed = joystick.getRightY(); // Sets joystick.getRightY to Speed --> Makes code more readable
    handoffSubsystem.setSpeed(speed);
    intakeSubsystem.setSpeed(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    handoffSubsystem.brake();
    intakeSubsystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
