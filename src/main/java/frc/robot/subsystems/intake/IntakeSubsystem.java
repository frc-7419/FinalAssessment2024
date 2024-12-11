// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new Intake. */
  private CANSparkMax topIntakeMotor;
  private CANSparkMax bottomIntakeMotor;
  private CANSparkMax topHandoffMotor;
  private CANSparkMax bottomHandoffMotor;
  public IntakeSubsystem() {
    
    this.topIntakeMotor = new CANSparkMax(Constants.canIDConstants.intakeTopMotorID, MotorType.kBrushless);
    this.bottomIntakeMotor = new CANSparkMax(Constants.canIDConstants.intakeBottomMotorID, MotorType.kBrushless);
    this.topHandoffMotor = new CANSparkMax(Constants.canIDConstants.handoffTopMotorID, MotorType.kBrushless);
    this.bottomHandoffMotor = new CANSparkMax(Constants.canIDConstants.handoffBottomMotorID, MotorType.kBrushless);
    
    invertMotors();
  }
  private void invertMotors() {
    topIntakeMotor.setInverted(true);
    topHandoffMotor.setInverted(true);
  }
  public void coast(){
    topIntakeMotor.setIdleMode(IdleMode.kCoast);
    topIntakeMotor.setIdleMode(IdleMode.kCoast);
    topHandoffMotor.setIdleMode(IdleMode.kCoast);
    bottomHandoffMotor.setIdleMode(IdleMode.kCoast);

  }
  public void brake(){
    topIntakeMotor.setIdleMode(IdleMode.kBrake);
    bottomIntakeMotor.setIdleMode(IdleMode.kBrake);
    topHandoffMotor.setIdleMode(IdleMode.kBrake);
    bottomHandoffMotor.setIdleMode(IdleMode.kBrake);

  }
  public void set(double speed){
    topIntakeMotor.set(speed);
    bottomIntakeMotor.set(speed);
    topHandoffMotor.set(speed);
    bottomHandoffMotor.set(speed);
  }
  public void setPower(double power){
    topIntakeMotor.setVoltage(power);
    bottomIntakeMotor.setVoltage(power);
    topHandoffMotor.setVoltage(power);
    bottomHandoffMotor.setVoltage(power);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
