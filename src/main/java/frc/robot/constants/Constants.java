// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.constants;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;

public final class Constants {

    public static class ControllerConstants {
        public static final int kDriveControllerPort = 0;
        public static final int kOperatorControllerPort = 1;
        public static final double defaultRumbleIntensity = 0.7;
        public static final double defaultPulseInterval = 0.5;
    }

    public static class HangerConstants {
        public static final int motorOneID = 1; 
    }

    public static class HandoffConstants {
        public static final int motorOneID = 3; 
        public static final int motorTwoID = 4; 
    }

    public static class ShooterConstants {
        public static final int topShooterID = 5; 
        public static final int bottomShooterID = 6; 
    }

    public static class IntakeConstants {
        public static final int topIntakeID = 7; 
        public static final int bottomIntakeID = 8; 
    }

    public static class SwerveConstants {
        /*
         * ANGLE MOTOR
         * NEO Shaft to 12T Pulley to 24T Pulley to 14T Gear to 72T Main Rotation Gear
         */
        public static final double kGearRatioAngleMotor = 12.0 / 24.0 * 14.0 / 72.0;
        /*
         * DRIVE MOTOR
         * NEO shaft to 12T Pulley to 24T Pulley to 24T Gear to 22T Gear to 15T bevel to
         * 45T Bevel
         *
         * The CANCODER measures rotations of a the driven 1:1 PULLEY in which the
         * driver pulley is on the same
         * shaft as the 24T Pulley
         */
        public static final double kSpeedMotorGearRatio = 12.0 / 24.0 * 24.0 / 22.0 * 15.0 / 45.0;
        public static final double LENGTH = Units.inchesToMeters(25); 
        public static final double WIDTH = Units.inchesToMeters(25); 
        public static final double HALF_LENGTH = LENGTH / 2.0; 

        public static final SwerveModuleConstants frontLeft = new SwerveModuleConstants(9, 10, 11, 98.35,
                new Translation2d(SwerveConstants.HALF_LENGTH, SwerveConstants.HALF_LENGTH));
        public static final SwerveModuleConstants frontRight = new SwerveModuleConstants(12, 13, 14, 3.5,
                new Translation2d(SwerveConstants.HALF_LENGTH, -SwerveConstants.HALF_LENGTH));
        public static final SwerveModuleConstants backLeft = new SwerveModuleConstants(15, 16, 17, 34.84,
                new Translation2d(-SwerveConstants.HALF_LENGTH, SwerveConstants.HALF_LENGTH));
        public static final SwerveModuleConstants backRight = new SwerveModuleConstants(18, 19, 20, 74.19,
                new Translation2d(-SwerveConstants.HALF_LENGTH, -SwerveConstants.HALF_LENGTH));
        public static final SwerveDriveKinematics m_SwerveDriveKinematics = new SwerveDriveKinematics(
                SwerveConstants.frontLeft.location, SwerveConstants.frontRight.location, SwerveConstants.backLeft.location,
                SwerveConstants.backRight.location);
        public static final double kMaxTranslationalSpeed = Units.feetToMeters(3);
        public static final double kMaxRotationalSpeed = Math.PI / 4;
        public static final double kWheelDiameter = Units.inchesToMeters(3.5);
        public static final double kWheelCircumference = kWheelDiameter * Math.PI;
        public static final double anglekP = 0;
        public static final double anglekI = 0;
        public static final double anglekD = 0;
    }

    public static class SwerveModuleConstants {
        public static final double kMaxTurningSpeed = 0.3;
        public final int driveMotorID;
        public final int turnMotorID;
        public final int turnEncoderID;
        public final double offset;
        public final Translation2d location;

        public SwerveModuleConstants(int driveMotorID, int turnMotorID, int turnEncoderID, double offset, Translation2d location) {
            this.driveMotorID = driveMotorID;
            this.turnMotorID = turnMotorID;
            this.turnEncoderID = turnEncoderID;
            this.offset = offset;
            this.location = location;
        }
    }
}