package frc.robot.commands.shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.shooter.ShooterSubsystem;

public class RunJoystickShooter extends Command {
    private final ShooterSubsystem shooterSubsystem;
    private final XboxController xboxController;

    public RunJoystickShooter(ShooterSubsystem shooterSubsystem, XboxController xboxController) {
        this.shooterSubsystem = shooterSubsystem;
        this.xboxController = xboxController;
        addRequirements(shooterSubsystem);
    }

    @Override
    public void initialize() {
      shooterSubsystem.coast();
    }

    @Override
    public void execute() {
      shooterSubsystem.setSpeed(xboxController.getLeftY());
    }

    @Override
    public void end(boolean interrupted) {
      shooterSubsystem.brake();
    }
}