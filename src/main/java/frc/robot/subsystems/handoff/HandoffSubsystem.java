package frc.robot.subsystems.handoff;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HandoffSubsystem extends SubsystemBase {
    private final CANSparkMax topMotor;
    private final CANSparkMax bottomMotor;

    public HandoffSubsystem() {
        this.topMotor = new CANSparkMax(2, MotorType.kBrushless);
        this.bottomMotor = new CANSparkMax(3, MotorType.kBrushless);
        bottomMotor.setInverted(true);
    }

    public void setSpeed(double speed) {
        topMotor.set(speed);
        bottomMotor.set(speed);
    }

    public void coast() {
        topMotor.setIdleMode(IdleMode.kCoast);
        bottomMotor.setIdleMode(IdleMode.kCoast);
    }

    public void brake() {
        topMotor.setIdleMode(IdleMode.kBrake);
        bottomMotor.setIdleMode(IdleMode.kBrake);
    }

    public void periodic() {
        SmartDashboard.putNumber("Handoff Top Motor Speed", topMotor.get());
        SmartDashboard.putNumber("Handoff Bottom Motor Speed", bottomMotor.get());
        SmartDashboard.putNumber("Handoff Top Motor Voltage", topMotor.getBusVoltage());
        SmartDashboard.putNumber("Handoff Bottom Motor Voltage", bottomMotor.getBusVoltage());
        SmartDashboard.putNumber("Handoff Left Motor Temperature", topMotor.getMotorTemperature());
        SmartDashboard.putNumber("Handoff Right Motor Temperature", bottomMotor.getMotorTemperature());      
    }
}