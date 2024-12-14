package frc.robot.subsystems.drive;


import com.ctre.phoenix6.hardware.CANcoder;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.Constants.SwerveConstants;

public class SwerveModule extends SubsystemBase {
    private final CANSparkMax turnMotor;
    private final CANSparkMax driveMotor;
    private final CANcoder turnEncoder;
    private final RelativeEncoder driveCoder;
    private final PIDController angleController;
    private final String module;
    private final double MAX_VOLTS = 12.0;


//to be frank this code is pretty chopped
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
public double getDegrees(){
    return turnEncoder.getPosition().getValueAsDouble();
}
public void drive(double power){
    driveMotor.set(power);
    double setpoint = turnEncoder.getPosition().getValueAsDouble() * (MAX_VOLTS * 0.5) + (MAX_VOLTS * 0.5); // Optimization offset can be calculated here.
    if (setpoint < 0) {
        setpoint = MAX_VOLTS + setpoint;
    }
    if (setpoint > MAX_VOLTS) {
        setpoint = setpoint - MAX_VOLTS;
    }

    angleController.setSetpoint (setpoint);
    
    driveMotor.setVoltage(power);
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
public void setState(SwerveModuleState state){
    double speed = state.speedMetersPerSecond;
    angleController.setSetpoint(state.angle.getDegrees());
    driveMotor.set(speed);
    angleController.calculate(state.angle.getDegrees());






}
public double getAngle(){
    return turnEncoder.getPosition().getValueAsDouble();
}
public double getSpeed(){
    return driveCoder.getVelocity();
}
@Override
public void periodic() {
    SmartDashboard.putNumber("Angle", turnEncoder.getPosition().getValueAsDouble());
    SmartDashboard.putNumber("Speed", driveCoder.getVelocity());

}




  
   
}
