// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.Pigeon2;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Swervedrive extends SubsystemBase {
  private final SwerveModule fLdriver;
  private final SwerveModule fRdriver;
  private final SwerveModule bLdriver;
  private final SwerveModule bRdriver;
  private final Pigeon2 gGyro;

  private final SwerveDriveKinematics kinematics;

  public Swervedrive() {
    fLdriver = new SwerveModule(new TalonFX(8), new TalonFX(1));
    fRdriver = new SwerveModule(new TalonFX(2), new TalonFX(3));
    bLdriver = new SwerveModule(new TalonFX(4), new TalonFX(5));
    bRdriver = new SwerveModule(new TalonFX(6), new TalonFX(7));
    gGyro = new Pigeon2(0);

    kinematics = new SwerveDriveKinematics(
        new Translation2d(),
        new Translation2d(),
        new Translation2d(),
        new Translation2d());
  }

  public void setSwerveWithJoystick(double vx, double vy, double rx) {
    setChassisSpeed(ChassisSpeeds.fromFieldRelativeSpeeds(vx, vy, rx, gGyro.getRotation2d()));
  }

  public void setChassisSpeed(ChassisSpeeds chassisSpeeds) {
    SwerveModuleState[] states = kinematics.toSwerveModuleStates(chassisSpeeds);
    setSwerveStates(states);
  }

  public void setSwerveStates(SwerveModuleState[] states) {
    fLdriver.setSwerveState(states[0]);
    fRdriver.setSwerveState(states[1]);
    bLdriver.setSwerveState(states[2]);
    bRdriver.setSwerveState(states[3]);
  }

  public void coast() {
    fLdriver.coast();
    fRdriver.coast();
    bLdriver.coast();
    bRdriver.coast();
  }

  public void brake() {
    fLdriver.brake();
    fRdriver.brake();
    bLdriver.brake();
    bRdriver.brake();
  }

  public void resetGyro(double offset) {
    gGyro.setYaw(offset);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("FrontLeftAngle", fLdriver.getWheelAngle());
    SmartDashboard.putNumber("FrontRightAngle", fRdriver.getWheelAngle());
    SmartDashboard.putNumber("BackLeftAngle", bLdriver.getWheelAngle());
    SmartDashboard.putNumber("BackRightAngle", bRdriver.getWheelAngle());
    SmartDashboard.putNumber("FL_Speed", fLdriver.getModuleSpeed());
    SmartDashboard.putNumber("FR_Speed", fRdriver.getModuleSpeed());
    SmartDashboard.putNumber("BL_Speed", bLdriver.getModuleSpeed());
    SmartDashboard.putNumber("BR_Speed", bRdriver.getModuleSpeed());
  }
}