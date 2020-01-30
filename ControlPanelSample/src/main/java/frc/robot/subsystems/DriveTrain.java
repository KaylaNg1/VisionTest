/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;

/**
 * Add your docs here.
 */
public class DriveTrain extends SubsystemBase {
    Spark leftBackSpark = null;
    Spark leftFrontSpark = null;
    Spark rightBackSpark = null;
    Spark rightFrontSpark = null;
    public DifferentialDrive differentialDrive = null;

    public DriveTrain() {
      //sparks
      leftBackSpark = new Spark(Constants.DRIVETRAIN_LEFT_BACK_SPARK);
      leftFrontSpark =  new Spark(Constants.DRIVETRAIN_LEFT_FRONT_SPARK);
      rightBackSpark =  new Spark(Constants.DRIVETRAIN_RIGHT_BACK_SPARK);
      rightFrontSpark =  new Spark(Constants.DRIVETRAIN_RIGHT_FRONT_SPARK);
  
      SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFrontSpark, leftBackSpark);
      SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightFrontSpark, rightBackSpark);
      differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
  
    }
}
