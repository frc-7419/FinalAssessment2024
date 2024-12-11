// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.HandoffSubsystem;
import frc.robot.Subsystems.IntakeSubsystem;

public class IntakeCommand extends Command {
  /** Creates a new IntakeCommand. */
  private IntakeSubsystem intakeSubsystem;
  private HandoffSubsystem handoffSubsystem;
  private XboxController opController;
  public IntakeCommand(XboxController OpController, IntakeSubsystem IntakeSubsystem, HandoffSubsystem HandoffSubsystem) {
    this.opController = OpController;
    this.intakeSubsystem = IntakeSubsystem;
    this.handoffSubsystem = HandoffSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intakeSubsystem.coast();
    handoffSubsystem.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intakeSubsystem.run(opController.getRightY());
    handoffSubsystem.run(opController.getRightY());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.brake();
    handoffSubsystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    intakeSubsystem.brake();
    handoffSubsystem.brake();
    return false;
  }
}
