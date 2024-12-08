package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

public class Shooter {
    private TalonFX shooterTopMotor = new TalonFX(/*x*/); // Replace with CAN ID
    private TalonFX shooterBottomMotor = new TalonFX(/*x*/); // Replace with CAN ID

    public void runMotors(double power) {
        ParallelCommandGroup().addCommands(
            shooterTopMotor.set(power);
            shoooterBottomMotor.set(power);
        )   
    }

    public void set
}
