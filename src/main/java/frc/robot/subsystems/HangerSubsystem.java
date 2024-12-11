// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants.HangerConstants;

public class HangerSubsystem extends SubsystemBase {
  /** Creates a new HangarSubsystem. */
  private final TalonFX hangerMotor;
  public HangerSubsystem() {
    hangerMotor = new TalonFX(HangerConstants.hangerCanID);
    hangerMotor.setInverted(true);
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
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Hanger Motor Temp", hangerMotor.getDeviceTemp().getValueAsDouble());
  }
}
