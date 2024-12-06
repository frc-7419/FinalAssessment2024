// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */
  private final TalonFX
  private final TalonFX bottomMotor;

  public ShooterSubsystem() {
    this.topMotor = new TalonFX(0);
    this.bottomMotor = new TalonFX(1);
  }
  public void coast(){
    topMotor.setNeutralMode(NeutralMode.coast);
    bottomMotor.setNeutralMode(NeutralMode.coast);
  }
  public void runShooter(double power){
    topMotor.set(power);
    bottomMotor.set(power);
  }
  public void brake(){
    topMotor.setNeutralMode(NeutralMode.brake);
    bottomMotor.setNeutralMode(NeutralMode.brake);    
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
