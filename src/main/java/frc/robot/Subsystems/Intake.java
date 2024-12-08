package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Intake {
    private CANSparkMax intakeMotorOne = new CANSparkMax(1);
    private CANSparkMax intakeMotorTwo = new CANSparkMax(2);

    public void runIntakeMotors(double power) {
        intakeMotorOne.set(power);
        intakeMotorTwo.set(power);  
    }

    public void coast() {
        intakeMotorOne.setNeutralMode(NeutralModeValue.Coast);
        intakeMotorTwo.setNeutralMode(NeutralModeValue.Coast);
    }

    public void brake() {
        intakeMotorOne.setNeutralMode(NeutralModeValue.Brake);
        intakeMotorTwo.setNeutralMode(NeutralModeValue.Brake);
    }

    public double getIntakeInfo() {
        return  intakeMotorOne.getPosition().getValueAsDouble(), 
        intakeMotorOne.getVelocity().getValueAsDouble(), 
        intakeMotorTwo.getPosition().getValueAsDouble(),
        intakeMotorTwo.getVelocity().getValueAsDouble();
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Intake Bottom Motor Voltage", intakeMotorOne.getMotorVoltage().getValue());
        SmartDashboard.putNumber("Intake Bottom Position", intakeMotorOne.getPosition().getValue());
        SmartDashboard.putNumber("Intake Top Motor Voltage", intakeMotorTwo.getMotorVoltage().getValue());
        SmartDashboard.putNumber("Intake Top Position", intakeMotorTwo.getPosition().getValue());
  }
}

