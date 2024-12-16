// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.hanger;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import frc.robot.Constants.HangerConstants;

public class HangerSubsystem extends SubsystemBase {
  private final TalonFX hangerMotor;

  public HangerSubsystem() {
    hangerMotor = new TalonFX(HangerConstants.motorOneID);
  }

  public void setSpeed(double speed) {
    hangerMotor.set(speed);
  }

  public void coast() {
    hangerMotor.setNeutralMode(NeutralModeValue.Coast);
  }

  public void brake() {
    hangerMotor.setNeutralMode(NeutralModeValue.Brake);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("hanger motor speed", hangerMotor.get());
    SmartDashboard.putNumber("hanger motor temperature", hangerMotor.getDeviceTemp().getValueAsDouble());
  }
}