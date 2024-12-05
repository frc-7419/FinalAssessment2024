// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  private final TalonFX leftMotor;
  private final TalonFX rightMotor;
  public IntakeSubsystem() {
    leftMotor = new TalonFX(10);
    rightMotor = new TalonFX(11);
  }
  public void setSpeed(double speed){
    leftMotor.set(speed);
    rightMotor.set(speed);
  }
  public void brake(){
    leftMotor.setNeutralMode(NeutralModeValue.Brake);
    rightMotor.setNeutralMode(NeutralModeValue.Brake);
  }
  public void coast(){
    leftMotor.setNeutralMode(NeutralModeValue.Coast);
    rightMotor.setNeutralMode(NeutralModeValue.Coast);
  }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Left Intake Motor Position", leftMotor.getPosition().getValueAsDouble());
    SmartDashboard.putNumber("Right Intake Motor Position", rightMotor.getPosition().getValueAsDouble());
  }
}
