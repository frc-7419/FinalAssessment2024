// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  private final TalonFX topMotorX;
  private final TalonFX bottomMotorY;

  public ShooterSubsystem() {
    topMotorX = new TalonFX(8);
    bottomMotorY = new TalonFX(9);
    topMotorX.setInverted(true);
    bottomMotorY.setInverted(true);
  }

  public void setSpeed(double speed) {
    topMotorX.set(speed);
    bottomMotorY.set(speed);
  }

  public void brake() {
    topMotorX.setNeutralMode(NeutralModeValue.Brake);
    bottomMotorY.setNeutralMode(NeutralModeValue.Brake);
  }

  public void coast() {
    topMotorX.setNeutralMode(NeutralModeValue.Coast);
    bottomMotorY.setNeutralMode(NeutralModeValue.Coast);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Top Shooter Pos", topMotorX.getPosition().getValueAsDouble() - 0.5);
    SmartDashboard.putNumber("Bot Shooter Pos", bottomMotorY.getPosition().getValueAsDouble() + 0.5);
  }
}