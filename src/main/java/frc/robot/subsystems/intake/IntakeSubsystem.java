package frc.robot.subsystems.intake;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class IntakeSubsystem extends SubsystemBase {

  private final CANSparkMax leftMotor;   
  private final CANSparkMax rightMotor;
  
  public IntakeSubsystem() {
    leftMotor = new CANSparkMax(6, MotorType.kBrushless);
    rightMotor = new CANSparkMax(7, MotorType.kBrushless);
  }

  public void setPower(double power) {
    leftMotor.set(power);
    rightMotor.set(power);
  }

  public void coast() {
    leftMotor.setIdleMode(IdleMode.kCoast);
    rightMotor.setIdleMode(IdleMode.kCoast);
  }

  public void brake() {
    leftMotor.setIdleMode(IdleMode.kBrake);
    rightMotor.setIdleMode(IdleMode.kBrake);
  }

  @Override
  public void periodic() {
      SmartDashboard.putNumber("Intake Left Motor Speed", leftMotor.get());
      SmartDashboard.putNumber("Intake Right Motor Speed", rightMotor.get());
      SmartDashboard.putNumber("Intake Left Motor Voltage", leftMotor.getBusVoltage());
      SmartDashboard.putNumber("Intake Right Motor Voltage", rightMotor.getBusVoltage());
      SmartDashboard.putNumber("Intake Left Motor Temperature", leftMotor.getMotorTemperature());
      SmartDashboard.putNumber("Intake Right Motor Temperature", rightMotor.getMotorTemperature());
  }
}
