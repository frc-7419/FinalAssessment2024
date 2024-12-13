// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HandoffSubsystem extends SubsystemBase {
  private final CANSparkMax topMotor;
  private final CANSparkMax bottomMotor;
  public HandoffSubsystem() {
    topMotor = new CANSparkMax(8, MotorType.kBrushless);
    bottomMotor = new CANSparkMax(9, MotorType.kBrushless);
    bottomMotor.setInverted(true);
    //make sure bottom motor is inverted
  }
  public void setSpeed(double speed){
    topMotor.set(speed);
    bottomMotor.set(speed);
  }
  public void brake(){
    topMotor.setIdleMode(IdleMode.kBrake);
    bottomMotor.setIdleMode(IdleMode.kBrake);
  }
  public void coast(){
    topMotor.setIdleMode(IdleMode.kCoast);
    bottomMotor.setIdleMode(IdleMode.kCoast);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Top Handoff Motor Temp", topMotor.getMotorTemperature());
    SmartDashboard.putNumber("Bottom Handoff Motor Temp", bottomMotor.getMotorTemperature());
    SmartDashboard.putNumber("Top Handoff Motor Voltage", topMotor.getBusVoltage());
    SmartDashboard.putNumber("Bottom Handoff Motor Voltage", bottomMotor.getBusVoltage());
  }
}
