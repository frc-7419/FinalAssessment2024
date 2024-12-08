package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class Shooter {
    private TalonFX shooterTopMotor = new TalonFX(3); // Replace with CAN ID
    private TalonFX shooterBottomMotor = new TalonFX(4); // Replace with CAN ID

    public void runShootersMotors(double power) {
        shooterTopMotor.set(power);
        shooterBottomMotor.set(power);
    }

    public void coast() {
        shooterTopMotor.setNeutralMode(NeutralModeValue.Coast);
        shooterBottomMotor.setNeutralMode(NeutralModeValue.Coast);
    }

    public void brake() {
      shooterTopMotor.setNeutralMode(NeutralModeValue.Brake);
      shooterBottomMotor.setNeutralMode(NeutralModeValue.Brake);
    }

    public double getShooterInfo() {
        return  shooterBottomMotor.getPosition().getValueAsDouble(), 
        shooterBottomMotor.getVelocity().getValueAsDouble(), 
        shooterTopMotor.getPosition().getValueAsDouble(),
        shooterTopMotor.getVelocity().getValueAsDouble();
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Shooter Bottom Motor Voltage", shooterBottomMotor.getMotorVoltage().getValue());
        SmartDashboard.putNumber("Shooter Bottom Position", shooterBottomMotor.getPosition().getValue());
        SmartDashboard.putNumber("Shooter Top Motor Voltage", shooterTopMotor.getMotorVoltage().getValue());
        SmartDashboard.putNumber("Shooter Top Position", shooterTopMotor.getPosition().getValue());
  }
}
