// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HangerSubsystem extends SubsystemBase {
  /** Creates a new HangerSubsystem. */
  private TalonFX hangerMotor;
  public HangerSubsystem() {
    hangerMotor = new TalonFX(17);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void coast() {
    hangerMotor.setNeutralMode(NeutralModeValue.Coast);
  }

  public void brake() {
    hangerMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  public void setSpeed(double speed) {
    hangerMotor.set(-speed);
  }
}
