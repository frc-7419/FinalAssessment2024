package drive;

import com.kauailabs.vmx.AHRSJNI;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.Constants.SwerveConstants;
import com.kauailabs.navx.frc.AHRS;

public class DrivebaseSubsystem extends SubsystemBase {
  /** Creates a new DriveBase. */
  private final SwerveModule frontRight;
  private final SwerveModule frontLeft;
  private final SwerveModule backRight;
  private final SwerveModule backLeft;
  public final SwerveDriveOdometry odometry;
  private final AHRS ahrs;
  public DrivebaseSubsystem() {
    this.odometry = new SwerveDriveOdometry(null, null, null);
    this.ahrs = new AHRS();
    frontRight = new SwerveModule(SwerveConstants.frontRightTurnMotorID, SwerveConstants.frontRightDriveMotorID, SwerveConstants.frontRightTurnEncoderID,SwerveConstants.frontRightEncoderOffset);
    frontLeft = new SwerveModule(SwerveConstants.frontLeftTurnMotorID, SwerveConstants.frontLeftDriveMotorID, SwerveConstants.frontLeftTurnEncoderID, SwerveConstants.frontLeftEncoderOffset);
    backRight = new SwerveModule(SwerveConstants.backRightTurnMotorID, SwerveConstants.backRightDriveMotorID, SwerveConstants.backRightTurnEncoderID, SwerveConstants.backRightEncoderOffset);
    backLeft = new SwerveModule(SwerveConstants.backLeftTurnMotorID, SwerveConstants.backLeftDriveMotorID, SwerveConstants.backLeftTurnEncoderID, SwerveConstants.backLeftEncoderOffset);
    

  }

  @Override
  public void periodic() {
    
  }
  public double getPitch(){
    return ahrs.getPitch();
  }
  public void resetYaw(){
     ahrs.zeroYaw();
  }
  public void setStates(SwerveModuleState[] states){
    
  }
  public double getYaw(){
    return ahrs.getYaw();
  }
  public double getRoll(){
    return ahrs.getRoll();
  }
  public Boolean distanceReached(double distance){
    return backLeft.reachedDistanced(distance) && frontRight.reachedDistanced(distance) && backRight.reachedDistanced(distance) && frontLeft.reachedDistanced(distance);
    //why is the and && in java :(
  }
  public void resetDriveEncoders(){
    frontLeft.resetDriveEncoder();
    frontRight.resetDriveEncoder();
    backRight.resetDriveEncoder();
    backLeft.resetDriveEncoder();
  }
}