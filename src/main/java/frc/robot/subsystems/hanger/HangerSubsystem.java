// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.hanger;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants.HangerConstants;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class HangerSubsystem extends SubsystemBase {
  private final TalonFX hangerMotor;

  /** Creates a new ShooterSubsystem. */
  public HangerSubsystem() {
    hangerMotor = new TalonFX(HangerConstants.motorOneID);
  }

  public void coast() {
    hangerMotor.setNeutralMode(NeutralModeValue.Coast);
  }

  public void brake() {
    hangerMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  public void setSpeed(double speed) {
    hangerMotor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("HangerSpeed", hangerMotor.get());
  }
}
