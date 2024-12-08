package frc.robot.Subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{
    private final CANSparkMax intakeMotorOne = new CANSparkMax(1, CANSparkLowLevel.MotorType.kBrushless);
    private final CANSparkMax intakeMotorTwo = new CANSparkMax(2, CANSparkLowLevel.MotorType.kBrushless);

    private class IntakeInfo extends SubsystemBase{
        @SuppressWarnings("unused")
        private double intakeMotorVelocity=0.0;
        @SuppressWarnings("unused")
        private double intakeMotorPosition=0.0;
    }

    public void runIntakeMotors(double power) {
        intakeMotorOne.set(power);
        intakeMotorTwo.set(power);  
    }

    public void coast() {
        intakeMotorOne.setIdleMode(CANSparkMax.IdleMode.kCoast);
        intakeMotorTwo.setIdleMode(CANSparkMax.IdleMode.kCoast);
    }

    public void brake() {
        intakeMotorOne.setIdleMode(CANSparkMax.IdleMode.kBrake);
        intakeMotorTwo.setIdleMode(CANSparkMax.IdleMode.kBrake);
    }

    public IntakeInfo getIntakeMotorOneInfo() {
        IntakeInfo one = new IntakeInfo();
        RelativeEncoder encoderOne = intakeMotorOne.getEncoder();
        one.intakeMotorVelocity = encoderOne.getPosition();
        one.intakeMotorPosition = encoderOne.getVelocity();
        return one;
    }

    public IntakeInfo getIntakeMotorTwoInfo() {
        IntakeInfo two = new IntakeInfo();
        RelativeEncoder encoderTwo = intakeMotorTwo.getEncoder();
        two.intakeMotorVelocity = encoderTwo.getPosition();
        two.intakeMotorPosition = encoderTwo.getVelocity();
        return two;
    }

    @Override
    public void periodic() {
        double appliedOutputOne = intakeMotorOne.getAppliedOutput();
        double busVoltageOne = intakeMotorOne.getBusVoltage();
        double motorVoltageOne = appliedOutputOne * busVoltageOne;
        double appliedOutputTwo = intakeMotorTwo.getAppliedOutput();
        double busVoltageTwo = intakeMotorTwo.getBusVoltage();
        double motorVoltageTwo = appliedOutputTwo * busVoltageTwo;

        RelativeEncoder encoderOne = intakeMotorOne.getEncoder();
        RelativeEncoder encoderTwo = intakeMotorTwo.getEncoder();
        Double posOne = encoderOne.getPosition();
        Double posTwo = encoderTwo.getPosition();

        SmartDashboard.putNumber("Intake Bottom Motor Voltage", motorVoltageOne);
        SmartDashboard.putNumber("Intake Bottom Position", posOne);
        SmartDashboard.putNumber("Intake Top Motor Voltage", motorVoltageTwo);
        SmartDashboard.putNumber("Intake Top Position", posTwo);
  }
}

