// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  private TalonFX backRight;
  private TalonFX backLeft;
  private TalonFX frontRight;
  private TalonFX frontLeft;
  public IntakeSubsystem() {
    backRight = new TalonFX(TalonFX(1), TalonFX(2));
    backLeft = new TalonFX(TalonFX(3), TalonFX(4));
    frontRight = new TalonFX(TalonFX(5), TalonFX(6));
    frontLeft = new TalonFX(TalonFX(7), TalonFX(8));
    gyro = new Pigeon2()
  }

  public void coastSwerve(){

  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
