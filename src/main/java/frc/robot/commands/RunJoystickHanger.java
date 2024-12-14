// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.HangerSubsystem;

public class RunJoystickHanger extends Command {

  private final HangerSubsystem hanger;
  private final XboxController controller;

  public RunJoystickHanger(
    HangerSubsystem hangerSubsystem,
    XboxController ctrl
  ) {
    this.hanger = hangerSubsystem;
    this.controller = ctrl;
    addRequirements(hanger);
  }

  @Override
  public void initialize() {
    hanger.coast();
  }

  @Override
  public void execute() {
    if (controller.getRightBumper()) {
      hanger.setSpeed(0.5);
    } else if (controller.getLeftBumper()) {
      hanger.setSpeed(-0.5);
    } else {
      hanger.setSpeed(0);
      hanger.removeDefaultCommand();
    }
  }

  @Override
  public void end(boolean interrupted) {
    hanger.brake();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
