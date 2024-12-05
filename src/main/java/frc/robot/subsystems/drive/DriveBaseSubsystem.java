// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.drive;

import com.ctre.phoenix6.hardware.Pigeon2;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants.SwerveConstants;

public class DriveBaseSubsystem extends SubsystemBase {
  private final SwerveModule frontLeftModule;
  private final SwerveModule frontRightModule;
  private final SwerveModule backLeftModule;
  private final SwerveModule backRightModule;
  private final Pigeon2 gyro;

  /** Creates a new DrivebaseSubsystem. */
  public DriveBaseSubsystem() {
    frontLeftModule = new SwerveModule(SwerveConstants.frontLeft.turnMotorID,
        SwerveConstants.frontLeft.driveMotorID, SwerveConstants.frontLeft.turnEncoderID,
        SwerveConstants.frontLeft.offset, "FrontLeftModule");
    frontRightModule = new SwerveModule(SwerveConstants.frontRight.turnMotorID,
        SwerveConstants.frontRight.driveMotorID, SwerveConstants.frontRight.turnEncoderID,
        SwerveConstants.frontRight.offset, "FrontRightModule");
    backLeftModule = new SwerveModule(SwerveConstants.backLeft.turnMotorID, SwerveConstants.backLeft.driveMotorID,
        SwerveConstants.backLeft.turnEncoderID, SwerveConstants.backLeft.offset, "BackLeftModule");
    backRightModule = new SwerveModule(SwerveConstants.backRight.turnMotorID,
        SwerveConstants.backRight.driveMotorID, SwerveConstants.backRight.turnEncoderID,
        SwerveConstants.backRight.offset, "BackRightModule");
    gyro = new Pigeon2(0);
    gyro.reset();
  }

  public void zeroYaw() {
    gyro.reset();
  }

  public double getYaw() { // CW IS POSITIVE BY DEFAULT
    return -gyro.getAngle();
  }

  public double getPitch() {
    return gyro.getPitch().getValue();
  }

  public double getRoll() {
    return gyro.getRoll().getValue();
  }

  public boolean reachedDist(double meters) {
    return (frontLeftModule.reachedDist(meters)) &&
        (frontRightModule.reachedDist(meters)) &&
        (backLeftModule.reachedDist(meters)) &&
        (backRightModule.reachedDist(meters));
  }

  public void resetDriveEnc() {
    frontLeftModule.resetDriveEncoder();
    frontRightModule.resetDriveEncoder();
    backLeftModule.resetDriveEncoder();
    backRightModule.resetDriveEncoder();
  }

  public Rotation2d getRotation2d() {
    return gyro.getRotation2d();
  }

  public void brake() {
    frontLeftModule.brake();
    frontRightModule.brake();
    backLeftModule.brake();
    backRightModule.brake();
  }

  public void coast() {
    frontLeftModule.coast();
    frontRightModule.coast();
    backLeftModule.coast();
    backRightModule.coast();
  }

  public void stop() {
    frontLeftModule.stop();
    frontRightModule.stop();
    backLeftModule.stop();
    backRightModule.stop();
  }

  /**
   * Returns chassis speeds from field-centric joystick controls. This is what
   * determines the translational speed of the robot in proportion to joystick
   * values.
   *
   * @param joystick
   * @return
   */
  public ChassisSpeeds getChassisSpeedsFromJoystick(double vx, double vy, double rx, boolean slowMode) {
    vx = Math.abs(vx) > 0.05 ? -vx * SwerveConstants.kMaxTranslationalSpeed : 0;
    vy = Math.abs(vy) > 0.05 ? vy * SwerveConstants.kMaxTranslationalSpeed : 0;
    rx = Math.abs(rx) > 0.05 ? -0.7 * rx * SwerveConstants.kMaxRotationalSpeed : 0;
    if (slowMode) {
      vx *= 0.2;
      vy *= 0.2;
      rx *= 0.2;
    }
    return ChassisSpeeds.fromFieldRelativeSpeeds(vx, vy, rx, getRotation2d());
  }

  /**
   * Sets the individual swerve module states
   *
   * @param moduleStates
   */
  public void setModuleStates(SwerveModuleState[] moduleStates) {
    frontLeftModule.setSwerveModuleState(moduleStates[0]);
    frontRightModule.setSwerveModuleState(moduleStates[1]);
    backLeftModule.setSwerveModuleState(moduleStates[2]);
    backRightModule.setSwerveModuleState(moduleStates[3]);
  }

  /**
   * Sets the individual swerve module states from chassis speed
   *
   * @param moduleStates
   */
  public void setModuleStates(ChassisSpeeds chassisSpeeds) {
    setModuleStates(SwerveConstants.m_SwerveDriveKinematics.toSwerveModuleStates(chassisSpeeds));
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Yaw", getYaw());
    frontLeftModule.outputDashboard();
    frontRightModule.outputDashboard();
    backLeftModule.outputDashboard();
    backRightModule.outputDashboard();
  }
}
