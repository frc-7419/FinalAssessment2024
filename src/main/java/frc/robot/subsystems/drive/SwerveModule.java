// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.drive;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.math.kinematics.SwerveModuleState;

import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import frc.robot.Constants;

public class SwerveModule {
    private final TalonFX turnMotor;
    private final TalonFX driveMotor;
    private final CANcoder turnEncoder;
    private final PIDController angleController;
    private final String module;

    public SwerveModule(int turnMotorID, int driveMotorID, int turnEncoderID, double turnEncoderOffset, String module) {
        turnMotor = new TalonFX(turnMotorID);
        driveMotor = new TalonFX(driveMotorID);
        turnEncoder = new CANcoder(turnEncoderID);

        angleController = new PIDController(Constants.SwerveConstants.anglekP, Constants.SwerveConstants.anglekI, Constants.SwerveConstants.anglekD);
        angleController.enableContinuousInput(0, 360);
        angleController.setTolerance(0.5);

        this.module = module;
        coast();
    }

    public double getPosition() {
        return turnEncoder.getPosition().getValue();
    }

    public void setSwerveModuleState(SwerveModuleState state) {
        driveMotor.set(state.speedMetersPerSecond);
    }

    public void coast() {
        turnMotor.setNeutralMode(NeutralModeValue.Coast);
        driveMotor.setNeutralMode(NeutralModeValue.Coast);
    }

    public void brake() {
        turnMotor.setNeutralMode(NeutralModeValue.Brake);
        driveMotor.setNeutralMode(NeutralModeValue.Brake);
    }

    public void stop() {
        driveMotor.set(0);
        turnMotor.set(0);
    }

    public void putDashboard() {
        SmartDashboard.putNumber(module + " speed", driveMotor.get());
        SmartDashboard.putNumber(module + " position", getPosition());
    }
}