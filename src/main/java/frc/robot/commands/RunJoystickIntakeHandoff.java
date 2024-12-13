// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.HandoffSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class RunJoystickIntakeHandoff extends Command {
    private final HandoffSubsystem handoff;
    private final IntakeSubsystem intake;
    private final XboxController controller;

    public RunJoystickIntakeHandoff(HandoffSubsystem handoffSubsystem, IntakeSubsystem intakeSubsystem, XboxController ctrl) {
        this.handoff = handoffSubsystem;
        this.controller = ctrl;
        this.intake = intakeSubsystem;
        addRequirements(handoff, intake);
    }

    @Override
    public void initialize() {
        handoff.coast();
        intake.coast();
    }

    @Override
    public void execute() {
        intake.setSpeed(controller.getRightY());
        handoff.setSpeed(controller.getRightY());
    }

    @Override
    public void end(boolean interrupted) {
        handoff.brake();
        intake.brake();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}