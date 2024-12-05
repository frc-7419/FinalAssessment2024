// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.ShooterSubsytem;

public class ShootNote extends Command {
  /** Creates a new ShootNote. */
  private final ShooterSubsytem shooter;
  private final CommandXboxController controller;
  public ShootNote(ShooterSubsytem shooter, CommandXboxController controller) {
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
    shooter.setPower(controller.getLeftY() * -1);
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
