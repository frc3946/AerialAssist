/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.templates.subsystems.ClawWheels;


    // Called once after isFinished returns true
/**
 *
 * @author OpalStone
 */
public class PullInBall extends CommandBase {
    ClawWheels clawWheels = new ClawWheels();
    
    public PullInBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires (clawWheels);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("PullInBall");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        clawWheels.set(Relay.Value.kForward);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
            return false;
        }

 
    protected void end() {
        clawWheels.set(Relay.Value.kOff);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        clawWheels.set(Relay.Value.kOff);
    }
}