// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkFlexConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeAndHandoffSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  SparkFlex intake1, intake2, top, bottom; //set function sets speed
  SparkFlex[] motors;
  public IntakeAndHandoffSubsystem() {
    intake1 = new SparkFlex(13, SparkLowLevel.MotorType.kBrushless);
    intake2 = new SparkFlex(14, SparkLowLevel.MotorType.kBrushless);
    top = new SparkFlex(15, SparkLowLevel.MotorType.kBrushless);
    bottom = new SparkFlex(16, SparkLowLevel.MotorType.kBrushless);
    SparkFlex[] temp = {intake1, intake2, top, bottom};
    motors = temp;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void coast() {
    for (SparkFlex i : motors) {i.configure(new SparkFlexConfig().idleMode(IdleMode.kCoast), ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);}
  }
  public void brake() {
    for (SparkFlex i : motors) {i.configure(new SparkFlexConfig().idleMode(IdleMode.kBrake), ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);}
  }
  public void setSpeed(double speed) {
    for (SparkFlex i : motors) {
      if (i != bottom) {
        i.set(speed);
      } else {
        i.set(-speed);
      }
    }
  }
}
