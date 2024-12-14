package frc.robot.Subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HandoffSubsystem extends SubsystemBase{
    // Declare the motors
    private final CANSparkMax handoffMotorOne = new CANSparkMax(6, CANSparkLowLevel.MotorType.kBrushless);
    private final CANSparkMax handoffMotorTwo = new CANSparkMax(7, CANSparkLowLevel.MotorType.kBrushless);

    // Private class so I can get velocity and position of the motor later on 
    private class HandoffInfo{
        @SuppressWarnings("unused")
        private double handoffMotorVelocity=0.0;
        @SuppressWarnings("unused")
        private double handoffMotorPosition=0.0;
    }

    // Setting power to the motors
    public void runHandoffMotors(double power) {
        handoffMotorOne.set(power);
        handoffMotorTwo.set(-1*power); 
    }

    // Setting the motors into Coast mode
    public void coast() {
        handoffMotorOne.setIdleMode(CANSparkMax.IdleMode.kCoast);
        handoffMotorTwo.setIdleMode(CANSparkMax.IdleMode.kCoast);
    }

    // Setting the motors into brake Mode
    public void brake() {
        handoffMotorOne.setIdleMode(CANSparkMax.IdleMode.kBrake);
        handoffMotorTwo.setIdleMode(CANSparkMax.IdleMode.kBrake);
    }

    // Getting info on the first Handoff Motor
    public HandoffInfo getHandoffOneInfo() {
        HandoffInfo one = new HandoffInfo();
        RelativeEncoder encoderOne = handoffMotorOne.getEncoder();
        one.handoffMotorVelocity = encoderOne.getPosition();
        one.handoffMotorPosition = encoderOne.getVelocity();
        return one;
    }

    // Getting info on the second handoff motor
    public HandoffInfo getHandoffTwoInfo() {
        HandoffInfo two = new HandoffInfo();
        RelativeEncoder encoderTwo = handoffMotorTwo.getEncoder();
        two.handoffMotorVelocity = encoderTwo.getPosition();
        two.handoffMotorPosition = encoderTwo.getVelocity();
        return two;
    }

    // uploading all the info in Smartdashboard
    @Override
    public void periodic() {
        // calculating the motor voltage
        double appliedOutputOne = handoffMotorOne.getAppliedOutput();
        double busVoltageOne = handoffMotorOne.getBusVoltage();
        double motorVoltageOne = appliedOutputOne * busVoltageOne;
        double appliedOutputTwo = handoffMotorTwo.getAppliedOutput();
        double busVoltageTwo = handoffMotorTwo.getBusVoltage();
        double motorVoltageTwo = appliedOutputTwo * busVoltageTwo;

        // Finding the encoders
        RelativeEncoder encoderOne = handoffMotorOne.getEncoder();
        RelativeEncoder encoderTwo = handoffMotorTwo.getEncoder();
        // Getting the position of the motor
        Double posOne = encoderOne.getPosition();
        Double posTwo = encoderTwo.getPosition();

        // uploading info into smartdashboard
        SmartDashboard.putNumber("Handoff Motor One Voltage", motorVoltageOne);
        SmartDashboard.putNumber("Handoff Motor One Position", posOne);
        SmartDashboard.putNumber("Handoff Motor Two Voltage", motorVoltageTwo);
        SmartDashboard.putNumber("Handoff Motor Two Position", posTwo);
  }
}
