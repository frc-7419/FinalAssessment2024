package frc.robot.subsystems.drive;

import com.kauailabs.vmx.AHRSJNI;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.Constants;
import frc.Constants.SwerveConstants;

import com.ctre.phoenix6.hardware.Pigeon2;
import com.kauailabs.navx.frc.AHRS;

public class DrivebaseSubsytem extends SubsystemBase {
  /** Creates a new DriveBase. */
  private final SwerveModule frontRight;
  private final SwerveModule frontLeft;
  private final SwerveModule backRight;
  private final SwerveModule backLeft;
  public final SwerveDriveOdometry odometry;
  private final AHRS ahrs;
  private final Pigeon2 pigeonGyro;
  public double maxVoltage = 12.0;
  public DrivebaseSubsytem() {
    this.odometry = new SwerveDriveOdometry(null, null, null);
    this.ahrs = new AHRS();//prolly not needed but eh
    frontRight = new SwerveModule(SwerveConstants.frontRightTurnMotorID, SwerveConstants.frontRightDriveMotorID, SwerveConstants.frontRightTurnEncoderID,SwerveConstants.frontRightEncoderOffset);
    frontLeft = new SwerveModule(SwerveConstants.frontLeftTurnMotorID, SwerveConstants.frontLeftDriveMotorID, SwerveConstants.frontLeftTurnEncoderID, SwerveConstants.frontLeftEncoderOffset);
    backRight = new SwerveModule(SwerveConstants.backRightTurnMotorID, SwerveConstants.backRightDriveMotorID, SwerveConstants.backRightTurnEncoderID, SwerveConstants.backRightEncoderOffset);
    backLeft = new SwerveModule(SwerveConstants.backLeftTurnMotorID, SwerveConstants.backLeftDriveMotorID, SwerveConstants.backLeftTurnEncoderID, SwerveConstants.backLeftEncoderOffset);
    pigeonGyro = new Pigeon2(Constants.canIDConstants.pigeonGyroID);

  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Front Left Speed", frontLeft.getSpeed());
    SmartDashboard.putNumber("Front Right Speed", frontRight.getSpeed());
    SmartDashboard.putNumber("Back Left Speed", backLeft.getSpeed());
    SmartDashboard.putNumber("Back Right Speed", backRight.getSpeed());
    SmartDashboard.putNumber("Front Left Angle", frontLeft.getAngle());
    SmartDashboard.putNumber("Front Right Angle", frontRight.getAngle());
    SmartDashboard.putNumber("Back Left Angle", backLeft.getAngle()); 
    SmartDashboard.putNumber("Back Right Angle", backRight.getAngle()); 
  }
  //i dont know if i need ahrs here i just remembered it from my old code
  
  public double getPitch(){
    return ahrs.getPitch();
  }
  public void resetYaw(){
     ahrs.zeroYaw();
  }
  public Boolean distanceReached(double distance){
    return backLeft.reachedDistanced(distance) && frontRight.reachedDistanced(distance) && backRight.reachedDistanced(distance) && frontLeft.reachedDistanced(distance);
    //why is the and && in java :(
  }
  public void setSwerveModuleStates(SwerveModuleState frontLeftState, SwerveModuleState frontRightState, SwerveModuleState backRightState, SwerveModuleState backLeftState){
    frontLeft.setState(frontLeftState);
    frontRight.setState(frontRightState);
    backRight.setState(backRightState);
    backLeft.setState(backLeftState);
  }
  public void joystickControl(double x1, double y1, double x2){
    double r = Math.sqrt ((Constants.robotLength * Constants.robotLength) + (Constants.robotWidth * Constants.robotWidth));
    double a = x1 - x2 * (Constants.robotLength / r);
    double b = x1 + x2 * (Constants.robotLength / r);
    double c = y1 - x2 * (Constants.robotWidth / r);
    double d = y1 + x2 * (Constants.robotWidth / r);

    double backRightSpeed = Math.sqrt ((a * a) + (d * d));
    double backLeftSpeed = Math.sqrt ((a * a) + (c * c));
    double frontRightSpeed = Math.sqrt ((b * b) + (d * d));
    double frontLeftSpeed = Math.sqrt ((b * b) + (c * c));

    double backRightAngle = Math.atan2 (a, d) / Math.PI;
    double backLeftAngle = Math.atan2 (a, c) / Math.PI;
    double frontRightAngle = Math.atan2 (b, d) / Math.PI;
    double frontLeftAngle = Math.atan2 (b, c) / Math.PI;
  }
  public void drive(){
    frontLeft.drive(frontLeft.getSpeed());
    frontRight.drive(frontRight.getSpeed());
    backRight.drive(backRight.getSpeed());
    backLeft.drive(backLeft.getSpeed());
  }
  public void resetDriveEncoders(){
    frontLeft.resetDriveEncoder();
    frontRight.resetDriveEncoder();
    backRight.resetDriveEncoder();
    backLeft.resetDriveEncoder();
  }
  public void coast(){
    frontLeft.coast();
    frontRight.coast();
    backRight.coast();
    backLeft.coast();
  }
  public void brake(){
    frontLeft.brake();
    frontRight.brake();
    backRight.brake();
    backLeft.brake();
  }
  public void setPower(double power){
    frontLeft.setPower(power);
    frontRight.setPower(power);
    backRight.setPower(power);
    backLeft.setPower(power);
  }
}