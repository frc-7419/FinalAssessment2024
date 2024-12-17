// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.constants.constants;

public class HangerSubsystem extends SubsystemBase {
  private final TalonFX hanger;

  public HangerSubsystem() {
    hanger = new TalonFX(constants.hanger);
    hanger.setInverted(true);
  }

  public void setSpeed(double speed){
    hanger.set(speed);
  }
  public void brake(){
    hanger.setNeutralMode(NeutralModeValue.Brake);
  }

  public void coast(){
    hanger.setNeutralMode(NeutralModeValue.Coast);
  }
  
  @Override
  public void periodic() {
    //add smth to smartDashboard
  }
}