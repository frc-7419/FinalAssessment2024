// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.shooter;

import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.revrobotics.AbsoluteEncoder;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.Constants;
public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */
  private DutyCycleEncoder shooterEncoder;
  private DutyCycleEncoder shooterBottomEncoder;
 
  private TalonFX topMotor;
  private TalonFX bottomMotor;
  public ShooterSubsystem() {
  this.topMotor = new TalonFX(Constants.canIDConstants.shooterTopMotorID);
  this.bottomMotor = new TalonFX(Constants.canIDConstants.shooterBottomMotorID);
  this.shooterEncoder = new DutyCycleEncoder(Constants.ShooterConstants.encoderPort);
  
  
    
  
  }
  public Double getRpm(){
    return topMotor.getVelocity().getValueAsDouble();
    
    
  }

  public void setVoltage(double power){
    topMotor.setInverted(true);
    topMotor.setVoltage(power);
    bottomMotor.setVoltage(power);
  }
  public void set(double speed){
    topMotor.setInverted(true);
    topMotor.set(speed);
    bottomMotor.set(speed);
  }
  public void coast(){
    topMotor.setNeutralMode(NeutralModeValue.Coast);
    bottomMotor.setNeutralMode(NeutralModeValue.Coast);
  }
  public void brake(){
    topMotor.setNeutralMode(NeutralModeValue.Brake);
    bottomMotor.setNeutralMode(NeutralModeValue.Brake);
  }
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
