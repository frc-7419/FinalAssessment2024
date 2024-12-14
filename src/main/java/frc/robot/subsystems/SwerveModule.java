// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveModule extends SubsystemBase {
    private final TalonFX turnMotor;
    private final TalonFX moveMotor;
    private final PIDController pidController;
    private final CANcoder encoder;
    private double speed;

    private final double angleOffset;

    public SwerveModule(TalonFX turnMotor, TalonFX moveMotor, CANcoder encoder, double angleOffset) {
        this.turnMotor = turnMotor;
        this.moveMotor = moveMotor;
        this.encoder = encoder;
        this.angleOffset = angleOffset;
        this.pidController = new PIDController(0.5, 0.5, 0.5);
        this.pidController.setTolerance(1);
        this.speed = 0;
    }

    public void setSwerveState(SwerveModuleState swerveState) {
        speed = swerveState.speedMetersPerSecond;
        moveMotor.set(speed);
    
        double adjustedAngle = swerveState.angle.getDegrees() - angleOffset;
        pidController.setSetpoint(adjustedAngle);
        pidController.calculate(turnMotor.getPosition().getValueAsDouble(), adjustedAngle);
    }

    public double getAngle() {
        return encoder.getPosition().getValueAsDouble();
    }

    public double getSpeed() {
        return speed;
    }

    public void coast() {
        turnMotor.setNeutralMode(NeutralModeValue.Coast);
        moveMotor.setNeutralMode(NeutralModeValue.Coast);
    }

    public void brake() {
        turnMotor.setNeutralMode(NeutralModeValue.Brake);
        moveMotor.setNeutralMode(NeutralModeValue.Brake);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Turn Motor Temp", turnMotor.getDeviceTemp().getValueAsDouble()); 
        SmartDashboard.putNumber("Move Motor Temp", moveMotor.getDeviceTemp().getValueAsDouble());
    }
}