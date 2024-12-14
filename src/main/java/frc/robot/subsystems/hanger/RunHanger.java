// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.hanger;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RunHanger extends Command {
  /** Creates a new RunIntake. */
  private HangerSubsystem hangerSubsystem;
  private CommandXboxController operatorJoystick;
  public RunHanger(CommandXboxController operatorJoystick, HangerSubsystem hangerSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.hangerSubsystem = hangerSubsystem;
    this.operatorJoystick = operatorJoystick;
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
    if (operatorJoystick.getRightTriggerAxis() > 0.05) {
      hangerSubsystem.set(operatorJoystick.getRightTriggerAxis());
    
  }else if (operatorJoystick.getLeftTriggerAxis() > 0.05) {
    hangerSubsystem.set(-operatorJoystick.getLeftTriggerAxis());
    
  }
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}