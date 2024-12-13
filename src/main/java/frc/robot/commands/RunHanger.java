// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import javax.swing.text.StyledEditorKit.BoldAction;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.HangerSubsystem;

public class RunHanger extends Command {
  /** Creates a new RunHanger. */
  private final HangerSubsystem hangerSubsystem;
  private boolean upOrDown;
  public RunHanger(HangerSubsystem hangerSubsystem, boolean upOrDown) {
    this.hangerSubsystem = hangerSubsystem;
    this.upOrDown = upOrDown;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    hangerSubsystem.coast(); // DO we need to brake because the hanger would fall down if it is up?
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (upOrDown){
      hangerSubsystem.setSpeed(0.9);
    }
    if (!upOrDown){
      hangerSubsystem.setSpeed(-0.9);
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
