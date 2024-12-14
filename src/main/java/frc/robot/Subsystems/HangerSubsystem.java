package frc.robot.Subsystems;

import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HangerSubsystem extends SubsystemBase{
    // Declaring the motors
    private final TalonFX hangerMotor = new TalonFX(5);
    
    // Private class so I can get velocity and position of the motor later on
    private class HangerInfo {
        @SuppressWarnings("unused")
        private double hangerVelocity=0.0;
        @SuppressWarnings("unused")
        private double hangerPosition=0.0;
    }
    // Setting the power to the motors
    public void runHangerMotors(double power) {
        hangerMotor.set(power);
    }

    // Setting the motors to coast mode
    public void coast() {
        hangerMotor.setNeutralMode(NeutralModeValue.Coast);
    }

    // Setting the motors to brake mode
    public void brake() {
        hangerMotor.setNeutralMode(NeutralModeValue.Brake);
    }

    // Geting info on the Hanger Motor
    public HangerInfo getHangerInfo() {
        HangerInfo motor = new HangerInfo();
        motor.hangerVelocity = hangerMotor.getVelocity().getValueAsDouble();
        motor.hangerPosition = hangerMotor.getPosition().getValueAsDouble();
        return motor;
    }

    // Uploading all the info to Smartdashboard
    @Override
    public void periodic() {
        SmartDashboard.putNumber("Hanger Motor Voltage", hangerMotor.getMotorVoltage().getValue());
        SmartDashboard.putNumber("Hanger Position", hangerMotor.getPosition().getValue());
  }
}
