package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix6.hardware.Pigeon2;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveBase extends SubsystemBase {
    private final SwerveModule frontLeft, frontRight, backLeft, backRight;
    private final Pigeon2 pigeon2;

    public SwerveBase() {
        // Initialize the Pigeon2 gyro on the SPI port (assuming ID 0, adjust if necessary)
        pigeon2 = new Pigeon2(0); 

        // Initialize swerve modules (IDs and offsets should be provided based on your setup)
        frontLeft = new SwerveModule(1, 2, 3, 98.35);
        frontRight = new SwerveModule(4, 5, 6, 3.5);
        backLeft = new SwerveModule(7, 8, 9, 34.84);
        backRight = new SwerveModule(10, 11, 12, 74.19);
    }

    public void drive(double forwardSpeed, double strafeSpeed, double rotationSpeed) {
        // Get the robot's current heading (yaw) from the Pigeon2
        double gyroAngle = Math.toRadians(pigeon2.getYaw().getValueAsDouble());  // Get yaw in degrees and convert to radians

        // Convert joystick inputs to field-relative values using the gyro heading
        double temp = forwardSpeed * Math.cos(gyroAngle) + strafeSpeed * Math.sin(gyroAngle);
        strafeSpeed = -forwardSpeed * Math.sin(gyroAngle) + strafeSpeed * Math.cos(gyroAngle);
        forwardSpeed = temp;

        // Calculate desired wheel speeds and angles for each module
        double[] wheelSpeeds = new double[4];
        double[] wheelAngles = new double[4];

        // Assuming you calculate the wheel speeds and angles (you can use a more complete kinematic model here)
        wheelSpeeds[0] = Math.sqrt(Math.pow(forwardSpeed, 2) + Math.pow(strafeSpeed, 2));
        wheelAngles[0] = Math.atan2(forwardSpeed, strafeSpeed);

        // Set the wheel speeds and angles for each module (implement the full calculation for each module)
        frontLeft.setDriveAndAngle(wheelSpeeds[0], wheelAngles[0]);
        frontRight.setDriveAndAngle(wheelSpeeds[1], wheelAngles[1]);
        backLeft.setDriveAndAngle(wheelSpeeds[2], wheelAngles[2]);
        backRight.setDriveAndAngle(wheelSpeeds[3], wheelAngles[3]);

        // Output to SmartDashboard for visualization
        SmartDashboard.putNumber("Robot Yaw", pigeon2.getYaw().getValueAsDouble());
    }

    public void resetGyro() {
        pigeon2.setYaw(0);  // Reset the gyro yaw to 0
    }
}
