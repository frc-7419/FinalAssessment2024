// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.Pigeon2;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveBase extends SubsystemBase {
  private final SwerveModule frontLeft;
  private final SwerveModule frontRight;
  private final SwerveModule backLeft;
  private final SwerveModule backRight;
  private final Pigeon2 gyro;
  public SwerveBase() {
    frontLeft = new SwerveModule(new TalonFX(8), new TalonFX(1));
    frontRight = new SwerveModule(new TalonFX(2), new TalonFX(3));
    backLeft = new SwerveModule(new TalonFX(4), new TalonFX(5));
    backRight = new SwerveModule(new TalonFX(6), new TalonFX(7));
    gyro = new Pigeon2(0);  
  }
  public void setSwerveWithJoystick(double vx, double vy, double rx){
    setChassisSpeed(ChassisSpeeds.fromFieldRelativeSpeeds(vx,vy,rx,gyro.getRotation2d()));
  }
  public void setChassisSpeed(ChassisSpeeds chassisSpeeds) {
    setSwerveStates(new SwerveDriveKinematics().toSwerveModuleStates(chassisSpeeds));
  }
  public void setSwerveStates(SwerveModuleState[] states){
    frontLeft.setSwerveState(states[0]);
    frontRight.setSwerveState(states[1]);
    backLeft.setSwerveState(states[2]); 
    backRight.setSwerveState(states[3]);
  }

  public void coast(){
    frontLeft.coast();
    frontRight.coast();
    backLeft.coast();
    backRight.coast();    
  }

  public void brake(){
    frontLeft.brake();
    frontRight.brake();
    backLeft.brake();
    backRight.brake();    
  } 

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Front Left module wheel angle", frontLeft.getWheelAngle());
    SmartDashboard.putNumber("Front Right module wheel angle", frontRight.getWheelAngle());
    SmartDashboard.putNumber("Back Left module wheel angle", backLeft.getWheelAngle());
    SmartDashboard.putNumber("Back Right module wheel angle", backRight.getWheelAngle());
    SmartDashboard.putNumber("Front Left module speed", frontLeft.getModuleSpeed());
    SmartDashboard.putNumber("Front Right module speed", frontRight.getModuleSpeed());
    SmartDashboard.putNumber("Back Left module speed", backLeft.getModuleSpeed());    
    SmartDashboard.putNumber("Back Right module speed", backRight.getModuleSpeed());
  }
}
