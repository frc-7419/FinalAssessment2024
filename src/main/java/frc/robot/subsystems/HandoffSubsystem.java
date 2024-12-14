// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HandoffSubsystem extends SubsystemBase {

  private final CANSparkMax topHandoffMotor;
  private final CANSparkMax bottomHandoffMotor;

  public HandoffSubsystem() {
    topHandoffMotor = new CANSparkMax(1, MotorType.kBrushless);
    bottomHandoffMotor = new CANSparkMax(2, MotorType.kBrushless);
    bottomHandoffMotor.setInverted(true);
  }

  public void setSpeed(double speed) {
    topHandoffMotor.set(speed);
    bottomHandoffMotor.set(speed);
  }

  public void brake() {
    topHandoffMotor.setIdleMode(IdleMode.kBrake);
    bottomHandoffMotor.setIdleMode(IdleMode.kBrake);
  }

  public void coast() {
    topHandoffMotor.setIdleMode(IdleMode.kCoast);
    bottomHandoffMotor.setIdleMode(IdleMode.kCoast);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber(
      "Top Handoff Motor Temp",
      topHandoffMotor.getMotorTemperature()
    );
    SmartDashboard.putNumber(
      "Bottom Handoff Motor Temp",
      bottomHandoffMotor.getMotorTemperature()
    );
  }
}
