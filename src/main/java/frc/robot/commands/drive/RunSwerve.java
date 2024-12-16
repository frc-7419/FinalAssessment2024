// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drive;

import frc.robot.subsystems.drive.Swerve;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RunSwerve extends Command {
    private final CommandXboxController joystick;
    private final Swerve swerve;

    public RunSwerve(CommandXboxController joystick, Swerve swerve) {
        this.joystick = joystick;
        this.swerve = swerve;
        addRequirements(swerve);
    }

    @Override
    public void initialize() {
        swerve.coast();
        swerve.zeroYaw();
    }

    @Override
    public void execute() {
        swerve.setModuleStates(swerve.getChassisSpeeds(joystick.getLeftY(),joystick.getLeftX(), joystick.getRightX()));
    }

    @Override
    public void end(boolean interrupted) {
        swerve.brake();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}