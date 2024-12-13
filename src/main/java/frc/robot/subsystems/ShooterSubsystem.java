// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */
  private final TalonFX topShooterMotor;
  private final TalonFX bottomShooterMotor;
  public ShooterSubsystem() {
    topShooterMotor = new TalonFX(3);
    bottomShooterMotor = new TalonFX(4);
    bottomShooterMotor.setInverted(true);
  }

  public void coast(){
    topShooterMotor.setNeutralMode(NeutralModeValue.Coast);
    bottomShooterMotor.setNeutralMode(NeutralModeValue.Coast);
  }

  public void brake(){
    topShooterMotor.setNeutralMode(NeutralModeValue.Brake);
    bottomShooterMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  public void setSpeed(double speed){
    topShooterMotor.set(speed);
    bottomShooterMotor.set(speed);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Top Shooter Temperature", topShooterMotor.getDeviceTemp().getValueAsDouble());
    SmartDashboard.putNumber("Bottom Shooter Temperate", bottomShooterMotor.getDeviceTemp().getValueAsDouble());
  }
}
