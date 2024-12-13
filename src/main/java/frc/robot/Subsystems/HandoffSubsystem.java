// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HandoffSubsystem extends SubsystemBase {
  /** Bottom motor inverted
   * Functions: Coast, Brake, Run
   */
  private final CANSparkMax topMotor;
  private final CANSparkMax bottomMotor; 
  public HandoffSubsystem() {
    this.topMotor = new CANSparkMax(0,MotorType.kBrushless);
    this.bottomMotor = new CANSparkMax(1,MotorType.kBrushless);
    bottomMotor.setInverted(true);
  }
  public void coast(){
    topMotor.setIdleMode(IdleMode.kCoast);
    bottomMotor.setIdleMode(IdleMode.kCoast);
  }
  public void run(double power){
    topMotor.set(power);
    bottomMotor.set(power);
  }
  public void brake(){
    topMotor.setIdleMode(IdleMode.kBrake);
    bottomMotor.setIdleMode(IdleMode.kBrake);  
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Shooter: Top Motor Temp", topMotor.getMotorTemperature());
    SmartDashboard.putNumber("Shooter: Bottom Motor Temp", bottomMotor.getMotorTemperature());
    // This method will be called once per scheduler run
  }
}
