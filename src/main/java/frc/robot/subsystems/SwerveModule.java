// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SwerveModule extends SubsystemBase {
  private final TalonFX turnMotor;
  private final TalonFX moveMotor;
  private final PIDController angController;
  private final CANcoder encoder;
  private double speed;
  public SwerveModule(TalonFX turnMotor, TalonFX moveMotor) {
    this.turnMotor = turnMotor;
    this.moveMotor = moveMotor;
    encoder = new CANcoder(11);
    angController = new PIDController(0.1, 0, 0);
    angController.setTolerance(1);
    speed = 0;
  }

  public void setSwerveState(SwerveModuleState swerveState) {
    speed = swerveState.speedMetersPerSecond;
    moveMotor.set(swerveState.speedMetersPerSecond);
    angController.setSetpoint(swerveState.angle.getDegrees());
    angController.calculate(turnMotor.getPosition().getValueAsDouble());
  }
  public void coast(){
    turnMotor.setNeutralMode(NeutralModeValue.Coast);
    moveMotor.setNeutralMode(NeutralModeValue.Coast);
  }
  public void brake(){
    turnMotor.setNeutralMode(NeutralModeValue.Brake);
    moveMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  public double getAngle(){
    return encoder.getPosition().getValueAsDouble();
  }
  public double getSpeed(){
    return speed;
  }


  @Override
  public void periodic() {
    SmartDashboard.putNumber("Turn Motor Temperature", turnMotor.getDeviceTemp().getValueAsDouble());
    SmartDashboard.putNumber("Move Motor Temperature", moveMotor.getDeviceTemp().getValueAsDouble());

  }
}