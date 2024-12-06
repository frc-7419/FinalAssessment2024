// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.drive;

import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.constants.Constants;

public class SwerveModule {
    private final TalonFX turnMotor;
    private final TalonFX driveMotor;
    private final CANcoder turnEncoder;
    private final PIDController angleController;
    private final String module;

    /**
     * @param turnMotorID       is a CAN ID parameter (int)
     * @param driveMotorID      is a CAN ID parameter (int)
     * @param turnEncoderID     is a CAN ID parameter (int)
     * @param turnEncoderOffset is absolute pos at zero in deg (double)
     * @param module            for naming modules during comprehensive shuffleboard outputs (String)
     */
    public SwerveModule(int turnMotorID, int driveMotorID, int turnEncoderID, double turnEncoderOffset, String module) {
        this.module = module;

        angleController = new PIDController(Constants.SwerveConstants.anglekP, Constants.SwerveConstants.anglekI, Constants.SwerveConstants.anglekD);
        angleController.enableContinuousInput(0, 360);
        angleController.setTolerance(0.5);

        turnMotor = new TalonFX(turnMotorID);

        driveMotor = new TalonFX(driveMotorID);

        turnEncoder = new CANcoder(turnEncoderID);

        coast();
    }

    public void coast() {
        turnMotor.setNeutralMode(NeutralModeValue.Coast);
        driveMotor.setNeutralMode(NeutralModeValue.Coast);
    }

    public void brake() {
        turnMotor.setNeutralMode(NeutralModeValue.Brake);
        driveMotor.setNeutralMode(NeutralModeValue.Brake);
    }

    public double getDrivePosition() {
        return turnEncoder.getPosition().getValue();
    }

    public void resetDriveEncoder() {
        turnEncoder.setPosition(0);
    }

    public boolean reachedDist(double meters) {
        return Math.abs(getDrivePosition()) > meters;
    }

    public void setSwerveModuleState(SwerveModuleState state) {
        driveMotor.set(state.speedMetersPerSecond);
    }

    /**
     * Stops all motors in the module
     */
    public void stop() {
        driveMotor.set(0);
        turnMotor.set(0);
    }

    /**
     * Outputs values to dashboard
     */
    public void outputDashboard() {
        SmartDashboard.putNumber(module + " driveSpeed", driveMotor.get());
        SmartDashboard.putNumber(module + " driveEncoder", getDrivePosition());
    }
}