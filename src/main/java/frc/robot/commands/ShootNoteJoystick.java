// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsytem;

public class ShootNoteJoystick extends Command {
  /** Creates a new ShootNote. */
  private final ShooterSubsytem shooter;
  private final XboxController controller;
  public ShootNoteJoystick(ShooterSubsytem shooter, XboxController controller) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.shooter = shooter;
    this.controller = controller;
    addRequirements(shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooter.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooter.setPower(controller.getLeftY()); 
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooter.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
