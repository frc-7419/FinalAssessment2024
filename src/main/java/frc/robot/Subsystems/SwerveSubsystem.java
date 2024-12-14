// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;
import com.ctre.phoenix6.hardware.Pigeon2;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  private SwerveModule backRight;
  private SwerveModule backLeft;
  private SwerveModule frontRight;
  private SwerveModule frontLeft;
  private Pigeon2 gyro;
  public SwerveSubsystem() {
    this.backRight = new SwerveModule(new TalonFX(7), new TalonFX(11), 74.19);
    this.backLeft = new SwerveModule(new TalonFX(8), new TalonFX(12), 34.84);
    this.frontRight = new SwerveModule(new TalonFX(9),new  TalonFX(13), 3.5);
    this.frontLeft = new SwerveModule(new TalonFX(10), new TalonFX(14), 98.35);
    this.gyro = new Pigeon2(0);
  }

  public void coast(){
    backRight.coast();
    backLeft.coast();
    frontRight.coast();
    frontLeft.coast();
  }
  public void brake(){
    backRight.brake();
    backLeft.brake();
    frontRight.brake();
    frontLeft.brake();
  }
  public void setSwerveState(SwerveModuleState[] states){
      backRight.setSwerveModuleState(states[0]);
      backLeft.setSwerveModuleState(states[1]);
      frontRight.setSwerveModuleState(states[2]);
      frontLeft.setSwerveModuleState(states[3]);
  }

  public void setJoystick(double x, double y, double rx){
      setChassisSpeed(ChassisSpeeds.fromFieldRelativeSpeeds(x,y,rx,gyro.getRotation2d()));

  }
  
  public void setChassisSpeed(ChassisSpeeds chassisSpeeds) {
    setSwerveState(new SwerveDriveKinematics().toSwerveModuleStates(chassisSpeeds));
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
