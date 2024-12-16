// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.drive;

import com.ctre.phoenix6.hardware.Pigeon2;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Constants.SwerveConstants;

public class Swerve extends SubsystemBase {
  private final SwerveModule frontLeftModule;
  private final SwerveModule frontRightModule;
  private final SwerveModule backLeftModule;
  private final SwerveModule backRightModule;
  private final Pigeon2 gyro;

  /** Creates a new DrivebaseSubsystem. */
  public Swerve() {
    frontLeftModule = new SwerveModule(SwerveConstants.frontLeft.turnMotorID, SwerveConstants.frontLeft.driveMotorID, SwerveConstants.frontLeft.turnEncoderID, SwerveConstants.frontLeft.offset, "fl");
    frontRightModule = new SwerveModule(SwerveConstants.frontRight.turnMotorID, SwerveConstants.frontRight.driveMotorID, SwerveConstants.frontRight.turnEncoderID, SwerveConstants.frontRight.offset, "fr");
    backLeftModule = new SwerveModule(SwerveConstants.backLeft.turnMotorID, SwerveConstants.backLeft.driveMotorID, SwerveConstants.backLeft.turnEncoderID, SwerveConstants.backLeft.offset, "bl");
    backRightModule = new SwerveModule(SwerveConstants.backRight.turnMotorID, SwerveConstants.backRight.driveMotorID, SwerveConstants.backRight.turnEncoderID, SwerveConstants.backRight.offset, "br");

    gyro = new Pigeon2(0);
    gyro.reset();
  }


  public double getYaw() { 
    return gyro.getAngle();
  }

  public double getPitch() {
    return gyro.getPitch().getValue();
  }

  public double getRoll() {
    return gyro.getRoll().getValue();
  }

  public void zeroYaw() {
    gyro.reset();
  }
  public Rotation2d getRotation2d() {
    return gyro.getRotation2d();
  }

  public void coast() {
    frontLeftModule.coast();
    frontRightModule.coast();
    backLeftModule.coast();
    backRightModule.coast();
  }

  public void brake() {
    frontLeftModule.brake();
    frontRightModule.brake();
    backLeftModule.brake();
    backRightModule.brake();
  }

  public void stop() {
    frontLeftModule.stop();
    frontRightModule.stop();
    backLeftModule.stop();
    backRightModule.stop();
  }

  public ChassisSpeeds getChassisSpeeds(double vx, double vy, double rx) {
    return ChassisSpeeds.fromFieldRelativeSpeeds(vx, vy, rx, getRotation2d());
  }

  public void setModuleStates(SwerveModuleState[] moduleStates) {
    frontLeftModule.setSwerveModuleState(moduleStates[0]);
    frontRightModule.setSwerveModuleState(moduleStates[1]);
    backLeftModule.setSwerveModuleState(moduleStates[2]);
    backRightModule.setSwerveModuleState(moduleStates[3]);
  }

  public void setModuleStates(ChassisSpeeds chassisSpeeds) {
    setModuleStates(SwerveConstants.m_SwerveDriveKinematics.toSwerveModuleStates(chassisSpeeds));
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("yaw", this.getYaw());
    frontLeftModule.putDashboard();
    backLeftModule.putDashboard();
    frontRightModule.putDashboard();
    backRightModule.putDashboard();
  }
}