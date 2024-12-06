// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HandoffSubsystem extends SubsystemBase {
  private final TalonFX topHMotor;
  private final TalonFX bottomHMotor;

  public HandoffSubsystem() {
    topHMotor = new TalonFX(8);
    bottomHMotor = new TalonFX(9);
    bottomHMotor.setInverted(true);
  }

  public void setSpeed(double speed) {
    topHMotor.set(Math.abs(speed));
    bottomHMotor.set(Math.abs(speed));
  }

  public void brake() {
    topHMotor.setNeutralMode(NeutralModeValue.Brake);
    bottomHMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  public void coast() {
    topHMotor.setNeutralMode(NeutralModeValue.Coast);
    bottomHMotor.setNeutralMode(NeutralModeValue.Coast);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Top Handoff Pos", topHMotor.getPosition().getValueAsDouble() / 10);
    SmartDashboard.putNumber("Bottom Handoff Pos", bottomHMotor.getPosition().getValueAsDouble() / 10);
  }
}