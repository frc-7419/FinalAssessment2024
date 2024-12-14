// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {

  private final CANSparkMax leftIntakeMotor;
  private final CANSparkMax rightIntakeMotor;

  public IntakeSubsystem() {
    leftIntakeMotor = new CANSparkMax(3, MotorType.kBrushless);
    rightIntakeMotor = new CANSparkMax(4, MotorType.kBrushless);
  }

  public void setSpeed(double speed) {
    leftIntakeMotor.set(speed);
    rightIntakeMotor.set(speed);
  }

  public void brake() {
    leftIntakeMotor.setIdleMode(IdleMode.kBrake);
    rightIntakeMotor.setIdleMode(IdleMode.kBrake);
  }

  public void coast() {
    leftIntakeMotor.setIdleMode(IdleMode.kCoast);
    rightIntakeMotor.setIdleMode(IdleMode.kCoast);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber(
      "Left Intake Motor Temp",
      leftIntakeMotor.getMotorTemperature()
    );
    SmartDashboard.putNumber(
      "Right Intake Motor Temp",
      rightIntakeMotor.getMotorTemperature()
    );
  }
}
