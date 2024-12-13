// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.HangerSubsystem;

public class RaiseHangerBumper extends Command {
  /** Creates a new RaiseHanger. */
  private final HangerSubsystem hanger;
  private final XboxController controller;
  public RaiseHangerBumper(HangerSubsystem hanger, XboxController controller) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.hanger = hanger;
    this.controller = controller;
    addRequirements(hanger);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    hanger.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (controller.getRightBumperPressed()) {
      hanger.setPower(1); //Place holder power
    }
    else if (controller.getLeftBumperPressed()) {
      hanger.setPower(-1); //Place holder power
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    hanger.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}