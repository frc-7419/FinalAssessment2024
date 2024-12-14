// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.wrist;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.units.Units;

public class SetWristToSetpoint extends Command {
  /** Creates a new SetWristToSetpoint. */
  private final WristSubsystem wristSubsystem;
  private final PIDController wristPIDController = new PIDController(12, 0, 0.25);
  private final ArmFeedforward ff = new ArmFeedforward(0, 1, 0);
  
  public SetWristToSetpoint(WristSubsystem wristSubsystem, double setpoint) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.wristSubsystem = wristSubsystem;
    addRequirements(wristSubsystem);
    
    wristPIDController.setSetpoint(setpoint);
    wristPIDController.setTolerance(2.0/360);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    wristSubsystem.coast();
    

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double ffPower = ff.calculate(wristSubsystem.getPositionInRadians(), 0);
    double pidPower = wristPIDController.calculate(wristSubsystem.getPosition());
    wristSubsystem.setVoltage(pidPower + ffPower);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    wristSubsystem.setVoltage(ff.calculate(wristSubsystem.getPositionInRadians(), 0));
    wristSubsystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return wristPIDController.atSetpoint();
  }
}
