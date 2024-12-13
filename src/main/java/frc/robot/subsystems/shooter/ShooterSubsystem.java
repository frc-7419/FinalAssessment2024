package frc.robot.subsystems.shooter;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class ShooterSubsystem extends SubsystemBase {
    private final TalonFX topMotor;
    private final TalonFX bottomMotor;

    public ShooterSubsystem() {
        topMotor = new TalonFX(4);
        bottomMotor = new TalonFX(5);
        topMotor.setInverted(true);
        bottomMotor.setInverted(true);
    }

    public void setSpeed(double speed) {
        topMotor.set(speed);       
        bottomMotor.set(speed);
    }

    public void coast() {
        topMotor.setNeutralMode(NeutralModeValue.Coast);
        bottomMotor.setNeutralMode(NeutralModeValue.Coast);
    }

    public void brake() {
        topMotor.setNeutralMode(NeutralModeValue.Brake);
        bottomMotor.setNeutralMode(NeutralModeValue.Brake);
    }

  @Override
    public void periodic() {
        SmartDashboard.putNumber("Shooter Top Motor Speed", topMotor.get());
        SmartDashboard.putNumber("Shooter Bottom Motor Speed", bottomMotor.get());
        SmartDashboard.putNumber("Shooter Top Motor Position", topMotor.getPosition().getValueAsDouble());
        SmartDashboard.putNumber("Shooter Bottom Motor Position", bottomMotor.getPosition().getValueAsDouble());
        SmartDashboard.putNumber("Shooter Top Motor Temperature", topMotor.getDeviceTemp().getValueAsDouble());
        SmartDashboard.putNumber("Shooter Bottom Motor Temperature", bottomMotor.getDeviceTemp().getValueAsDouble());
    }
}