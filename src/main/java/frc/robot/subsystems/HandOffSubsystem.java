// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HandOffSubsystem extends SubsystemBase {
  private final TalonFX topMotor;
  private final TalonFX bottomMotor;
  public HandOffSubsystem() {
    topMotor = new TalonFX(5);
    bottomMotor = new TalonFX(6);
  }
  public void setPower(double power){
    topMotor.set(power);
    bottomMotor.set(power);
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
    SmartDashboard.putNumber("HandOff Top Motor Position", topMotor.getPosition().getValueAsDouble());
    SmartDashboard.putNumber("HandOff Bottom Motor Position", bottomMotor.getPosition().getValueAsDouble());
  }
}