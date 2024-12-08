package frc.robot.Subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Handoff {
    private CANSparkMax handoffMotorOne = new CANSparkMax(6);
    private CANSparkMax handoffMotorTwo = new CANSparkMax(7);

    public void runIntakeMotors(double power) {
        handoffMotorOne.set(power);
        handoffMotorTwo.set(power);  
    }

    public void coast() {
        handoffMotorOne.setNeutralMode(NeutralModeValue.Coast);
        handoffMotorTwo.setNeutralMode(NeutralModeValue.Coast);
    }

    public void brake() {
        handoffMotorOne.setNeutralMode(NeutralModeValue.Brake);
        handoffMotorTwo.setNeutralMode(NeutralModeValue.Brake);
    }

    public double getIntakeInfo() {
        return  handoffMotorOne.getPosition().getValueAsDouble(), 
        handoffMotorOne.getVelocity().getValueAsDouble(), 
        handoffMotorTwo.getPosition().getValueAsDouble(),
        handoffMotorTwo.getVelocity().getValueAsDouble();
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Intake Bottom Motor Voltage", handoffMotorOne.getMotorVoltage().getValue());
        SmartDashboard.putNumber("Intake Bottom Position", handoffMotorOne.getPosition().getValue());
        SmartDashboard.putNumber("Intake Top Motor Voltage", handoffMotorTwo.getMotorVoltage().getValue());
        SmartDashboard.putNumber("Intake Top Position", handoffMotorTwo.getPosition().getValue());
  }
}
