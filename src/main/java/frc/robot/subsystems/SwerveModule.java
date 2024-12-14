// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// SwerveModule class that controls each individual motor
public class SwerveModule extends SubsystemBase {
  /** Creates a new SwerveModule. */
 
  private final TalonFX turnMotor; 
  private final TalonFX moveMotor; 
  private final CANcoder caNcoder; 
  private final PIDController pidController; 
  private double totalSpeed = 0; 
  public SwerveModule(TalonFX moveMotor, TalonFX turnMotor, CANcoder caNcoder, double offsetAngle offsetAngle) {
    this.turnMotor = turnMotor;
    this.moveMotor = moveMotor;
    this.caNcoder = caNcoder;
    this.pidController =  new PIDController(0, 0, 0);
    this.pidController.setTolerance(5);
    this.offsetAngle = offsetAngle;
  
  }

  public void coast(){
    moveMotor.setNeutralMode(NeutralModeValue.Coast);
    turnMotor.setNeutralMode(NeutralModeValue.Coast);
  }

  public void brake(){
    moveMotor.setNeutralMode(NeutralModeValue.Brake);
    turnMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  public double getVelocity(){
    return totalSpeed;
  }
  public double getAngle(){
    double angle = caNcoder.getPosition().getValueAsDouble();  
    return angle;
  }
  public void setSwerveState(SwerveModuleState swerveModuleState){
    totalSpeed = swerveModuleState.speedMetersPerSecond;
    moveMotor.set(totalSpeed);
    double newAngle = swerveModuleState.angle.getDegrees() - offsetAngle;
    pidController.setSetpoint(newAngle);
    pidController.calculate(turnMotor.getPosition().getValueAsDouble(), newAngle);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Move Motor Position", moveMotor.getPosition().getValueAsDouble());
    SmartDashboard.putNumber("Turn Motor Angle", caNcoder.getPosition().getValueAsDouble());
    SmartDashboard.putNumber("Move Motor Temperature", moveMotor.getDeviceTemp().getValueAsDouble());
    SmartDashboard.putNumber("Turn Motor Temperature", turnMotor.getDeviceTemp().getValueAsDouble());
  }
}