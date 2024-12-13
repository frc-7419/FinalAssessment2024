// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.Pigeon2;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants.SwerveConstants;

public class SwerveBase extends SubsystemBase {
  /** Creates a new SwerveBase. */
  private final SwerveModule frontRightSwerve;
  private final SwerveModule frontLeftSwerve;
  private final SwerveModule backRightSwerve;
  private final SwerveModule backLeftSwerve;
  private final Pigeon2 gyro;
  public SwerveBase() {
    frontRightSwerve = new SwerveModule(new TalonFX(SwerveConstants.frontRightDrive), new TalonFX(SwerveConstants.frontRightDrive), new CANcoder(SwerveConstants.frontRightDrive), 3.5, "Front Right Module");
    frontLeftSwerve = new SwerveModule(new TalonFX(SwerveConstants.frontLeftDrive), new TalonFX(SwerveConstants.frontLeftDrive), new CANcoder(SwerveConstants.frontLeftDrive), 98.35, "Front Left Module");
    backRightSwerve = new SwerveModule(new TalonFX(SwerveConstants.backRightDrive), new TalonFX(SwerveConstants.backRightDrive), new CANcoder(SwerveConstants.backRightDrive), 74.19, "Back Right Module");
    backLeftSwerve = new SwerveModule(new TalonFX(SwerveConstants.backLeftDrive), new TalonFX(SwerveConstants.backLeftDrive), new CANcoder(SwerveConstants.backLeftDrive), 34.84, "Back Left Module");
    gyro = new Pigeon2(SwerveConstants.gyroID);
    gyro.setYaw(0);
  }

  public void setSwerveWithJoystick(double leftx, double lefty, double rightx){
    setChassisSpeed(ChassisSpeeds.fromFieldRelativeSpeeds(leftx,lefty,rightx,gyro.getRotation2d()));
  }

  public void setChassisSpeed(ChassisSpeeds chassisSpeeds) {
    setSwerveStates(new SwerveDriveKinematics().toSwerveModuleStates(chassisSpeeds));
  }

  public void setSwerveStates(SwerveModuleState[] states){
    frontLeftSwerve.swerveState(states[0]);
    frontRightSwerve.swerveState(states[1]);
    backLeftSwerve.swerveState(states[2]); 
    backRightSwerve.swerveState(states[3]);
  }

  public void coast() {
    frontLeftSwerve.coast();
    frontRightSwerve.coast();
    backLeftSwerve.coast();
    backRightSwerve.coast();
  }

  public void brake() {
    frontLeftSwerve.brake();
    frontRightSwerve.brake();
    backLeftSwerve.brake();
    backRightSwerve.brake();
  }

  public double getRoll() {
    return gyro.getRoll().getValueAsDouble();
  }

  public double getPitch() {
    return gyro.getPitch().getValueAsDouble();
  }

  public double getYaw(){
    return gyro.getYaw().getValueAsDouble();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Front Left Swerve Wheel Angle", frontLeftSwerve.getWheelAngle());
    SmartDashboard.putNumber("Front Right Swerve Wheel Angle", frontRightSwerve.getWheelAngle());
    SmartDashboard.putNumber("Back Left Swerve Wheel Angle", backLeftSwerve.getWheelAngle());
    SmartDashboard.putNumber("Back Right Swerve wheel Angle", backRightSwerve.getWheelAngle());
    SmartDashboard.putNumber("Front Left Swerve Speed", frontLeftSwerve.swerveSpeed());
    SmartDashboard.putNumber("Front Right Swerve Speed", frontRightSwerve.swerveSpeed());
    SmartDashboard.putNumber("Back Left Swerve Speed", backLeftSwerve.swerveSpeed());
    SmartDashboard.putNumber("Back Right Swerve Speed", backRightSwerve.swerveSpeed());
  }
}
