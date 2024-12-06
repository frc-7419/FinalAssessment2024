// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HangerSubsystem extends SubsystemBase {
  private final TalonFX m_Hang;

  public HangerSubsystem() {
    m_Hang = new TalonFX(12);
    m_Hang.setInverted(true);
  }

  public void setSpeed(double speed) {
    m_Hang.set(-speed);
  }

  public void brake() {
    m_Hang.setNeutralMode(NeutralModeValue.Brake);
  }

  public void coast() {
    m_Hang.setNeutralMode(NeutralModeValue.Coast);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Hanger motor pos", m_Hang.getPosition().getValueAsDouble());
  }
}