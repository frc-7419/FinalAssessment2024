// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.HandoffSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class RunIntakeHandoffJoystick extends Command {
  /** Creates a new RunIntakeHandoff. */
  private final IntakeSubsystem intake;
  private final HandoffSubsystem handoff;
  private final XboxController controller;
  public RunIntakeHandoffJoystick(IntakeSubsystem intake, HandoffSubsystem handoff, XboxController controller) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.intake = intake;
    this.handoff = handoff;
    this.controller = controller;
    addRequirements(intake, handoff);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intake.coast();
    handoff.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intake.setPower(controller.getRightY());
    handoff.setPower(controller.getRightY());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.brake();
    handoff.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
