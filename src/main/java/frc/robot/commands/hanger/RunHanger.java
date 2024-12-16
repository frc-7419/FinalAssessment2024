// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.hanger;

import frc.robot.subsystems.hanger.HangerSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

public class RunHanger extends Command {
  private final HangerSubsystem hangerSubsystem;
  private final XboxController joystick;

  public RunHanger(XboxController joystick, HangerSubsystem hangerSubsystem) {
    this.hangerSubsystem = hangerSubsystem;
    this.joystick = joystick;
    addRequirements(hangerSubsystem);
  }

  @Override
  public void initialize() {
    hangerSubsystem.coast();
  }

  @Override
  public void execute() {
    if (joystick.getRightBumper()) {
      hangerSubsystem.setSpeed(0.5);
    } else if (joystick.getLeftBumper()) {
      hangerSubsystem.setSpeed(-0.5);
    }
  }

  @Override
  public void end(boolean interrupted) {
    hangerSubsystem.brake();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}