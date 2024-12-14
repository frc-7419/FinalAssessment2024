// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class HandoffSubsystem extends SubsystemBase {
  /** Creates a new HandoffSubsystem. */
  private final CANSparkMax topMotor;
  private final CANSparkMax bottomMotor;
  public HandoffSubsystem() {
    topMotor = new CANSparkMax(0, MotorType.kBrushless);
    bottomMotor = new CANSparkMax(0, MotorType.kBrushless);
    bottomMotor.setInverted(true);
  }
  public void coast(){
    topMotor.setIdleMode(IdleMode.kCoast);
    bottomMotor.setIdleMode(IdleMode.kCoast);
  }
  public void brake(){
    topMotor.setIdleMode(IdleMode.kBrake);
    bottomMotor.setIdleMode(IdleMode.kBrake);
  }
  public void setSpeed(double speed){
    topMotor.set(speed);
    bottomMotor.set(speed);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber(" Top handoff motor temperature", topMotor.getMotorTemperature());
    SmartDashboard.putNumber("Bottom hand off motor temperature ", bottomMotor.getMotorTemperature());
  }
}
