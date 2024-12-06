// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveModule extends SubsystemBase {
  /** Creates a new SwerveModule. */
  private final TalonFX turnMotor;
  private final TalonFX moveMotor;
  private final PIDController anglePID;
  private final Cancoder cancoder;

  public SwerveModule(TalonFX TurnMotor, TalonFx MoveMotor) {
    this.turnMotor = TurnMotor;
    this.moveMotor = MoveMotor;
    encoder = new CANcoder(10);
    anglePID = new PIDController(0,0,0);
  }
  public void coast(){
    turnMotor.setNeutralMode(NeutralModeValue.coast);
    moveMotor.setNeutralMode(NeutralModeValue.coast);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
