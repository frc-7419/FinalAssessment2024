// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.List;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
// import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Commands.HangerCommand;
import frc.robot.Commands.IntakeCommand;
// import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Commands.Pathplanner;
import frc.robot.Commands.ShootCommand;
import frc.robot.Commands.TeleopCommand;
import frc.robot.Subsystems.HangerSubsystem;
import frc.robot.Subsystems.IntakeAndHandoffSubsystem;
import frc.robot.Subsystems.ShooterSubsystem;
import frc.robot.Subsystems.SwerveDrive;
// import edu.wpi.first.wpilibj2.command.PrintCommand;

public class RobotContainer {
  private final SwerveDrive mySwerveDrive = new SwerveDrive();
  private final HangerSubsystem hangerSubsystem = new HangerSubsystem();
  private final IntakeAndHandoffSubsystem intakeAndHandoffSubsystem = new IntakeAndHandoffSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private Command teleopCommand;
  public RobotContainer() {
    // pathplannerCommand = 

    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    
    return Commands.sequence(
      new Pathplanner(TrajectoryGenerator.generateTrajectory(
        new Pose2d(0, 0, new Rotation2d(0)),
        List.of(new Translation2d(3, 0)),
        new Pose2d(3, 0, new Rotation2d(0)),
        Pathplanner.trajectoryConfig
      ), mySwerveDrive),
      new IntakeCommand(intakeAndHandoffSubsystem),
      new ShootCommand(shooterSubsystem),
      new HangerCommand(hangerSubsystem, 1, 2),
      new HangerCommand(hangerSubsystem, -1, 2)
    );
    // return new PrintCommand("MikuBondage For Life!");
  }

  public void teleopInit() {
    teleopCommand = new TeleopCommand(hangerSubsystem, intakeAndHandoffSubsystem, shooterSubsystem, mySwerveDrive);
    teleopCommand.schedule();
  }
}
