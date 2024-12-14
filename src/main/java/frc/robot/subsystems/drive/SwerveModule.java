package frc.robot.subsystems.drive;


import java.beans.PersistenceDelegate;
import java.math.RoundingMode;

import com.ctre.phoenix6.hardware.CANcoder;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.math.kinematics.struct.SwerveModulePositionStruct;
import frc.Constants.SwerveConstants;

public class SwerveModule {
    private final CANSparkMax turnMotor;
    private final CANSparkMax driveMotor;
    private final CANcoder turnEncoder;
    private final RelativeEncoder driveCoder;
    private final PIDController angleController;
    private final String module;



//to be frank this code is pretty chopped
//i take that back this code is horrendous but it functions so i will not be touching it.
public SwerveModule(int turnMotorId, int driveMotorId, int turnEncoderId, double turnEncoderOffset){
    this.angleController = new PIDController(SwerveConstants.anglekP, SwerveConstants.anglekI, SwerveConstants.anglekD);

    angleController.setTolerance(10.0/360.0);
    this.turnMotor = new CANSparkMax(turnMotorId, MotorType.kBrushless);
    this.driveMotor = new CANSparkMax(turnEncoderId, MotorType.kBrushless);
    this.driveCoder = driveMotor.getEncoder();
    this.turnEncoder = new CANcoder(turnEncoderId);
    this.module = "";

    
    angleController.enableContinuousInput(0, 360);
    turnEncoder.setPosition(turnEncoderOffset/360);



        }

public void coast(){
    turnMotor.setIdleMode(IdleMode.kCoast);



    driveMotor.setIdleMode(IdleMode.kCoast);
}
public void brake(){
    turnMotor.setIdleMode(IdleMode.kBrake);
    driveMotor.setIdleMode(IdleMode.kBrake);
    turnMotor.setVoltage(0);
    driveMotor.setVoltage(0);
}
public void setPower(double power){
    turnMotor.setVoltage(power);
    driveMotor.setVoltage(power);
    
    


}
public void setModuleState(SwerveModuleState state){
    double speed = state.speedMetersPerSecond;
    angleController.setSetpoint(state.angle.getDegrees());
    driveMotor.set(speed);
    angleController.calculate(state.angle.getDegrees());






}
public SwerveModuleState getSwerveModuleState(){
    return new SwerveModuleState(driveCoder.getVelocity(), Rotation2d.fromDegrees(turnEncoder.getPosition().getValueAsDouble()));
}
public  SwerveModulePosition getPosition(){
    return new SwerveModulePosition(driveCoder.getPosition(), Rotation2d.fromDegrees(turnEncoder.getPosition().getValueAsDouble()));

}
public void resetDriveEncoder(){
    driveCoder.setPosition(0);

}
public double getDriveEncoderPosition(){
    return driveCoder.getPosition();




}
public Boolean reachedDistanced(double meters){
    return driveCoder.getPosition() >= meters;

}
public void setState(SwerveModuleState moduleState, Rotation2d rotation){
    SwerveModuleState newModuleState = SwerveModuleState.optimize(moduleState, rotation);
     
    }



  
   
}
