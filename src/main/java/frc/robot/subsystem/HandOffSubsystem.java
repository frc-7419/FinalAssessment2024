// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystem;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HandOffSubsystem extends SubsystemBase {
  private final CANSparkMax handOffTopMotor;
  private final CANSparkMax handOffBottomMotor;
  /** Creates a new HandoffSubsystem. */
  public HandOffSubsystem() {
    this.handOffTopMotor = new CANSparkMax(5,MotorType.kBrushless);
    this.handOffBottomMotor = new CANSparkMax(6,MotorType.kBrushless);
  }

  public void runHandOff(double power){

    handOffTopMotor.set(power);
    handOffBottomMotor.set(power);
  }

  public void brake(){
    handOffTopMotor.setIdleMode(IdleMode.kBrake);
    handOffBottomMotor.setIdleMode(IdleMode.kBrake);
  }
  
  public void coast(){
    handOffTopMotor.setIdleMode(IdleMode.kCoast);
    handOffTopMotor.setIdleMode(IdleMode.kCoast);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("HandOff Top Motor Position", handOffTopMotor.getAbsoluteEncoder().getPosition());
    SmartDashboard.putNumber("HandOff Bottom Motor Position", handOffBottomMotor.getAbsoluteEncoder().getPosition());
    SmartDashboard.putNumber("HandOff Top Motor Temperature", handOffTopMotor.getMotorTemperature());
    SmartDashboard.putNumber("HandOff Bottom Motor Temperature",handOffTopMotor.getMotorTemperature());
  }
}
