// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsytem extends SubsystemBase {
  /** Creates a new ShooterSubsytem. */
  private final TalonFX shooterTopMotor;
  private final TalonFX shooterBottomMotor;

  public ShooterSubsytem() {
    shooterTopMotor = new TalonFX(0);
    shooterBottomMotor = new TalonFX(0);
;   shooterBottomMotor.setInverted(true);
    shooterBottomMotor.setInverted(true);
  }

  public void setPower(double power) {
    shooterBottomMotor.set(power);
    shooterTopMotor.set(power);
  }

  public void brake() {
    shooterBottomMotor.setNeutralMode(NeutralModeValue.Brake);
    shooterTopMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  public void coast() {
    shooterBottomMotor.setNeutralMode(NeutralModeValue.Coast);
    shooterTopMotor.setNeutralMode(NeutralModeValue.Coast);
  }


  @Override
  public void periodic() {
    
  }
}