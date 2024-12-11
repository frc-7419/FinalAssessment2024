package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.HangerSubsystem;

public class HangerCommand extends Command{

    private final HangerSubsystem hangerSubsystem;
    private final XboxController ctrl;
    private double lastSetSpeed = 0;

    public HangerUsingLT(XboxController xboxController, HangerSubsystem hangerSubsystem) {
        this.hanger = hangerSubsystem;
        this.ctrl = xboxController;
        addRequirements(hangerSubsystem);
    }

  @Override
  public void initialize() {
    hanger.coast();
  }

  @Override
  public void execute() {
    double spd = ctrl.getLeftY();
    if (lastSetSpeed != spd) {
      hanger.setSpeed(spd);
      lastSetSpeed = spd;
    }
  }

  @Override
  public void end(boolean interrupted) {
    hanger.brake();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
}
