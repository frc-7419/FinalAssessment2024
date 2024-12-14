// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.HangerSubsystem;

public class HangerCommand extends Command {
  /** Creates a new HangerCommand. */
  HangerSubsystem hanger;
  XboxController opController;
  public HangerCommand(XboxController opController, HangerSubsystem hangerSubsystem) {
    hanger = hangerSubsystem;
    this.opController = opController;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    hanger.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (opController.getLeftBumper()){
      hanger.run(1.00);
    }
    else if (opController.getRightBumper()){
      hanger.run(-1.00);
    }
    else{
      hanger.brake();
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
    hanger.brake();
    return false;
  }
}
