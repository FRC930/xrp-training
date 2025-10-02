// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;

public class SetAngleCommand extends Command {

    private Arm m_arm;
    private double m_angle;
    public SetAngleCommand(double angle, Arm arm) {
      m_arm = arm;
      m_angle = angle;
    addRequirements(arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_arm.setAngle(m_angle);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

}
