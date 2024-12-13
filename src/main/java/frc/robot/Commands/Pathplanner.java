// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.math.controller.LTVUnicycleController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.constraint.DifferentialDriveVoltageConstraint;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.*;
public class Pathplanner extends Command {
  private LTVUnicycleController satnav = new LTVUnicycleController(1);
  private final Trajectory trajectory;
  private final SwerveDrive swerve;
  private final Timer timer = new Timer();
  /** Creates a new Pathplanner. */
  public Pathplanner(Trajectory trajectory, SwerveDrive swerve) {
    this.trajectory = trajectory;
    this.swerve = swerve;
    addRequirements(swerve);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.restart();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    swerve.setSpeed(satnav.calculate(swerve.getPose(), trajectory.sample(timer.get())));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return satnav.atReference();
  }
  //Config for creating commands
  public final static double metersPerInch = 0.0254;
  public final static DifferentialDriveKinematics driveKinematics = new DifferentialDriveKinematics(25 * metersPerInch);
  public final static DifferentialDriveVoltageConstraint autoVoltageConstraint = new DifferentialDriveVoltageConstraint(
    new SimpleMotorFeedforward(
        1,//DriveConstants.ksVolts,
        2,//DriveConstants.kvVoltSecondsPerMeter,
        3//DriveConstants.kaVoltSecondsSquaredPerMeter),
    ),
    driveKinematics,//DriveConstants.kDriveKinematics,
    10);
  public final static TrajectoryConfig trajectoryConfig = new TrajectoryConfig(
    4,//AutoConstants.kMaxSpeedMetersPerSecond,
    5//AutoConstants.kMaxAccelerationMetersPerSecondSquared)
// Add kinematics to ensure max speed is actually obeyed
).setKinematics(driveKinematics)
// Apply the voltage constraint
.addConstraint(autoVoltageConstraint);


}
