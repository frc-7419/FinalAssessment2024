// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.HangerSubsystem;

public class HangerWithJoystick extends Command {
  private final HangerSubsystem hangar;
  private final XboxController ctrl;

  public HangerWithJoystick(XboxController xboxController, HangerSubsystem hangerSubsystem) {
    this.hangar = hangerSubsystem;
    this.ctrl = xboxController;
    addRequirements(hangerSubsystem);
  }

  @Override
  public void initialize() {
    hangar.coast();
  }

  @Override
  public void execute() {
    if (ctrl.getRightBumper()) {
      hangar.setSpeed(0.5);
    } else if (ctrl.getLeftBumper()) {
      hangar.setSpeed(-0.50);
    } else {
      hangar.setSpeed(0);
      hangar.removeDefaultCommand();
    }
  }

  @Override
  public void end(boolean interrupted) {
    hangar.brake();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}