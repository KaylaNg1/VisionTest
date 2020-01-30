/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.lang.module.ModuleDescriptor.Requires;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

/**
 * Add your docs here.
 */
public class DriveArcade extends CommandBase {
    public DriveArcade() {
        requires(Robot.m_drivetrain);
    }

    private void requires(DriveTrain m_drivetrain) {
    }

    public void initialize() {

    }

    public void execute() {
        Robot.m_drivetrain.differentialDrive.arcadeDrive(Robot.m_robotContainer.driverController.getRawAxis(1),
                Robot.m_robotContainer.driverController.getRawAxis(0));
    }

    public boolean isFinished() {
        return false;
    }

    protected void end(){

    }

    protected void interrupted(){

    }
}
