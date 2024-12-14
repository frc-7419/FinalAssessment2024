// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.pathplanner.lib.commands.PathPlannerAuto;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.RunHandoff;
import frc.robot.commands.RunIntake;
import frc.robot.commands.RunJoystickHandoffIntake;
import frc.robot.commands.RunJoystickHanger;
import frc.robot.commands.RunJoystickShooter;
import frc.robot.commands.RunSwerve;
import frc.robot.subsystems.HandoffSubsystem;
import frc.robot.subsystems.HangerSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.SwerveBase;

public class RobotContainer {

    private final SwerveBase swerveBase = new SwerveBase();
    private final ShooterSubsystem shooter = new ShooterSubsystem();
    private final HandoffSubsystem handoff = new HandoffSubsystem();
    private final IntakeSubsystem intake = new IntakeSubsystem();
    private final HangerSubsystem hanger = new HangerSubsystem();
    private final XboxController operatorController = new XboxController(1);
    private final CommandXboxController driverController = new CommandXboxController(2);

    private final RunJoystickShooter runJoystickShooter = new RunJoystickShooter(
            shooter,
            operatorController);
    private final RunSwerve runSwerveDrive = new RunSwerve(
            swerveBase,
            driverController);
    private final RunJoystickHandoffIntake runJoystickIntakeHandoff = new RunJoystickHandoffIntake(handoff, intake,
            operatorController);
    private final RunJoystickHanger runJoystickHanger = new RunJoystickHanger(
            hanger,
            operatorController);

    private final PathPlannerAuto threeNoteAuton = new PathPlannerAuto(
            "Three Note Auton");

    private final RunHandoff runHandoff = new RunHandoff(handoff);
    private final RunJoystickShooter runShooter = new RunJoystickShooter(
            shooter,
            operatorController);
    private final RunIntake runIntake = new RunIntake(intake);

    public RobotContainer() {
        configureBindings();
        configureNamedCommands();
        setDefaultCommand();
    }

    private void configureBindings() {
    }

    public Command getAutonomousCommand() {
        return twoNoteAuton;
      }
    private void configureNamedCommands(){
        NamedCommands.registerCommand("RunShooter",runShooter);
        NamedCommands.registerCommand("RunHandoff",runHandoff);
        NamedCommands.registerCommand("RunIntake",runIntake);
        NamedCommands.registerCommand("RunHangerUp",runHangerUp);
        NamedCommands.registerCommand("RunHangerDown",runHangerDown);
    }
    private void setDefaultCommand(){
        swerveBase.setDefaultCommand(runSwerveDrive);
    }
}
