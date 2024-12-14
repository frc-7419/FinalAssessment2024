// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.HandoffSubsystem;

public class RunHandoff extends Command {

    private final HandoffSubsystem handoff;

    public RunHandoff(HandoffSubsystem handOffSubsystem) {
        this.handoff = handOffSubsystem;
        addRequirements(handoff);
    }

    @Override
    public void initialize() {
        handoff.coast();
    }

    @Override
    public void execute() {
        handoff.setSpeed(1);
    }

    @Override
    public void end(boolean interrupted) {
        handoff.brake();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
