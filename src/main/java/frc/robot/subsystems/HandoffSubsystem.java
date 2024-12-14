// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.ConstantsEverything;

public class HandoffSubsystem extends SubsystemBase {
  /** Creates a new HandoffSubsystem. */
  private final CANSparkMax topMotor;
  private final CANSparkMax bottomMotor;
  public HandoffSubsystem() {

    // Add values for the deviceID
    topMotor = new CANSparkMax(ConstantsEverything.handoffTopMotorCanID, MotorType.kBrushless);
    bottomMotor = new CANSparkMax(ConstantsEverything.handoffBottomMotorCanID, MotorType.kBrushless);
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
  //Makes the motor get better at fortnight
  public void setSpeed(double speed){
    topMotor.set(speed);
    bottomMotor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // Output motor values to SmartDashboard
    SmartDashboard.putNumber("Temperature of Top Handoff Motor in Celsius", topMotor.getMotorTemperature());
    SmartDashboard.putNumber("Temperature if Bottom Handoff Motor in Celsius", bottomMotor.getMotorTemperature());
  }
}
