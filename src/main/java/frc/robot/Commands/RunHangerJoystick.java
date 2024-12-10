// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.HangerSubsystem;

public class RunHangerJoystick extends Command {
  private final HangerSubsystem hangerSubsystem; 
  private final XboxController xboxController;
  public RunHangerJoystick(XboxController xboxController, HangerSubsystem hangerSubsystem) {
    this.hangerSubsystem = hangerSubsystem;
    this.xboxController = xboxController;
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
    if (xboxController.getRightBumper()) {
        hangerSubsystem.setSpeed(0.8);
    }else if(xboxController.getLeftBumper()){
        hangerSubsystem.setSpeed(-0.8);
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