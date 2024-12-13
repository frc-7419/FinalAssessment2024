// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import javax.swing.text.StyleContext.SmallAttributeSet;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HangerSubsystem extends SubsystemBase {
  /** Creates a new HangerSubsystem. */
  private final TalonFX hangerMotor;
  public HangerSubsystem() {
    // Set values for Talon fx
    // Only one Hanger motor
    hangerMotor = new TalonFX(2);
    // Might need to make it inverted?
  }
  // Regular coasting and braking of the motor

  public void coast(){
    hangerMotor.setNeutralMode(NeutralModeValue.Coast);
  }
  public void brake(){
    hangerMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  public void setSpeed(double speed){
    hangerMotor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Hanger Motor Temperature", hangerMotor.getDeviceTemp().getValueAsDouble());
  }
}
