/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AJ
 */


public class testDrive extends CommandBase {

    int currMotor;

    public testDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(2);
        currMotor = 1;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        switch (currMotor) {
            case 1:
                driveTrain.frontLeft.set(.5);
            case 2:
                driveTrain.backLeft.set(.5);
            case 3:
                driveTrain.frontRight.set(-.5);
            case 4:
                driveTrain.backRight.set(-.5);
        }
        if (isTimedOut()) {
            currMotor++;
            setTimeout(2);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (currMotor == 5) {
            return true;
        } else {
            return false;
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