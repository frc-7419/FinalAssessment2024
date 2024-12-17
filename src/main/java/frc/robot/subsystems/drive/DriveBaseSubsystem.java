// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.drive;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveBaseSubsystem extends SubsystemBase {
  private final SwerveModule frontLeft;
  private final SwerveModule backLeft;
  private final SwerveModule frontRight;
  private final SwerveModule backRight;

  private final SwerveDriveKinematics kin;

  public DriveBaseSubsystem() {
    frontLeft = new SwerveModule(new TalonFX(0), new TalonFX(0));
    frontRight = new SwerveModule(new TalonFX(0), new TalonFX(0));
    backLeft = new SwerveModule(new TalonFX(0), new TalonFX(0));
    backRight = new SwerveModule(new TalonFX(0), new TalonFX(0));

    kin = new SwerveDriveKinematics(
        new Translation2d(),
        new Translation2d(),
        new Translation2d(),
        new Translation2d());
  }

  public void setChassisSpeed(ChassisSpeeds chassisSpeeds) {
    SwerveModuleState[] states = kin.toSwerveModuleStates(chassisSpeeds);
    setSwerveStates(states);
  }

  public void setSwerveStates(SwerveModuleState[] states) {
    frontLeft.setSwerveState(states[0]);
    frontRight.setSwerveState(states[1]);
    backLeft.setSwerveState(states[2]);
    backRight.setSwerveState(states[3]);
  }

  public void coast() {
    frontLeft.coast();
    frontRight.coast();
    backLeft.coast();
    backRight.coast();
  }

  public void brake() {
    frontLeft.brake();
    frontRight.brake();
    backLeft.brake();
    backRight.brake();
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("FL_Angle", frontLeft.getAngle());
    SmartDashboard.putNumber("FR_Angle", frontRight.getAngle());
    SmartDashboard.putNumber("BL_Angle", backLeft.getAngle());
    SmartDashboard.putNumber("BR_Angle", backRight.getAngle());
    SmartDashboard.putNumber("FL_Speed", frontLeft.getModuleSpeed());
    SmartDashboard.putNumber("FR_Speed", frontRight.getModuleSpeed());
    SmartDashboard.putNumber("BL_Speed", backLeft.getModuleSpeed());
    SmartDashboard.putNumber("BR_Speed", backRight.getModuleSpeed());
  }
}