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
  private final SwerveModule backLeft;
  private final SwerveModule backRight;
  private final SwerveModule frontLeft;
  private final SwerveModule frontRight;
  private final Pigeon2 gyroscope;
  
  public SwerveBase() {
    backLeft = new SwerveModule(new TalonFX(1), new TalonFX(2));
    backRight = new SwerveModule(new TalonFX(3), new TalonFX(4));
    frontLeft = new SwerveModule(new TalonFX(5), new TalonFX(7));
    frontRight = new SwerveModule(new TalonFX(7), new TalonFX(8));
    gyroscope = new Pigeon2(0);  
  }
  public void setSwerve(double vx, double vy, double rx){
    setChassisSpeed(ChassisSpeeds.fromFieldRelativeSpeeds(vx,vy,rx,gyroscope.getRotation2d()));
  }
  public void setChassisSpeed(ChassisSpeeds chassisSpeeds) {
    setSwerveStates(new SwerveDriveKinematics().toSwerveModuleStates(chassisSpeeds));
  }
  public void setSwerveStates(SwerveModuleState[] states){
    backLeft.setSwerveState(states[0]); 
    backRight.setSwerveState(states[1]);
    frontLeft.setSwerveState(states[2]);
    frontRight.setSwerveState(states[3]);
  }

  public void coast(){
    backLeft.coast();
    backRight.coast();   
    frontLeft.coast();
    frontRight.coast(); 
  }

  public void brake(){
    backLeft.brake();
    backRight.brake(); 
    frontLeft.brake();
    frontRight.brake();   
  } 


  @Override
  public void periodic() {
    
    SmartDashboard.putNumber("Back Left module angle", backLeft.getAngle());
    SmartDashboard.putNumber("Back Right module angle", backRight.getAngle());
    SmartDashboard.putNumber("Front Left module angle", frontLeft.getAngle());
    SmartDashboard.putNumber("Front Right module angle", frontRight.getAngle());
   
    SmartDashboard.putNumber("Back Left module speed", backLeft.getSpeed());    
    SmartDashboard.putNumber("Back Right module speed", backRight.getSpeed());
    SmartDashboard.putNumber("Front Left module speed", frontLeft.getSpeed());
    SmartDashboard.putNumber("Front Right module speed", frontRight.getSpeed());
  }
}