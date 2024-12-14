// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HangerSubsystem extends SubsystemBase {
  /** Creates a new HangerSubsystem. */
  private final TalonFX hangMotor;
  public HangerSubsystem() {
  hangMotor = new TalonFX(0);
  }
  public void coast(){
    hangMotor.setNeutralMode(NeutralModeValue.Coast);
    
  }
  public void brake(){
    hangMotor.setNeutralMode(NeutralModeValue.Brake);
  }
  public void setSpeed(double speed){
    hangMotor.set(speed);
  }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Temperature hang Motor", hangMotor.getDeviceTemp().getValueAsDouble());
    // This method will be called once per scheduler run
  }
}
