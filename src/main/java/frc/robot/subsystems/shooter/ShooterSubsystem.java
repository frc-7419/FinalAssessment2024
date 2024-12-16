// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.shooter;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase {
  private final TalonFX topMotor;
  private final TalonFX bottomMotor;

  public ShooterSubsystem() {
    topMotor = new TalonFX(ShooterConstants.topShooterID);
    bottomMotor = new TalonFX(ShooterConstants.topShooterID);
  }

  public void setSpeed(double speed) {
    topMotor.set(speed);
    bottomMotor.set(speed);
  }

  public void coast() {
    topMotor.setNeutralMode(NeutralModeValue.Coast);
    bottomMotor.setNeutralMode(NeutralModeValue.Coast);
  }

  public void brake() {
    topMotor.setNeutralMode(NeutralModeValue.Brake);
    bottomMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("top shooter motor speed", topMotor.get());
    SmartDashboard.putNumber("bottom shooter motor speed", bottomMotor.get());
    SmartDashboard.putNumber("top shooter motor temperature", topMotor.getDeviceTemp().getValueAsDouble());
    SmartDashboard.putNumber("bottom shooter motor temperature", bottomMotor.getDeviceTemp().getValueAsDouble());
  }
}