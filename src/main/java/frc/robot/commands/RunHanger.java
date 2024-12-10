// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.hanger.HangerSubsystem;

public class RunHanger extends Command {
  private XboxController joystick;
  private HangerSubsystem hangerSubsystem;

  /** Creates a new RunHanger. */
  public RunHanger(XboxController joystick, HangerSubsystem hangerSubsystem) {
    this.hangerSubsystem = hangerSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(hangerSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    hangerSubsystem.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (joystick.getRightBumper()) {
      hangerSubsystem.setSpeed(0.5);
    } else if (joystick.getLeftBumper()) {
      hangerSubsystem.setSpeed(-0.5);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    hangerSubsystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
