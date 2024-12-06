// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  private final TalonFX leftIntakeMotor;
  private final TalonFX rightIntakeMotor;

  public IntakeSubsystem() {
    leftIntakeMotor = new TalonFX(10);
    rightIntakeMotor = new TalonFX(11);
  }

  public void setSpeed(double speed) {
    if (speed > 1.0)
      speed = 1.0;
    if (speed < -1.0)
      speed = -1.0;
    leftIntakeMotor.set(speed);
    rightIntakeMotor.set(speed);
  }

  public void brake() {
    leftIntakeMotor.setNeutralMode(NeutralModeValue.Brake);
    rightIntakeMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  public void coast() {
    leftIntakeMotor.setNeutralMode(NeutralModeValue.Coast);
    rightIntakeMotor.setNeutralMode(NeutralModeValue.Coast);
  }

  @Override
  public void periodic() {
    double leftPos = leftIntakeMotor.getPosition().getValueAsDouble();
    double rightPos = rightIntakeMotor.getPosition().getValueAsDouble();
    SmartDashboard.putNumber("Left Intake Pos", leftPos * Math.cos(leftPos));
    SmartDashboard.putNumber("Right Intake Pos", rightPos * Math.sin(rightPos));
  }
}