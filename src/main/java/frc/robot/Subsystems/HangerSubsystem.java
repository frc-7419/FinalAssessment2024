package frc.robot.subsystems;

import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HangerSubsystem extends SubsystemBase{
    private final TalonSRX hangerMotor = new TalonSRX(5);
    
    public void runHangerMotors(double power) {
        hangerMotor.set(ControlMode.PercentOutput, power);
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
