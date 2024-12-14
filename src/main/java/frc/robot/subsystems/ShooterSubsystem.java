// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

  private final TalonFX topShooterMotor;
  private final TalonFX bottomShooterMotor;

  public ShooterSubsystem() {
    topShooterMotor = new TalonFX(5);
    bottomShooterMotor = new TalonFX(6);
    topShooterMotor.setInverted(true);
    bottomShooterMotor.setInverted(true);
  }

  public void setSpeed(double speed) {
    topShooterMotor.set(speed);
    bottomShooterMotor.set(speed);
  }

  public void brake() {
    topShooterMotor.setNeutralMode(NeutralModeValue.Brake);
    bottomShooterMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  public void coast() {
    topShooterMotor.setNeutralMode(NeutralModeValue.Coast);
    bottomShooterMotor.setNeutralMode(NeutralModeValue.Coast);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber(
      "Top Shooter Motor Temperature",
      topShooterMotor.getDeviceTemp().getValueAsDouble()
    );
    SmartDashboard.putNumber(
      "Bottom Shooter Motor Temperature",
      bottomShooterMotor.getDeviceTemp().getValueAsDouble()
    );
  }
}
