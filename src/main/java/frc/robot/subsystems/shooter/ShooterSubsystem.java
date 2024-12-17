// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.shooter;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.constants.constants;

public class ShooterSubsystem extends SubsystemBase {
  private final TalonFX top;
  private final TalonFX bottom;

  public ShooterSubsystem() {
    top = new TalonFX(constants.topShooter);
    bottom = new TalonFX(constants.bottomShooter);
    bottom.setInverted(true); //to faciclitate the upwards motion
  }

  public void coast(){
    top.setNeutralMode(NeutralModeValue.Coast);
    bottom.setNeutralMode(NeutralModeValue.Coast);
  }

  public void brake(){
    top.setNeutralMode(NeutralModeValue.Brake);
    bottom.setNeutralMode(NeutralModeValue.Brake);
  }

  public void setSpeed(double speed){
    top.set(speed);
    bottom.set(speed);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("topTempShooter", top.getDeviceTemp().getValueAsDouble());
    SmartDashboard.putNumber("bottomTempShooter", bottom.getDeviceTemp().getValueAsDouble());
  }
}
