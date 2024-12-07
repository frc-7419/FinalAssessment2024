// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HangerSubsystem extends SubsystemBase {
  private final TalonFX hangerMotor;
  public HangerSubsystem() {
    hangerMotor = new TalonFX(8);
  }
  public void setPower(double power){
    hangerMotor.set(power);
  }
  public void brake(){
    hangerMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  public void coast(){
    hangerMotor.setNeutralMode(NeutralModeValue.Coast);
  }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Hanger Motor Position", hangerMotor.getPosition().getValueAsDouble());
  }
}