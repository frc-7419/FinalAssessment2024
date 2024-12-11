// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants.ShooterConstants;

public class ShooterSubsytem extends SubsystemBase {
  /** Creates a new ShooterSubsytem. */
  private final TalonFX shooterTopMotor;
  private final TalonFX shooterBottomMotor;

  public ShooterSubsytem() {
    this.shooterTopMotor = new TalonFX(ShooterConstants.shooterTopCanID);
    this.shooterBottomMotor = new TalonFX(ShooterConstants.shooterBottomCanID);
    shooterBottomMotor.setInverted(true);
    shooterTopMotor.setInverted(true);
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
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Top Shooter Temperature", shooterTopMotor.getDeviceTemp().getValueAsDouble());
    SmartDashboard.putNumber("Bottom Shooter Temperature", shooterBottomMotor.getDeviceTemp().getValueAsDouble());
  }
}
