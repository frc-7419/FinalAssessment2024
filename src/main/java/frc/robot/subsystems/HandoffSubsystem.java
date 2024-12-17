// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.constants.constants;

public class HandoffSubsystem extends SubsystemBase {
  private final TalonFX top;
  private final TalonFX bottom;

  public HandoffSubsystem() {
    top = new TalonFX(constants.topHandoff);
    bottom = new TalonFX(constants.topHandoff);
    bottom.setInverted(true);
  }

  public void setSpeed(double speed){
    top.set(speed);
    bottom.set(speed);
  }

  public void coast(){
    top.setNeutralMode(NeutralModeValue.Coast);
    bottom.setNeutralMode(NeutralModeValue.Coast);
  }

  public void brake(){
    top.setNeutralMode(NeutralModeValue.Brake);
    bottom.setNeutralMode(NeutralModeValue.Brake);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("topTempHandoff", top.getDeviceTemp().getValueAsDouble());
    SmartDashboard.putNumber("bottomTempHandoff", top.getDeviceTemp().getValueAsDouble());
  }
}