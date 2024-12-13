package frc.robot.commands;

import frc.robot.subsystems.SwerveBase;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;

public class RunSwerve extends CommandBase {
    private final SwerveBase swerveBase;
    private final XboxController controller;

    public RunSwerve(SwerveBase swerveBase, XboxController controller) {
        this.swerveBase = swerveBase;
        this.controller = controller;
        addRequirements(swerveBase);
    }

    @Override
    public void execute() {
        double forwardSpeed = -controller.getLeftY(); // Invert to match forward as positive
        double strafeSpeed = controller.getLeftX();
        double rotationSpeed = controller.getRightX();

        swerveBase.drive(forwardSpeed, strafeSpeed, rotationSpeed);
    }
    public void initialize() {
        swerveBase.coast();
      }
    public void end(boolean interrupted) {
        SwerveBase.brake();
      }
    @Override
    public boolean isFinished() {
        return false; // Continuous driving
    }
}
