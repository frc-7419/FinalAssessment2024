// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.hanger;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.Constants;


public class HangerSubsystem extends SubsystemBase {
  /** Creates a new HangerSubsystem. */
  

  private TalonFX hangerMotor;
  public HangerSubsystem() {
    this.hangerMotor = new TalonFX(Constants.canIDConstants.hangerMotorID);

  }
  public void coast(){
    hangerMotor.setNeutralMode(NeutralModeValue.Coast);
  }
  public void brake(){
    hangerMotor.setVoltage(0);
  }
  public void setVoltage(double power){
    hangerMotor.setInverted(true);
    hangerMotor.setVoltage(power);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
   
  }
}
