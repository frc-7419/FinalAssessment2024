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
import frc.robot.constants.Constants.PIDConstants;

public class SwerveModule extends SubsystemBase {
  /** Creates a new SwerveModule. */
  private final TalonFX turnMotor;
  private final TalonFX driveMotor;
  private final CANcoder canCoder;
  private final PIDController pidController;
  private final String module;
  private final double offset;
  public SwerveModule(TalonFX turnMotor, TalonFX driveMotor, CANcoder canCoder, double offset, String module) {
    this.turnMotor = turnMotor;
    this.driveMotor = driveMotor;
    this.canCoder = canCoder;
    this.module = module;
    this.offset = offset;
    pidController = new PIDController(PIDConstants.kP, PIDConstants.kI, PIDConstants.kD);
    pidController.setTolerance(0.5);
    pidController.enableContinuousInput(0, 360);
  }

  public void brake() {
    turnMotor.setNeutralMode(NeutralModeValue.Brake);
    driveMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  public void coast() {
    turnMotor.setNeutralMode(NeutralModeValue.Coast);
    driveMotor.setNeutralMode(NeutralModeValue.Coast);
  }

  public double getWheelAngle() {
    return turnMotor.getPosition().getValueAsDouble();
  }

  public double swerveSpeed() {
    return driveMotor.getAcceleration().getValueAsDouble();
  }
  public void swerveState(SwerveModuleState swerveState) {
    driveMotor.set(swerveState.speedMetersPerSecond);
    turnMotor.set(pidController.calculate(getWheelAngle(), swerveState.angle.getDegrees() - offset));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
