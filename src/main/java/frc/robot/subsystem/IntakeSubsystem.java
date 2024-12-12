// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystem;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  private final CANSparkMax intakeLeftMotor;
  private final CANSparkMax intakeRightMotor;
  public IntakeSubsystem() {
    intakeLeftMotor = new CANSparkMax(2, MotorType.kBrushless);
    intakeRightMotor = new CANSparkMax(3, MotorType.kBrushless);
  }
  public void runIntake(double power){
    intakeLeftMotor.set(power);
    intakeRightMotor.set(power);
  }
  public void brake(){
    intakeLeftMotor.setIdleMode(IdleMode.kBrake);
    intakeRightMotor.setIdleMode(IdleMode.kBrake);
  }
  public void coast(){
    intakeLeftMotor.setIdleMode(IdleMode.kCoast);
    intakeRightMotor.setIdleMode(IdleMode.kCoast);
  }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Intake Left Motor Position", intakeLeftMotor.getAbsoluteEncoder().getPosition());
    SmartDashboard.putNumber("Intake Right Motor Position", intakeRightMotor.getAbsoluteEncoder().getPosition());

    SmartDashboard.putNumber("Intake Left Motor Temperature", intakeLeftMotor.getMotorTemperature());
    SmartDashboard.putNumber("Intake Right Motor Temperature", intakeRightMotor.getMotorTemperature());
  }
}