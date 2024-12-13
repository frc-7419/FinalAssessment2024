package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.Pigeon2;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;;

public class DriveBaseSubsystem extends SubsystemBase {
  private final SwerveModule frontLeftDriveModule;
  private final SwerveModule frontRightDriveModule;
  private final SwerveModule backLeftDriveModule;
  private final SwerveModule backRightDriveModule;
  private final Pigeon2 gyro;
  private final SwerveDriveKinematics kinematics;

  public DriveBaseSubsystem() {
    frontLeftDriveModule = new SwerveModule(new TalonFX(9), new TalonFX(10));
    frontRightDriveModule = new SwerveModule(new TalonFX(11), new TalonFX(12));
    backLeftDriveModule = new SwerveModule(new TalonFX(13), new TalonFX(14));
    backRightDriveModule = new SwerveModule(new TalonFX(15), new TalonFX(16));
    gyro = new Pigeon2(17);

    kinematics = new SwerveDriveKinematics(
        new Translation2d(),
        new Translation2d(),
        new Translation2d(),
        new Translation2d());
  }

  public void setSwerveUsingJoystick(double velocityX, double velocityY, double rotationX) {
    setChassisSpeed(ChassisSpeeds.fromFieldRelativeSpeeds(velocityX, velocityY, rotationX, gyro.getRotation2d()));
  }

  public void setChassisSpeed(ChassisSpeeds chassisSpeeds) {
    SwerveModuleState[] states = kinematics.toSwerveModuleStates(chassisSpeeds);
    setSwerveStates(states);
  }

  public void setSwerveStates(SwerveModuleState[] states) {
    frontLeftDriveModule.setSwerveState(states[0]);
    frontRightDriveModule.setSwerveState(states[1]);
    backLeftDriveModule.setSwerveState(states[2]);
    backRightDriveModule.setSwerveState(states[3]);
  }

  public void coast() {
    frontLeftDriveModule.coast();
    frontRightDriveModule.coast();
    backLeftDriveModule.coast();
    backRightDriveModule.coast();
  }

  public void brake() {
    frontLeftDriveModule.brake();
    frontRightDriveModule.brake();
    backLeftDriveModule.brake();
    backRightDriveModule.brake();
  }

  public void resetGyro(double offset) {
    gyro.setYaw(offset);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Swerve Front Left Module Speed", frontLeftDriveModule.getSpeed());
    SmartDashboard.putNumber("Swerve Front Right Module Speed", frontRightDriveModule.getSpeed());
    SmartDashboard.putNumber("Swerve Back Left Module Speed", backLeftDriveModule.getSpeed());
    SmartDashboard.putNumber("Swerve Back Right Module Speed", backRightDriveModule.getSpeed());
    SmartDashboard.putNumber("Swerve Front Left Module Angle", frontLeftDriveModule.getAngle());
    SmartDashboard.putNumber("Swerve Front Right Module Angle", frontRightDriveModule.getAngle());
    SmartDashboard.putNumber("Swerve Back Left Module Angle", backLeftDriveModule.getAngle());
    SmartDashboard.putNumber("Swerve Back Right Module Angle", backRightDriveModule.getAngle());
  }
}
