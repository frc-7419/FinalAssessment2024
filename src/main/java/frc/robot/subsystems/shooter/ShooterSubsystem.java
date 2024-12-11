// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.shooter;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.Constants;
public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */
  private TalonFX topMotor;
  private TalonFX bottomMotor;
  public ShooterSubsystem() {
  this.topMotor = new TalonFX(Constants.canIDConstants.shooterTopMotorID);
  }
  public void setPower(double power){
    topMotor.setInverted(true);
    topMotor.setVoltage(power);
    bottomMotor.setVoltage(power);
  }
  public void set(double speed){
    topMotor.setInverted(true);
    topMotor.set(speed);
    bottomMotor.set(speed);
  }
  public void periodic() {
    // This method will be called once per scheduler run
  }
}