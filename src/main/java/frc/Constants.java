// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc;

/** Add your docs here. */
public class Constants {
    public static double robotLength = 25;
    public static double robotWidth = 25;
    public static int driveJoystickPort = 1;
    public static int operatorJoystickPort = 1;
    public static class ShooterConstants{
        public static int encoderPort = 6;
        public static double encoderOffset = 40.0/360;
        public static int shooterRpm = 6000;
    }
    public static class wristConstants{
        public final static int encoderPort = 5;
        public static double encoderOffset= 40.0/360;
        

    }

    public static class canIDConstants{
        public final static int shooterTopMotorID = 8;
        public final static int shooterBottomMotorID = 9;
        public final static int intakeTopMotorID = 14;
        public final static int intakeBottomMotorID = 15;
        public final static int handoffTopMotorID =  16;
        public final static int handoffBottomMotorID =  17;
        public final static int hangerMotorID =  16;
        public final static int wristMotorID = 17;
        

    }
    public static class SwerveConstants{
        public final static int frontRightTurnMotorID = 0;
        public final static int frontLeftTurnMotorID = 1;
        public final static int backRightTurnMotorID = 2;
        public final static int backLeftTurnMotorID = 3;

        public final static int frontRightDriveMotorID = 4;
        public final static int frontLeftDriveMotorID = 5;
        public final static int backRightDriveMotorID = 6;
        public final static int backLeftDriveMotorID = 7;

        public final static int frontRightCANcoderID = 10;
        public final static int frontLeftCANcoderID = 11;
        public final static int backRightCANcoderID = 12;
        public final static int backLeftCANcoderID = 13;

        public final static double frontRightEncoderOffset = 3.5;
        public final static double frontLeftEncoderOffset = 98.35;
        public final static double backRightEncoderOffset = 74.19;
        public final static double backLeftEncoderOffset = 34.84;



    }
}
