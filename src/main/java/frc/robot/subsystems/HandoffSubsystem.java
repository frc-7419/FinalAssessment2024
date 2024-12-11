// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants.HandoffConstants;

public class HandoffSubsystem extends SubsystemBase {
  /** Creates a new HandoffSubsystem. */
  private final CANSparkMax topHandoffMotor;
  private final CANSparkMax bottomHandoffMotor;
  private final AbsoluteEncoder topEncoder;
  private final AbsoluteEncoder bottomEncoder;

  public HandoffSubsystem() {
    bottomHandoffMotor = new CANSparkMax(HandoffConstants.bottomHandoffCanID, MotorType.kBrushless); 
    topHandoffMotor = new CANSparkMax(HandoffConstants.topHandoffCanID, MotorType.kBrushless);
    topEncoder = (AbsoluteEncoder) new Encoder(6, 6); //Place holders
    bottomEncoder = (AbsoluteEncoder) new Encoder(7, 7); //Place holders
    bottomHandoffMotor.setInverted(true);
  }

  public void setPower(double power) {
    bottomHandoffMotor.set(power);
    topHandoffMotor.set(power);
  }

  public void brake() {
    bottomHandoffMotor.setIdleMode(IdleMode.kBrake);
    topHandoffMotor.setIdleMode(IdleMode.kBrake);
  }

  public void coast() {
    bottomHandoffMotor.setIdleMode(IdleMode.kCoast);
    topHandoffMotor.setIdleMode(IdleMode.kCoast);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Top Handoff Motor Temp", bottomHandoffMotor.getMotorTemperature());
    SmartDashboard.putNumber("Bottom Handoff Motor Temp", topHandoffMotor.getMotorTemperature());
  }
}
