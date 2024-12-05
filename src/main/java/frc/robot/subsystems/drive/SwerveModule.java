// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.drive;

// import com.ctre.phoenix.sensors.AbsoluteSensorRange;
// import com.ctre.phoenix.sensors.CANCoder;
// import com.ctre.phoenix.sensors.SensorInitializationStrategy;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.constants.Constants;

/**
 * This is where the low-level logic for swerve is handled
 */
public class SwerveModule {
    private final CANSparkMax turnMotor;
    private final CANSparkMax driveMotor;
    // private final CANCoder turnEncoder;
    private final RelativeEncoder driveEncoder;
    private final PIDController angleController;
    private final String module;

    /**
     * Makes a new swerve module, this handles one turn motor and one drive motor
     *
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

        turnMotor = new CANSparkMax(turnMotorID, MotorType.kBrushless);
        turnMotor.setIdleMode(IdleMode.kCoast);

        driveMotor = new CANSparkMax(driveMotorID, MotorType.kBrushless);
        driveMotor.setIdleMode(IdleMode.kCoast);

        driveEncoder = driveMotor.getEncoder();
        driveEncoder.setPositionConversionFactor(1 / ((1 / Constants.SwerveConstants.kWheelCircumference) * 5.5));
    }

    public void coast() {
        turnMotor.setIdleMode(IdleMode.kCoast);
        driveMotor.setIdleMode(IdleMode.kCoast);
    }

    public void brake() {
        turnMotor.setIdleMode(IdleMode.kBrake);
        driveMotor.setIdleMode(IdleMode.kBrake);
    }

    public double getDrivePosition() {
        return driveEncoder.getPosition();
    }

    public void resetDriveEncoder() {
        driveEncoder.setPosition(0);
    }

    public boolean reachedDist(double meters) {
        return Math.abs(driveEncoder.getPosition()) > meters;
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