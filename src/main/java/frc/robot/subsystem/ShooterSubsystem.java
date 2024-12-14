// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.subsystem;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  private final TalonFX shooterLeftMotor;
  private final TalonFX shooterRightMotor;
  public ShooterSubsystem() {
    this.shooterLeftMotor = new TalonFX(0);
    this.shooterRightMotor = new TalonFX(1);
  }
  public void runShooter(double power) {
    shooterLeftMotor.set(power);
    shooterRightMotor.set(power);
  }
  public void brake(){
    shooterLeftMotor.setNeutralMode(NeutralModeValue.Brake);
    shooterRightMotor.setNeutralMode(NeutralModeValue.Brake);
  }
  public void coast(){
    shooterLeftMotor.setNeutralMode(NeutralModeValue.Coast);
    shooterRightMotor.setNeutralMode(NeutralModeValue.Coast);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Shooter Left Motor Voltage", shooterLeftMotor.getMotorVoltage().getValue());
    SmartDashboard.putNumber("Shooter Right Motor Voltage", shooterRightMotor.getMotorVoltage().getValue());
    SmartDashboard.putNumber("Shooter Left Motor Temp", shooterLeftMotor.getMotorVoltage().getValue());
    SmartDashboard.putNumber("Shooter Right Motor Temp", shooterRightMotor.getDeviceTemp().getValue());
  }
}