// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.RunJoystickHanger;
import frc.robot.commands.RunJoystickIntakeHandoff;
import frc.robot.commands.RunJoystickShooter;
import frc.robot.commands.RunSwerveDrive;
import frc.robot.subsystems.HandoffSubsystem;
import frc.robot.subsystems.HangerSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.SwerveBase;

public class RobotContainer {
  private final SwerveBase swerveBase =  new SwerveBase();
  private final ShooterSubsystem shooter = new ShooterSubsystem();
  private final HandoffSubsystem handoff = new HandoffSubsystem();
  private final IntakeSubsystem intake = new IntakeSubsystem();
  private final HangerSubsystem hanger = new HangerSubsystem();
  private final XboxController operatorController = new XboxController(0);
  private final CommandXboxController driverController = new CommandXboxController(1);
  
  private final RunJoystickShooter runJoystickShooter = new RunJoystickShooter(operatorController, shooter);
  private final RunSwerveDrive runSwerveDrive = new RunSwerveDrive(swerveBase, driverController);
  private final RunJoystickIntakeHandoff runJoystickIntakeHandoff = new RunJoystickIntakeHandoff(operatorController, intake, handoff);
  private final RunJoystickHanger runJoystickHanger = new RunJoystickHanger(operatorController, hanger);
  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
