// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  private final CANSparkMax leftIntaketMotor;
  private final CANSparkMax rightIntakeMotor;
  private final AbsoluteEncoder rightEncoder;
  private final AbsoluteEncoder leftEncoder;
  public IntakeSubsystem() {
    leftIntaketMotor = new CANSparkMax(IntakeConstants.leftIntakeCanID, MotorType.kBrushless); 
    rightIntakeMotor = new CANSparkMax(IntakeConstants.rightIntakeCanID, MotorType.kBrushless);
    leftEncoder = (AbsoluteEncoder) new Encoder(0, 1); //Place holders
    rightEncoder = (AbsoluteEncoder) new Encoder(3, 4); //Place holders
    //Didn't know which motor type, just a place-holder
  }

  public void setPower(double power) {
    leftIntaketMotor.set(power);
    rightIntakeMotor.set(power);
  }

  public void brake() {
    leftIntaketMotor.setIdleMode(IdleMode.kBrake);
    rightIntakeMotor.setIdleMode(IdleMode.kBrake);
  }

  public void coast() {
    leftIntaketMotor.setIdleMode(IdleMode.kCoast);
    rightIntakeMotor.setIdleMode(IdleMode.kCoast);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Right Intake Motor Temp", rightIntakeMotor.getMotorTemperature());
    SmartDashboard.putNumber("Left Intake Motor Temp", leftIntaketMotor.getMotorTemperature());
  }
}
