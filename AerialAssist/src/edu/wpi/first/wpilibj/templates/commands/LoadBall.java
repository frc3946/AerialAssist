/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.templates.subsystems.CatapultMotor;


    // Called once after isFinished returns true
/**
 *
 * @author OpalStone
 */
public class LoadBall extends CommandBase {
    CatapultMotor catapult = new CatapultMotor();
    
    public LoadBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires (catapult);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("PullInBall");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        catapult.set(Relay.Value.kForward);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
            return false;
        }

 
    protected void end() {
        catapult.set(Relay.Value.kOff);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        catapult.set(Relay.Value.kOff);
    }
}