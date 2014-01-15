/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.subsystems.ClawPiston;


/**
 *
 * @author OpalStone
 */
public class EjectBall extends CommandBase {
    ClawPiston clawPiston = new ClawPiston();
    public EjectBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires (clawPiston);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        clawPiston.extend();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        clawPiston.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}