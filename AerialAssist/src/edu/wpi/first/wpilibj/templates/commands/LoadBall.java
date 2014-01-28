/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;
/**
 *
 * @author OpalStone
 */
public class LoadBall extends CommandBase {
    
    public LoadBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        //requires (catapult);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("PullInBall");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //catapult.loadBall();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
            return false;
        }

 
    protected void end() {
        //catapult.stopBall();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}