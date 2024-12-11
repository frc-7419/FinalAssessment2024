// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.wrist;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.Constants;

public class WristSubsystem extends SubsystemBase {
  /** Creates a new WristSubsystem. */
  private TalonFX wristMotor;
  
 
  public WristSubsystem() {
    this.wristMotor = new TalonFX(Constants.canIDConstants.wristMotorID);
    

  }
  public void coast(){
    wristMotor.setNeutralMode(NeutralModeValue.Coast);
  }
  public void brake(){
    wristMotor.setNeutralMode(NeutralModeValue.Brake);
  }
  
  public void runWrist(double power){
    wristMotor.setVoltage(power); // put *3 in the command
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
