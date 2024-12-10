// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import frc.robot.constants.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase {
  private final TalonFX topMotor;
  private final TalonFX bottomMotor;

  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {
    topMotor = new TalonFX(ShooterConstants.topShooterID);
    bottomMotor = new TalonFX(ShooterConstants.topShooterID);
  }

  public void coast() {
    topMotor.setNeutralMode(NeutralModeValue.Coast);
    bottomMotor.setNeutralMode(NeutralModeValue.Coast);
  }

  public void brake() {
    topMotor.setNeutralMode(NeutralModeValue.Brake);
    bottomMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  public void setSpeed(double speed) {
    topMotor.set(speed);
    bottomMotor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("TopShooterSpeed", topMotor.get());
    SmartDashboard.putNumber("BottomShooterSpeed", bottomMotor.get());
    SmartDashboard.putNumber("TopShooterTemperature", topMotor.getDeviceTemp().getValueAsDouble());
    SmartDashboard.putNumber("BottomShooterTemperature", bottomMotor.getDeviceTemp().getValueAsDouble());
  }
}
