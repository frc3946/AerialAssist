/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.subsystems.ClawWheels;

/**
 *
 * @author 10374778
 */
public class PullInWheels {
    
      protected void initialize() {
        //if the frisbee wheels are stopped
        //then we need some warmup time before
        //next command is allowed to run
        SmartDashboard.putBoolean("Pull Wheels", ClawWheels.isRunning());
        if(!ClawWheels.isRunning()) {
            setTimeout(4.5);
        } else {
            setTimeout(0);
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        ClawWheels.set(0.47, 1.00);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
