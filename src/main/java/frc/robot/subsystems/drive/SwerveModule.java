// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.drive;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveModule extends SubsystemBase {
  private final TalonFX moveMotor;
  private final TalonFX turnMotor;
  private final PIDController pidController;
  private final CANcoder encoder;
  private double moduleSpeed;

  public SwerveModule(TalonFX turnMotor, TalonFX moveMotor) {
    this.turnMotor = turnMotor;
    this.moveMotor = moveMotor;
    encoder = new CANcoder(8);
    pidController = new PIDController(0.1, 0, 0);
    pidController.setTolerance(1);
    moduleSpeed = 0;
  }

  public void setSwerveState(SwerveModuleState swerveState) {
    double positionOutput = pidController.calculate(turnMotor.getPosition().getValueAsDouble());
    moduleSpeed = swerveState.speedMetersPerSecond + positionOutput;
    moveMotor.set(swerveState.speedMetersPerSecond);
    pidController.setSetpoint(swerveState.angle.getDegrees());
  }

  public void coast() {
    turnMotor.setNeutralMode(NeutralModeValue.Coast);
    moveMotor.setNeutralMode(NeutralModeValue.Coast);
  }

  public void brake() {
    turnMotor.setNeutralMode(NeutralModeValue.Brake);
    moveMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  public double getAngle() {
    return encoder.getPosition().getValueAsDouble();
  }

  public double getSpeed() {
    return moduleSpeed;
  }

  @Override
  public void periodic() {}
}

