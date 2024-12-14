// package
package frc.robot.Subsystems;

// importing
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase{
    // Declaring the motors
    private final CANSparkMax intakeMotorOne = new CANSparkMax(1, CANSparkLowLevel.MotorType.kBrushless);
    private final CANSparkMax intakeMotorTwo = new CANSparkMax(2, CANSparkLowLevel.MotorType.kBrushless);

    // Private class so I can get velocity and position of the motor later on
    private class IntakeInfo{
        @SuppressWarnings("unused")
        private double intakeMotorVelocity=0.0;
        @SuppressWarnings("unused")
        private double intakeMotorPosition=0.0;
    }

    // Setting powers to the motors
    public void runIntakeMotors(double power) {
        intakeMotorOne.set(power);
        intakeMotorTwo.set(power);  
    }

    // Setting the motors to coast mode
    public void coast() {
        intakeMotorOne.setIdleMode(CANSparkMax.IdleMode.kCoast);
        intakeMotorTwo.setIdleMode(CANSparkMax.IdleMode.kCoast);
    }

    // Setting the motors to brake motors
    public void brake() {
        intakeMotorOne.setIdleMode(CANSparkMax.IdleMode.kBrake);
        intakeMotorTwo.setIdleMode(CANSparkMax.IdleMode.kBrake);
    }

    // Getting info on the first Intake Motor
    public IntakeInfo getIntakeMotorOneInfo() {
        IntakeInfo one = new IntakeInfo();
        RelativeEncoder encoderOne = intakeMotorOne.getEncoder();
        one.intakeMotorVelocity = encoderOne.getPosition();
        one.intakeMotorPosition = encoderOne.getVelocity();
        return one;
    }

    // Getting info on the second Intake Motor
    public IntakeInfo getIntakeMotorTwoInfo() {
        IntakeInfo two = new IntakeInfo();
        RelativeEncoder encoderTwo = intakeMotorTwo.getEncoder();
        two.intakeMotorVelocity = encoderTwo.getPosition();
        two.intakeMotorPosition = encoderTwo.getVelocity();
        return two;
    }

    // Uploading all the info into smartdashboard
    @Override
    public void periodic() {
        // Calculating the motor voltage
        double appliedOutputOne = intakeMotorOne.getAppliedOutput();
        double busVoltageOne = intakeMotorOne.getBusVoltage();
        double motorVoltageOne = appliedOutputOne * busVoltageOne;
        double appliedOutputTwo = intakeMotorTwo.getAppliedOutput();
        double busVoltageTwo = intakeMotorTwo.getBusVoltage();
        double motorVoltageTwo = appliedOutputTwo * busVoltageTwo;

        // Find the encoders
        RelativeEncoder encoderOne = intakeMotorOne.getEncoder();
        RelativeEncoder encoderTwo = intakeMotorTwo.getEncoder();
        // Getting the position of the motor
        Double posOne = encoderOne.getPosition();
        Double posTwo = encoderTwo.getPosition();

        SmartDashboard.putNumber("Intake Bottom Motor Voltage", motorVoltageOne);
        SmartDashboard.putNumber("Intake Bottom Position", posOne);
        SmartDashboard.putNumber("Intake Top Motor Voltage", motorVoltageTwo);
        SmartDashboard.putNumber("Intake Top Position", posTwo);
  }
}

