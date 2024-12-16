// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;

public final class Constants {

    public static class SwerveModuleConstants {
        public static final double kMaxTurningSpeed = 0.5;
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

    public static class SwerveConstants {
        public static final double LENGTH = Units.inchesToMeters(25); 
        public static final double WIDTH = Units.inchesToMeters(25); 
        public static final double HALF_LENGTH = LENGTH / 2.0; 

        public static final SwerveModuleConstants frontLeft = new SwerveModuleConstants(1, 2, 3, 98.35, new Translation2d(SwerveConstants.HALF_LENGTH, SwerveConstants.HALF_LENGTH));
        public static final SwerveModuleConstants frontRight = new SwerveModuleConstants(4, 5, 6, 3.5, new Translation2d(SwerveConstants.HALF_LENGTH, -SwerveConstants.HALF_LENGTH));
        public static final SwerveModuleConstants backLeft = new SwerveModuleConstants(7, 8, 9, 34.84, new Translation2d(-SwerveConstants.HALF_LENGTH, SwerveConstants.HALF_LENGTH));
        public static final SwerveModuleConstants backRight = new SwerveModuleConstants(10, 11, 12, 74.19, new Translation2d(-SwerveConstants.HALF_LENGTH, -SwerveConstants.HALF_LENGTH));
        public static final SwerveDriveKinematics m_SwerveDriveKinematics = new SwerveDriveKinematics(SwerveConstants.frontLeft.location, SwerveConstants.frontRight.location, SwerveConstants.backLeft.location, SwerveConstants.backRight.location);
                
        public static final double anglekP = 1;
        public static final double anglekI = 0;
        public static final double anglekD = 0;
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

    public static class ControllerConstants {
        public static final int kDriveControllerPort = 0;
        public static final int kOperatorControllerPort = 1;
        public static final double defaultPulseInterval = 0.5;
        public static final double defaultRumbleIntensity = 0.5;
    }

}