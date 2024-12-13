package frc.robot.subsystems.hanger;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HangerSubsystem extends SubsystemBase {
    private final TalonFX hangerMotor;

    public HangerSubsystem() {
        this.hangerMotor = new TalonFX(1);
        hangerMotor.setInverted(true);
    }

    public void setSpeed(double speed) {
        hangerMotor.set(speed);
    }

    public void coast() {
        hangerMotor.setNeutralMode(NeutralModeValue.Coast);
    }

    public void brake() {
        hangerMotor.setNeutralMode(NeutralModeValue.Brake);
    }

    public void periodic() {
        SmartDashboard.putNumber("Hanger Motor Speed", hangerMotor.get());
        SmartDashboard.putNumber("Hanger Motor Position", hangerMotor.getPosition().getValueAsDouble());
        SmartDashboard.putNumber("Hanger Top Motor Temperature", hangerMotor.getDeviceTemp().getValueAsDouble());
    }
}
