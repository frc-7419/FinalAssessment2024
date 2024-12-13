// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HangerSubsystem extends SubsystemBase {
  /** Creates a new HangerSubsystem. */
  private final TalonFX hangerMotor;
  public HangerSubsystem() {
    this.hangerMotor = new TalonFX(2);


  }
  public void coast(){
    hangerMotor.setNeutralMode(NeutralModeValue.Coast);
  }
  public void run(double power){
    hangerMotor.set(power);
  }
  public void brake(){
    hangerMotor.setNeutralMode(NeutralModeValue.Brake);   
  }
    

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Hanger Temp", hangerMotor.getDeviceTemp().getValueAsDouble());
    // This method will be called once per scheduler run
  }
}
