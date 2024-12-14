// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.HangerSubsystem;


public class RunJoystickHanger extends Command {
  /** Creates a new RunJoystickHanger. */
  private final XboxController xboxController;
  private final HangerSubsystem hangerSubsystem;
  public RunJoystickHanger(XboxController xboxController, HangerSubsystem hangerSubsystem) {
    this.hangerSubsystem = hangerSubsystem;
    this.xboxController = xboxController;
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
    if (xboxController.getRightBumper()){
      hangerSubsystem.setSpeed(1);
    } else if(xboxController.getLeftBumper()){
      hangerSubsystem.setSpeed(-1);
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
