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
  // Kraken motor that are used --> Talon FX
  private final TalonFX moveMotor; // Motor that is used to go forward or backward
  private final TalonFX turnMotor; // Motor that turns the move motor
  private final CANcoder caNcoder; // Encoder to get the position
  private final PIDController pidController; // PID Control
  private final double offsetAngle;
  private double totalSpeed = 0; // Set to 0 at the beggining

  public SwerveModule(TalonFX moveMotor, TalonFX turnMotor, CANcoder caNcoder, double offsetAngle) {
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
    double angle = caNcoder.getPosition().getValueAsDouble();  // Easier to read and understand
    return angle;
  }
  public void setSwerveState(SwerveModuleState swerveModuleState){
    totalSpeed = swerveModuleState.speedMetersPerSecond; // Put the speed in a global variable --> Used in another function
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
