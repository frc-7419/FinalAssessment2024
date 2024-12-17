// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.constants.constants;

public class IntakeSubsystem extends SubsystemBase{
  private final CANSparkMax intakeRight = new CANSparkMax(constants.intakeRight, MotorType.kBrushless);
  private final CANSparkMax intakeLeft = new CANSparkMax(constants.intakeLeft, MotorType.kBrushless);

  public void setSpeed(double speed) {
    intakeRight.set(speed);
    intakeLeft.set(speed);
  }

  public void coast() {
    intakeRight.setIdleMode(IdleMode.kCoast);
    intakeLeft.setIdleMode(IdleMode.kCoast);
  }

  public void brake() {
    intakeRight.setIdleMode(IdleMode.kBrake);
    intakeLeft.setIdleMode(IdleMode.kBrake);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("topTempIntake", intakeRight.getMotorTemperature());
    SmartDashboard.putNumber("topTempIntake", intakeLeft.getMotorTemperature());
  }
}