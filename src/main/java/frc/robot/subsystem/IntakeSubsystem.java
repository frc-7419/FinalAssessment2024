// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.subsystem;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  private final TalonFX intakeLeftMotor;
  private final TalonFX intakeRightMotor;
  public IntakeSubsystem() {
    this.intakeLeftMotor = new TalonFX(0);
    this.intakeRightMotor = new TalonFX(1);
  }
  public void runShooter(double power) {
    intakeLeftMotor.set(power);
    intakeRightMotor.set(power);
  }
  public void brake(){
    intakeLeftMotor.setNeutralMode(NeutralModeValue.Brake);
    intakeRightMotor.setNeutralMode(NeutralModeValue.Brake);
  }
  public void coast(){
    intakeLeftMotor.setNeutralMode(NeutralModeValue.Coast);
    intakeRightMotor.setNeutralMode(NeutralModeValue.Coast);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Shooter Left Motor Voltage", intakeLeftMotor.getMotorVoltage().getValue());
    SmartDashboard.putNumber("Shooter Right Motor Voltage", intakeRightMotor.getMotorVoltage().getValue());
  }
}