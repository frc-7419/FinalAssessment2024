// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  private final CANSparkMax leftMotor;
  private final CANSparkMax rightMotor;
  public IntakeSubsystem() {
    leftMotor = new CANSparkMax(1, MotorType.kBrushless);
    rightMotor = new CANSparkMax(2, MotorType.kBrushless);
  }
  public void setPower(double power){
    leftMotor.set(power);
    rightMotor.set(power);
  }
  public void brake(){
    leftMotor.setIdleMode(IdleMode.kBrake);
    rightMotor.setIdleMode(IdleMode.kBrake);
  }
  public void coast(){
    leftMotor.setIdleMode(IdleMode.kCoast);
    rightMotor.setIdleMode(IdleMode.kCoast);
  }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Intake Right Motor Position", rightMotor.getAbsoluteEncoder().getPosition());
    SmartDashboard.putNumber("Intake Left Motor Position", leftMotor.getAbsoluteEncoder().getPosition());

    SmartDashboard.putNumber("Intake Right Motor Temperature", rightMotor.getMotorTemperature());
    SmartDashboard.putNumber("Intake Left Motor Temperature", leftMotor.getMotorTemperature());
  }
}