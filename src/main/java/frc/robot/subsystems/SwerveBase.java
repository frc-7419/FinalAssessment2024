// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.lang.reflect.Array;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.Pigeon2;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveBase extends SubsystemBase {
  /** Creates a new SwerveBase. */
  private final SwerveModule rightBack;
  private final Pigeon2 gyroscope;
  private final SwerveModule leftFront;
  private final SwerveModule rightFront;
  private final SwerveModule leftBack;
  public SwerveBase() {
    rightFront = new SwerveModule(new TalonFX), new TalonFX(), new CANcoder(), 0);
    leftFront = new SwerveModule(new TalonFX, new CANcoder(),new CANcoder(), 0);
    rightBack = new SwerveModule(new TalonFX), new CANcoder(),new CANcoder(), 0);
    leftBack = new SwerveModule(new TalonFX), new CANcoder(), new CANcoder(),0);
    gyroscope = new Pigeon2();  
  }
  public void coast(){
    rightFront.coast();
    leftFront.coast();
    rightBack.coast();
    leftBack.coast();
  }

  public void brake(){
    rightFront.brake();
    leftFront.brake();
    rightBack.brake();
    leftBack.brake();
  }

  public void setSwerveModulesStates(SwerveModuleState[] swerveModuleStates){
    rightFront.setSwerveState(swerveModuleStates[0]);
    leftFront.setSwerveState(swerveModuleStates[1]);
    rightBack.setSwerveState(swerveModuleStates[2]);
    leftBack.setSwerveState(swerveModuleStates[3]);
  }

  public void setSwerveBaseSpeed(ChassisSpeeds chassisSpeeds){
    setSwerveModulesStates(new SwerveDriveKinematics().toSwerveModuleStates(chassisSpeeds));
  }

  public void setSwerveDrive(double velocityY, double velocityX, double rX){
    setSwerveBaseSpeed(ChassisSpeeds.fromFieldRelativeSpeeds(velocityX, velocityY, rX, gyroscope.getRotation2d()));
  }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Right Front Speed", rightFront.getVelocity());
    SmartDashboard.putNumber("Left Front Speed", leftFront.getVelocity());
    SmartDashboard.putNumber("Right Back Speed", rightBack.getVelocity());
    SmartDashboard.putNumber("Left Back Speed", leftBack.getVelocity());
    
    SmartDashboard.putNumber("Right Front Angle", rightFront.getAngle());
    SmartDashboard.putNumber("Left Front Angle", leftFront.getAngle());
    SmartDashboard.putNumber("Right Back Angle", rightBack.getAngle());
    SmartDashboard.putNumber("Left Back Angle", leftBack.getAngle());
    // This method will be called once per scheduler run
  }
}
