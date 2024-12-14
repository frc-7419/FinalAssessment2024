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

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  private final CANSparkMax motorOne;
  private final CANSparkMax motorTwo;
  public IntakeSubsystem() {
    motorOne = new CANSparkMax(ConstantsEverything.intakeMotorOneCanID, MotorType.kBrushless);
    motorTwo = new CANSparkMax(ConstantsEverything.intakeMotorTwoCanID, MotorType.kBrushless);
  }

  public void coast(){
    motorOne.setIdleMode(IdleMode.kCoast);
    motorTwo.setIdleMode(IdleMode.kCoast);
  }
  public void brake(){
    motorOne.setIdleMode(IdleMode.kBrake);
    motorTwo.setIdleMode(IdleMode.kBrake);
  }
  public void setSpeed(double speed){
    motorOne.set(speed);
    motorTwo.set(speed);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Motor One Intake Temperature", motorOne.getMotorTemperature());
    SmartDashboard.putNumber("Motor Two Intake Temperature", motorTwo.getMotorTemperature());
  }
}
