// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
 private final TalonFX topMotor;
 private final TalonFX bottomMotor;
  public ShooterSubsystem() {
    topMotor = new TalonFX(8);
    bottomMotor = new TalonFX(9);
    topMotor.setInverted(true);
    bottomMotor.setInverted(true);
    //make sure its invertede since motors spin backwards to shoot
  }
  public void setSpeed(double speed){
    topMotor.set(speed);
    bottomMotor.set(speed);
  }
  public void brake(){
    topMotor.setNeutralMode(NeutralModeValue.Brake);
    bottomMotor.setNeutralMode(NeutralModeValue.Brake);
  }
  public void coast(){
    topMotor.setNeutralMode(NeutralModeValue.Coast);
    bottomMotor.setNeutralMode(NeutralModeValue.Coast);
  }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Top shooter motor position", topMotor.getPosition().getValueAsDouble());
    SmartDashboard.putNumber("Bottom shooter motor position", bottomMotor.getPosition().getValueAsDouble());
  }
}
