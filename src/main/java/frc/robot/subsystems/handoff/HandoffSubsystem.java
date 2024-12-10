// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.handoff;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants.HandoffConstants;

public class HandoffSubsystem extends SubsystemBase {
  private final CANSparkMax topMotor;
  private final CANSparkMax bottomMotor;

  /** Creates a new ShooterSubsystem. */
  public HandoffSubsystem() {
    topMotor = new CANSparkMax(HandoffConstants.motorOneID, MotorType.kBrushless);
    bottomMotor = new CANSparkMax(HandoffConstants.motorTwoID, MotorType.kBrushless);
    bottomMotor.setInverted(true);
  }

  public void coast() {
    topMotor.setIdleMode(IdleMode.kCoast);
    bottomMotor.setIdleMode(IdleMode.kCoast);
  }

  public void brake() {
    topMotor.setIdleMode(IdleMode.kBrake);
    bottomMotor.setIdleMode(IdleMode.kBrake);
  }

  public void setSpeed(double speed) {
    topMotor.set(speed);
    bottomMotor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("TopHandoffSpeed", topMotor.get());
    SmartDashboard.putNumber("BottomHandoffSpeed", bottomMotor.get());
    SmartDashboard.putNumber("TopHandoffTemperature", topMotor.getMotorTemperature());
    SmartDashboard.putNumber("BottomHandoffTemperature", bottomMotor.getMotorTemperature());
  }
}
