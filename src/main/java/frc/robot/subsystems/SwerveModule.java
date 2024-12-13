package frc.robot.subsystems;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class SwerveModule {
    private final TalonFX driveMotor;
    private final TalonFX turnMotor;
    private final CANcoder absoluteEncoder;
    private final double offset;
    private final PIDController turnPidController;

    
    public SwerveModule(int driveMotorID, int turnMotorID, int canCoderID, double offset, double kP, double kI, double kD) {
        this.driveMotor = new TalonFX(driveMotorID);
        this.turnMotor = new TalonFX(turnMotorID);
        this.absoluteEncoder = new CANcoder(canCoderID);
        this.offset = offset;
        turnPidController = new PIDController(kP, kI, kD);
        
    }
    public void brake() {
        driveMotor.setNeutralMode(NeutralModeValue.Brake);
        turnMotor.setNeutralMode(NeutralModeValue.Brake);
      }
    
      public void coast() {
        driveMotor.setNeutralMode(NeutralModeValue.Coast);
        turnMotor.setNeutralMode(NeutralModeValue.Coast);
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
        double currentAngle = absoluteEncoder.getAbsolutePosition().getValueAsDouble();

     

        // Calculate the shortest angle difference
        // idk about the math...
        double angleError = desiredAngle - currentAngle;
        if (angleError > 180) {
            angleError -= 360;
        } else if (angleError < -180) {
            angleError += 360;
        }

        double turnOutput = turnPidController.calculate(angleError);

        // Set the drive motor speed
        driveMotor.set(speed);

        // Set the turn motor speed using a PID controller for precise control
        // Will replace with PID once implemented
        double turnSpeed = turnPidController.calculate(angleError);
        turnMotor.set(turnSpeed);

        // Output to SmartDashboard for debugging and tuning
        SmartDashboard.putNumber("Module Angle", currentAngle);
        SmartDashboard.putNumber("Desired Angle", desiredAngle);
        SmartDashboard.putNumber("Drive Motor Speed", speed);
        SmartDashboard.putNumber("Turn Motor Speed", turnSpeed);
        SmartDashboard.putNumber("Turn PID Error", angleError);
    }
}