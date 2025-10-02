// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;

public class ArmDefaultCommand extends Command {
  
    private Arm m_arm;
    public ArmDefaultCommand(Arm arm) {
      m_arm = arm;
    addRequirements(arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_arm.setAngle(90.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

}
