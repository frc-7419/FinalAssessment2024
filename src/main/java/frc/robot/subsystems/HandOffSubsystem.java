// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class HandOffSubsystem extends SubsystemBase {
  private final CANSparkMax topMotor;
  private final CANSparkMax bottomMotor;
  public HandOffSubsystem() {
    topMotor = new CANSparkMax(5, MotorType.kBrushless);
    bottomMotor = new CANSparkMax(6, MotorType.kBrushless);
    bottomMotor.setInverted(true);
  }

  public void setPower(double power){
    topMotor.set(power);
    bottomMotor.set(power);
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
    SmartDashboard.putNumber("HandOff Top Motor Position", topMotor.getAbsoluteEncoder().getPosition());
    SmartDashboard.putNumber("HandOff Bottom Motor Position", bottomMotor.getAbsoluteEncoder().getPosition());

    SmartDashboard.putNumber("HandOff Top Motor Temperature", topMotor.getMotorTemperature());
    SmartDashboard.putNumber("HandOff Bottom Motor Temperature", bottomMotor.getMotorTemperature());
  }
}