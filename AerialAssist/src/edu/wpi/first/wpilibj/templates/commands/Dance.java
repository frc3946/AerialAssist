/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author nrladmin
 */
public class Dance extends CommandBase {
    double timeOut;
    public Dance(double timeout) {
        // Use requires() here to declare subsystem dependencies
        requires(driveTrain);
        setTimeout(timeout);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    //Wobble
    protected void execute() {
        for(int i = 90; i <= 450; i++) {
            driveTrain.mecanumDrive(Math.cos(i + 90), Math.sin(i + 90), -0.3, gyro.getAngle());
        }
    }

    // Make this return true when this Command no longer needs to run execute
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
