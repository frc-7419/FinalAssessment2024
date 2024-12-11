package frc.robot.Subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HandoffSubsystem extends SubsystemBase{
    private final CANSparkMax handoffMotorOne = new CANSparkMax(6, CANSparkLowLevel.MotorType.kBrushless);
    private final CANSparkMax handoffMotorTwo = new CANSparkMax(7, CANSparkLowLevel.MotorType.kBrushless);

    private class HandoffInfo{
        @SuppressWarnings("unused")
        private double handoffMotorVelocity=0.0;
        @SuppressWarnings("unused")
        private double handoffMotorPosition=0.0;
    }

    public void runHandoffMotors(double power) {
        handoffMotorOne.set(power);
        handoffMotorTwo.set(power);  
    }

    public void coast() {
        handoffMotorOne.setIdleMode(CANSparkMax.IdleMode.kCoast);
        handoffMotorTwo.setIdleMode(CANSparkMax.IdleMode.kCoast);
    }

    public void brake() {
        handoffMotorOne.setIdleMode(CANSparkMax.IdleMode.kBrake);
        handoffMotorTwo.setIdleMode(CANSparkMax.IdleMode.kBrake);
    }

    public HandoffInfo getHandoffOneInfo() {
        HandoffInfo one = new HandoffInfo();
        RelativeEncoder encoderOne = handoffMotorOne.getEncoder();
        one.handoffMotorVelocity = encoderOne.getPosition();
        one.handoffMotorPosition = encoderOne.getVelocity();
        return one;
    }

    public HandoffInfo getHandoffTwoInfo() {
        HandoffInfo two = new HandoffInfo();
        RelativeEncoder encoderTwo = handoffMotorTwo.getEncoder();
        two.handoffMotorVelocity = encoderTwo.getPosition();
        two.handoffMotorPosition = encoderTwo.getVelocity();
        return two;
    }

    @Override
    public void periodic() {
        double appliedOutputOne = handoffMotorOne.getAppliedOutput();
        double busVoltageOne = handoffMotorOne.getBusVoltage();
        double motorVoltageOne = appliedOutputOne * busVoltageOne;
        double appliedOutputTwo = handoffMotorTwo.getAppliedOutput();
        double busVoltageTwo = handoffMotorTwo.getBusVoltage();
        double motorVoltageTwo = appliedOutputTwo * busVoltageTwo;

        RelativeEncoder encoderOne = handoffMotorOne.getEncoder();
        RelativeEncoder encoderTwo = handoffMotorTwo.getEncoder();
        Double posOne = encoderOne.getPosition();
        Double posTwo = encoderTwo.getPosition();

        SmartDashboard.putNumber("Handoff Motor One Voltage", motorVoltageOne);
        SmartDashboard.putNumber("Handoff Motor One Position", posOne);
        SmartDashboard.putNumber("Handoff Motor Two Voltage", motorVoltageTwo);
        SmartDashboard.putNumber("Handoff Motor Two Position", posTwo);
  }
}
