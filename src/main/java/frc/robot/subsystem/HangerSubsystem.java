// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystem;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class HangerSubsystem extends SubsystemBase {
  private final TalonFX hangingMotor;
  /** Creates a new HangerSubsystem. */
  public HangerSubsystem() {
    this.hangingMotor = new TalonFX(4);
  }

  public void runHanger(double power){
    hangingMotor.set(power);
  }

    public void brake(){
      hangingMotor.setNeutralMode(NeutralModeValue.Brake);
  }
  public void coast(){
    hangingMotor.setNeutralMode(NeutralModeValue.Coast);

  }

  @Override
  public void periodic() {
        SmartDashboard.putNumber("Hanging Motor Voltage", hangingMotor.getMotorVoltage().getValue());
        SmartDashboard.putNumber("Hanging Motor Position", hangingMotor.getPosition().getValue());
        SmartDashboard.putNumber("Hanging Motor Temperature", hangingMotor.getDeviceTemp().getValue());
    // This method will be called once per scheduler run
  }
}
