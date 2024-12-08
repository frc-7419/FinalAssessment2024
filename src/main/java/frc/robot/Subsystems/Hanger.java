package frc.robot.Subsystems;

import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Hanger {
    private TalonSRX hangerMotor = new TalonSRX(5);
    
    public void runHangerMotors(double power) {
        hangerMotor.set(power);
    }

    public void coast() {
        hangerMotor.setNeutralMode(NeutralModeValue.Coast);
    }

    public void brake() {
        hangerMotor.setNeutralMode(NeutralModeValue.Brake);
    }

    public double getHangerInfo() {
        return  hangerMotor.getPosition().getValueAsDouble();
        return  hangerMotor.getVelocity().getValueAsDouble();
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Hanger Motor Voltage", hangerMotor.getMotorVoltage().getValue());
        SmartDashboard.putNumber("Hanger Position", hangerMotor.getPosition().getValue());
  }
}