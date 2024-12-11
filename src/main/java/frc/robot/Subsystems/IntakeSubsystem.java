// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  private final CANSparkMax motor1;
  private final CANSparkMax motor2;  
  public IntakeSubsystem() {
    motor1 = new CANSparkMax(3,MotorType.kBrushless);
    motor2 = new CANSparkMax(4,MotorType.kBrushless);

  }
  public void coast(){
    motor1.setIdleMode(IdleMode.kCoast);
    motor2.setIdleMode(IdleMode.kCoast);
  }
  public void brake(){
    motor1.setIdleMode(IdleMode.kBrake);
    motor2.setIdleMode(IdleMode.kBrake);  
  }

  public void run(double power){
    motor1.set(power);
    motor2.set(power);
  }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Shooter: Top Motor Voltage", motor1.getBusVoltage());
    SmartDashboard.putNumber("Shooter: Bottom Motor Voltage", motor2.getBusVoltage());
    SmartDashboard.putNumber("Shooter: Top Motor Temp", motor1.getMotorTemperature());
    SmartDashboard.putNumber("Shooter: Bottom Motor Temp", motor2.getMotorTemperature());
    // This method will be called once per scheduler run
  }
}
