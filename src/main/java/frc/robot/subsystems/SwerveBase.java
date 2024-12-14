// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.Pigeon2;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveBase extends SubsystemBase {
    private final SwerveModule frontLeft;
    private final SwerveModule frontRight;
    private final SwerveModule backLeft;
    private final SwerveModule backRight;
    private final Pigeon2 gyro;

    public SwerveBase() {
        frontLeft = new SwerveModule(new TalonFX(8), new TalonFX(9), new CANcoder(10), 98.35);
        frontRight = new SwerveModule(new TalonFX(11), new TalonFX(12), new CANcoder(13), 3.5);
        backLeft = new SwerveModule(new TalonFX(14), new TalonFX(15), new CANcoder(16), 34.84);
        backRight = new SwerveModule(new TalonFX(17), new TalonFX(18), new CANcoder(19), 74.19);
        gyro = new Pigeon2(20);
    }

    public void setSwerve(double vx, double vy, double rx){
        setChassisSpeed(ChassisSpeeds.fromFieldRelativeSpeeds(vx, vy, rx, gyro.getRotation2d()));
    }
    public void setChassisSpeed(ChassisSpeeds chassisSpeeds) {
        setSwerveStates(new SwerveDriveKinematics().toSwerveModuleStates(chassisSpeeds));
    }

    public void setSwerveStates(SwerveModuleState[] states){
        backLeft.setSwerveState(states[0]); 
        backRight.setSwerveState(states[1]);
        frontLeft.setSwerveState(states[2]);
        frontRight.setSwerveState(states[3]);
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
        SmartDashboard.putNumber("Front Left Motor Angle", frontLeft.getAngle());
        SmartDashboard.putNumber("Front Right Motor Angle", frontRight.getAngle());
        SmartDashboard.putNumber("Back Left Motor Angle", backLeft.getAngle());
        SmartDashboard.putNumber("Back Right Motor Angle", backRight.getAngle());

        SmartDashboard.putNumber("Front Left Motor Speed", frontLeft.getSpeed());
        SmartDashboard.putNumber("Front Right Motor Speed", frontRight.getSpeed());
        SmartDashboard.putNumber("Back Left Motor Speed", backLeft.getSpeed());
        SmartDashboard.putNumber("Back Right Motor Speed", backRight.getSpeed());
    }
}