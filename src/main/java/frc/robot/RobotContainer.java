// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.RunJoystickShooter;
import frc.robot.commands.RunSwerveDrive;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.SwerveBase;

public class RobotContainer {
  private final SwerveBase swerveBase =  new SwerveBase();
  private final ShooterSubsystem shooter = new ShooterSubsystem();
  private final CommandXboxController operatorController = new CommandXboxController(0);
  private final CommandXboxController driverController = new CommandXboxController(1);
  private final RunJoystickShooter runJoystickShooter = new RunJoystickShooter(operatorController, shooter);
  private final RunSwerveDrive runSwerveDrive = new RunSwerveDrive(swerveBase, driverController);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
