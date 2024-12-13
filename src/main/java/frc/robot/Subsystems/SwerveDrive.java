// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.swerve.SimSwerveDrivetrain;
import com.ctre.phoenix6.swerve.SwerveDrivetrain;
import com.ctre.phoenix6.swerve.SwerveDrivetrainConstants;
import com.ctre.phoenix6.swerve.SwerveModuleConstants;
import com.ctre.phoenix6.swerve.SwerveRequest;
import com.ctre.phoenix6.swerve.SwerveRequest.ApplyRobotSpeeds;
public class SwerveDrive extends SubsystemBase {
  /** Creates a new SwerveDrive. */
  private final SwerveDrivetrain swerve;
  // public static final double topSpeed = 13.37;

  public SwerveDrive() {
    //Idk why error
    swerve = new SwerveDrivetrain​(new SwerveDrivetrainConstants(), 
    new SwerveModuleConstants().withDriveMotorId(1).withSteerMotorId(2).withCANcoderId(9), 
    new SwerveModuleConstants().withDriveMotorId(3).withSteerMotorId(4).withCANcoderId(10), 
    new SwerveModuleConstants().withDriveMotorId(5).withSteerMotorId(6).withCANcoderId(11), 
    new SwerveModuleConstants().withDriveMotorId(7).withSteerMotorId(8).withCANcoderId(12) );
    
  }
  public Pose2d getPose() {
    return swerve.getState().Pose;
  }

  public void setSpeed(ChassisSpeeds speeds) {
    swerve.setControl(new ApplyRobotSpeeds().withSpeeds(speeds));
  }
  @Override
  public void periodic() {
    for (int i = 0; i < 4; i++) {
      SmartDashboard.putNumber("Swerve module #" + i + " drive motor temperature", swerve.getModule(i).getDriveMotor().getDeviceTemp().getValueAsDouble());
      SmartDashboard.putNumber("Swerve module #" + i + " spin motor temperature", swerve.getModule(i).getSteerMotor().getDeviceTemp().getValueAsDouble());
      SmartDashboard.putNumber("Swerve module #" + i + " angle", swerve.getModule(i).getCurrentState().angle.getDegrees());
      SmartDashboard.putNumber("Swerve module #" + i + " speed m/s", swerve.getModule(i).getCurrentState().speedMetersPerSecond);
      // SmartDashboard.putNumber("Swerve module #" + i + " encoder temperature", swerve.getModule(i).getCANcoder().getDeviceTemp().getValueAsDouble());
    }
  }
  // SmartDashboard.putNumber("Chassis")
}
