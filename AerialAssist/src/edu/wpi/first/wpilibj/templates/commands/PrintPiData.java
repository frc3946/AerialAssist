/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.io.IOException;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Gustave Michel
 */
public class PrintPiData extends CommandBase {
    private double currentTime = 0;
    private double previousCheckTime = 0;
    private double checkInterum = .4;
    private double previousConnectTime = 0;
    private double connectInterum = 1;
    
    private int center;
    private int distance;
    private int errorAccum = 0;
    
    public PrintPiData() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(raspberryPi);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if(!raspberryPi.getPi().isConnected()) {
            try {
                raspberryPi.getPi().connect();
            } catch (IOException ex) {
                System.out.println("AutoAimInit: Conntecting Failed!");
            }
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
                currentTime = Timer.getFPGATimestamp();
        
        if(raspberryPi.getPi().isConnected()) {
            if(currentTime - previousCheckTime > checkInterum) {
                previousCheckTime = currentTime;
                try {
                    String rawData = raspberryPi.getPi().getRawData(); //Get Raw String Input
                    if(rawData.length() < 1) {
                        return; //Check for No Data
                    }
                    String[] tokenData = raspberryPi.getPi().tokenizeData(rawData); //Tokenize Raw Input
                    if(tokenData.length < 4) {
                        return; //Check for No Data
                    }
                    if(tokenData[0].equals("n")) {
                        return; //Check if no Image Data was Returned
                    }
                    if(raspberryPi.getPi().isNumeric(tokenData[0])){ //Attempt to Parse first value into Int
                        center = Integer.parseInt(tokenData[0]); 
                    } else {
                        center = -999;
                    }
                    if(raspberryPi.getPi().isNumeric(tokenData[3])) { //Attempt to Parse third value into Int
                        distance = Integer.parseInt(tokenData[3]);
                    } else {
                        distance = -999;
                    }
                    SmartDashboard.putNumber("Offset", center); //Print Data to SmartDashboard
                    SmartDashboard.putNumber("Distance", (double) distance/1000);
                    
                    RobotMap.offset = center;
                    RobotMap.distance = this.distance;
                    
                    errorAccum = 1;
                } catch (IOException ex) {
                    errorAccum++;
                    if(errorAccum >= 5) { //Disconnect after 5 consecutive errors
                        try {
                            raspberryPi.getPi().disconnect();
                        } catch (IOException ex1) {
                            System.out.println("AutoAimExec: Disconnecting Failed!");
                        }
                    }
                }
            }
        } else {
            if(currentTime - previousConnectTime > connectInterum) {
                previousConnectTime = currentTime;
                try {
                    raspberryPi.getPi().connect();
                } catch (IOException ex) {
                    System.out.println("AutoAimExec: Connecting Failed?");
                }
            }
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
