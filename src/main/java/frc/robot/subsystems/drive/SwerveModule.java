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
import frc.robot.subsystems.constants.constants;

public class SwerveModule extends SubsystemBase {
  private final TalonFX angler;
  private final TalonFX motion;
  private final CANcoder encoder;
  private final PIDController pid;

  public SwerveModule(TalonFX angler, TalonFX motion) {
    this.angler = angler;
    this.motion = motion;
    encoder = new CANcoder(constants.CANcoder);
    pid = new PIDController(1.2, 0.2, 0.9);
  }

  public void setSwerveState(SwerveModuleState state) {
    pid.setSetpoint(state.angle.getDegrees());
    motion.set(state.speedMetersPerSecond);

  }

  public void coast() {
    angler.setNeutralMode(NeutralModeValue.Coast);
    motion.setNeutralMode(NeutralModeValue.Coast);
  }

  public void brake() {
    angler.setNeutralMode(NeutralModeValue.Brake);
    motion.setNeutralMode(NeutralModeValue.Brake);
  }

  public double getAngle() {
    return encoder.getPosition().getValueAsDouble();
  }

  public double getModuleSpeed() {
    return encoder.getVelocity().getValueAsDouble();
  }

  @Override
  public void periodic() {
    //idk
  }
}