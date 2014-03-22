/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

//import edu.wpi.first.wpilibj.templates.CodeMonitor;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.templates.RobotTemplate;


/**
 *
 * @author nrladmin
 */
public class AutoDrive extends CommandBase {
    double timeOut;
    public AutoDrive(double timeout) {
        // Use requires() here to declare subsystem dependencies
        requires(driveTrain);
        setTimeout(timeout);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//        CodeMonitor.CodeButtonUpdate(null);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        driveTrain.mecanumDrive(-1, 0, 0, (gyro.getAngle()- (RobotTemplate.gyroOff * Timer.getFPGATimestamp())));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(isTimedOut()) {
            return false;
        } else {
            return true;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
