// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */
  private final TalonFX topMotor;
  private final TalonFX bottomMotor;

  public ShooterSubsystem() {
    this.topMotor = new TalonFX(5);
    this.bottomMotor = new TalonFX(6);
  }
  public void coast(){
    topMotor.setNeutralMode(NeutralModeValue.Coast);
    bottomMotor.setNeutralMode(NeutralModeValue.Coast);
  }
  public void run(double power){
    topMotor.set(power);
    bottomMotor.set(power);
  }
  public void brake(){
    topMotor.setNeutralMode(NeutralModeValue.Brake);
    bottomMotor.setNeutralMode(NeutralModeValue.Brake);    
  }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Shooter: Top Motor Voltage", topMotor.getMotorVoltage().getValueAsDouble());
    SmartDashboard.putNumber("Shooter: Bottom Motor Voltage", bottomMotor.getMotorVoltage().getValueAsDouble());
    SmartDashboard.putNumber("Shooter: Top Motor Temp", topMotor.getDeviceTemp().getValueAsDouble());
    SmartDashboard.putNumber("Shooter: Bottom Motor Temp", bottomMotor.getDeviceTemp().getValueAsDouble());
    // This method will be called once per scheduler run
  }
}
