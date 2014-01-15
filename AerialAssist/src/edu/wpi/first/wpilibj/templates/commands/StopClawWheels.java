/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.templates.subsystems.ClawWheels;
/**
 *
 * @author OpalStone
 */
public class StopClawWheels extends CommandBase {
    
    int timeout;
    ClawWheels clawWheels = new ClawWheels();
   
    public StopClawWheels(int newTimeout) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(clawWheels);
        timeout = newTimeout;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        clawWheels.set(Relay.Value.kOff);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        System.out.println("StopClawWheels interrupted");
    }
}