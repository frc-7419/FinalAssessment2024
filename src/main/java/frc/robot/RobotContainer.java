// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.SwerveDrive;
import frc.robot.constants.Constants;
import frc.robot.subsystems.drive.DriveBaseSubsystem;

public class RobotContainer {
  private final XboxController driver = new XboxController(Constants.ControllerConstants.kDriveControllerPort);
  private final CommandXboxController operator = new CommandXboxController(Constants.ControllerConstants.kOperatorControllerPort);

  private final DriveBaseSubsystem drivetrain = new DriveBaseSubsystem();

  private final SwerveDrive swerveDrive = new SwerveDrive(driver, drivetrain);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    
    

  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
