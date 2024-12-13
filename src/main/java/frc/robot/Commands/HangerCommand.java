// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.HangerSubsystem;

public class HangerCommand extends Command {
  /** Creates a new HangerCommand. */
  HangerSubsystem hangerSubsystem;
  XboxController opController;
  public HangerCommand(HangerSubsystem hangerSubsystem, XboxController opController) {
    this.hangerSubsystem = hangerSubsystem;
    this.opController = opController;
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
    if (opController.getLeftBumper()){
      hangerSubsystem.run(1.00);
    }
    else if (opController.getRightBumper()){
      hangerSubsystem.run(-1.00);
    }
    else{
      hangerSubsystem.brake();
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
    hangerSubsystem.brake();
    return false;
  }
}
