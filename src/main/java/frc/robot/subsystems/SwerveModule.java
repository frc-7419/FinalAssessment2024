package frc.robot.subsystems;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SwerveModule {
    private final TalonFX driveMotor;
    private final TalonFX turnMotor;
    private final CAN absoluteEncoder;
    private final double offset;

    public SwerveModule(int driveMotorID, int turnMotorID, int canCoderID, double offset) {
        this.driveMotor = new TalonFX(driveMotorID);
        this.turnMotor = new TalonFX(turnMotorID);
        this.absoluteEncoder = new CAN(canCoderID);
        this.offset = offset;

        // configure encoder and motor controllers
        absoluteEncoder.configAbsoluteSensorRange(CAN.configAbsoluteSensorRange.Signed_PlusMinus180);
        // Configure drive & turn motor controllers (with PID later)
    }

    // Method to set the speed and angle of the module
    public void setDriveAndAngle(double speed, double angle) {
        // Calculate the desired angle, taking into account the offset and normalization
        double desiredAngle = angle + offset;
        if (desiredAngle > 180) {
            desiredAngle -= 360;
        } else if (desiredAngle < -180) {
            desiredAngle += 360;
        }

        // Get the current angle from the absolute encoder
        double currentAngle = absoluteEncoder.getAbsolutePosition();

        // Calculate the shortest angle difference
        // idk about the math...
        double angleError = desiredAngle - currentAngle;
        if (angleError > 180) {
            angleError -= 360;
        } else if (angleError < -180) {
            angleError += 360;
        }

        // Set the drive motor speed
        driveMotor.set(speed);

        // Set the turn motor speed using a PID controller for precise control
        // Will replace with PID once implemented
        double turnSpeed = pidController.calculate(angleError);
        turnMotor.set(turnSpeed);

        // Output to SmartDashboard for debugging and tuning
        SmartDashboard.putNumber("Module Angle", currentAngle);
        SmartDashboard.putNumber("Desired Angle", desiredAngle);
        SmartDashboard.putNumber("Drive Motor Speed", speed);
        SmartDashboard.putNumber("Turn Motor Speed", turnSpeed);
    }
}