// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class JoystickSwerveDrive extends Command {
  /** Creates a new JoystickSwerveDrive. */
  private final CommandXboxController driveJoystick;
  private final DrivebaseSubsytem drivebaseSubsytem;
  public JoystickSwerveDrive(CommandXboxController driveJoystick, DrivebaseSubsytem drivebaseSubsytem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveJoystick = driveJoystick;
    this.drivebaseSubsytem = drivebaseSubsytem;
    addRequirements(drivebaseSubsytem);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drivebaseSubsytem.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivebaseSubsytem.joystickControl(driveJoystick.getLeftX(), driveJoystick.getLeftY(), driveJoystick.getRightX());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivebaseSubsytem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
