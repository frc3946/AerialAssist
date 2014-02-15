/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.templates.CodeMonitor;

/**
 *
 * @author AJ
 */
public class AdjustSpeed extends CommandBase {
    boolean aValue;
    boolean bValue;
    boolean xValue;
    boolean yValue;
    int state;
    
    public AdjustSpeed() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        aValue = oi.getXbox().getAButton();
        bValue = oi.getXbox().getBButton();
        xValue = oi.getXbox().getXButton();
        yValue = oi.getXbox().getYButton();
        setTimeout(.08);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(aValue && isTimedOut()){
            state++;
        }
        if(yValue && isTimedOut()){
            state--;
        }
        if (state < 0){
            state = 0;
        }else if (state > 5){
            state = 5;
        }
        if(xValue && isTimedOut()){
            KickBall.sequence[0][state] -= 0.05;
        }
        if(bValue && isTimedOut()){
            KickBall.sequence[0][state] += 0.05;
        }
        if(KickBall.sequence[0][state] < -1) {
            KickBall.sequence[0][state] = -1;
        }
        if(KickBall.sequence[0][state] > 1) {
            KickBall.sequence[0][state]= 1;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(isTimedOut()){
            return true;
        } else {
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        SmartDashboard.putNumber(String.valueOf(state), KickBall.sequence[0][state]);
        System.out.println("Speed adjusted on " + state + " to " + KickBall.sequence[0][state]);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
