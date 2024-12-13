// Package
package frc.robot.Subsystems;

// Imports
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ShooterSubsystem extends SubsystemBase{
    // Declaring the motors
    private final TalonFX shooterTopMotor = new TalonFX(3); 
    private final TalonFX shooterBottomMotor = new TalonFX(4); 

    // Private class so I can get velocity and position of the motor later on
    private class ShooterInfo {
        @SuppressWarnings("unused")
        private double shooterVelocity=0.0;
        @SuppressWarnings("unused")
        private double shooterPosition=0.0;
    }

    // setting power to the motors
    public void runShootersMotors(double power) {
        shooterTopMotor.set(power);
        shooterBottomMotor.set(power);
    }

    // Settings the motors to coast mode
    public void coast() {
        shooterTopMotor.setNeutralMode(NeutralModeValue.Coast);
        shooterBottomMotor.setNeutralMode(NeutralModeValue.Coast);
    }

    // Settings the motors to brake mode
    public void brake() {
      shooterTopMotor.setNeutralMode(NeutralModeValue.Brake);
      shooterBottomMotor.setNeutralMode(NeutralModeValue.Brake);
    }

    // Getting the info about the top motor
    public ShooterInfo getShooterTopMotorInfo() {
        ShooterInfo top = new ShooterInfo();
        top.shooterVelocity = shooterTopMotor.getVelocity().getValueAsDouble();
        top.shooterPosition = shooterTopMotor.getPosition().getValueAsDouble();
        return top;
    }

    // Getting the info about the bottom motor
    public ShooterInfo getShooterBottomMotorInfo() {
        ShooterInfo bottom = new ShooterInfo();
        bottom.shooterVelocity = shooterBottomMotor.getVelocity().getValueAsDouble();
        bottom.shooterPosition = shooterBottomMotor.getPosition().getValueAsDouble();
        return bottom;
    }
  
    // Upload info into Smartdashboard
    @ Override
    public void periodic() {
        SmartDashboard.putNumber("Shooter Bottom Motor Voltage", shooterBottomMotor.getMotorVoltage().getValue());
        SmartDashboard.putNumber("Shooter Bottom Position", shooterBottomMotor.getPosition().getValue());
        SmartDashboard.putNumber("Shooter Top Motor Voltage", shooterTopMotor.getMotorVoltage().getValue());
        SmartDashboard.putNumber("Shooter Top Position", shooterTopMotor.getPosition().getValue());
  }
}
