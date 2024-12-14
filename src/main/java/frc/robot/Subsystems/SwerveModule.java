// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveModule extends SubsystemBase {
  /** Creates a new SwerveModule. */
  private final TalonFX turnMotor;
  private final TalonFX moveMotor;
  private final PIDController anglePID;
  private final CANcoder cancoder;
  double angleOffset;

  public SwerveModule(TalonFX TurnMotor, TalonFX MoveMotor, double angleOffset) {
    this.turnMotor = TurnMotor;
    this.moveMotor = MoveMotor;
    this.angleOffset = angleOffset;
    this.cancoder = new CANcoder(10);
    this.anglePID = new PIDController(0,0,0);

  }
  public void coast(){
    turnMotor.setNeutralMode(NeutralModeValue.Coast);
    moveMotor.setNeutralMode(NeutralModeValue.Coast);
  }
  public void brake(){
    turnMotor.setNeutralMode(NeutralModeValue.Brake);
    moveMotor.setNeutralMode(NeutralModeValue.Brake);
  }
  public double getPos(){
    return cancoder.getPosition().getValueAsDouble();
  }
  public void setSwerveModuleState(SwerveModuleState state){
      double adjustedAngle =state.angle.getDegrees() - angleOffset;
      moveMotor.set(state.speedMetersPerSecond); 
      turnMotor.set(anglePID.calculate(getPos(), adjustedAngle));

  }


  @Override
  public void periodic() {
    SmartDashboard.putNumber("Motor Speed: ", turnMotor.get());
    SmartDashboard.putNumber("Motor Angle: ", getPos());
    // This method will be called once per scheduler run
  }
}
