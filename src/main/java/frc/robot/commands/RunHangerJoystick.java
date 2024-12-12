// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystem.HangerSubsystem;

public class RunHangerJoystick extends Command {
  private final XboxController xboxController;
  private final HangerSubsystem hangerSubsystem;

  public RunHangerJoystick(XboxController xboxController, HangerSubsystem hangerSubsystem) {
    this.xboxController = xboxController;
    this.hangerSubsystem = hangerSubsystem;
  }

  @Override
  public void initialize() {
    this.hangerSubsystem.coast();
  }

  @Override
  public void execute() {
    if (xboxController.getRightBumper()){
      hangerSubsystem.runHanger(1);
    }
    else if (xboxController.getRightBumper()){
      hangerSubsystem.runHanger(-1);
    }
    else{
      hangerSubsystem.runHanger(0);
    }
    

  }

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