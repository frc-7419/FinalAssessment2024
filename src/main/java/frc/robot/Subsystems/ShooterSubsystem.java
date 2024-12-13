// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */
  private TalonFX top, bottom;
  public ShooterSubsystem() {
    top = new TalonFX(18);
    bottom = new TalonFX(19);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Shooter Top motor temp", top.getDeviceTemp().getValueAsDouble());
    SmartDashboard.putNumber("Shooter Bottom motor temp", bottom.getDeviceTemp().getValueAsDouble());
  }
  public void coast() {
    top.setNeutralMode(NeutralModeValue.Coast);
    bottom.setNeutralMode(NeutralModeValue.Coast);
  }

  public void brake() {
    top.setNeutralMode(NeutralModeValue.Brake);
    bottom.setNeutralMode(NeutralModeValue.Brake);
  }
  //Positive value shoots out
  public void setSpeed(double speed) {
    top.set(-speed);
    bottom.set(-speed);
  }
}
