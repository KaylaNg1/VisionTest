/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


package frc.robot.subsystems;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Talon;
import frc.robot.subsystems.DriveTrain;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;
/**
 * Add your docs here.
 */
public class ColorSpin extends CommandBase {

    private final I2C.Port i2cPort = I2C.Port.kOnboard;
    
    private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
    private final ColorMatch m_colorMatcher = new ColorMatch();

    private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
    private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
    private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
    private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

    String colorString;
    Color colorTarget= ColorMatch.makeColor(0,0,0);

    Color detectedColor = m_colorSensor.getColor();

        /**
         * Run the color match algorithm on our detected color
         * Detects the first color
         */
        ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
    

    
    public void periodic(){
       
        
    
        if (match.color == kBlueTarget) {
          colorString = "Blue";
        } else if (match.color == kRedTarget) {
          colorString = "Red";
        } else if (match.color == kGreenTarget) {
          colorString = "Green";
        } else if (match.color == kYellowTarget) {
          colorString = "Yellow";
        } else {
          colorString = "Unknown";
        }
        SmartDashboard.putNumber("Red", detectedColor.red);
        SmartDashboard.putNumber("Green", detectedColor.green);
        SmartDashboard.putNumber("Blue", detectedColor.blue);
        SmartDashboard.putNumber("Confidence", match.confidence);
        SmartDashboard.putString("Detected Color", colorString);
        // example lets say we got green as the closest color in front of us
        if (colorString=="Blue"){
            colorTarget=kBlueTarget;
        }
        else if(colorString=="Red"){
            colorTarget=kRedTarget;
        }
        else if(colorString=="Green"){
            colorTarget=kGreenTarget;
        }
        else if(colorString=="Yellow"){
            colorTarget=kYellowTarget;
        }
        
    }

    
    public void teleopPeriodic(){
          
        Color detectedColor = m_colorSensor.getColor();
        int counter=8;

        /**
         * Run the color match algorithm on our detected color 7-11 times
         */
        ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
         if ( match.color== detectedColor) {
           counter--;

        }
        SmartDashboard.putNumber("Red", detectedColor.red);
        SmartDashboard.putNumber("Green", detectedColor.green);
        SmartDashboard.putNumber("Blue", detectedColor.blue);
        SmartDashboard.putNumber("Confidence", match.confidence);
        SmartDashboard.putString("Detected Color", colorString);
    }




}
