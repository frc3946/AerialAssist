/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author AJ
 */
public class AdjustTime extends CommandBase {
    
    boolean aValue;
    boolean bValue;
    boolean xValue;
    boolean yValue;
    int state;
    
    public AdjustTime() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        aValue = !oi.getXbox().getAButton();
        bValue = !oi.getXbox().getBButton();
        xValue = !oi.getXbox().getXButton();
        yValue = !oi.getXbox().getYButton();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(aValue){
            state++;
        }else if(yValue){
            state--;
        }
        if (state < 0){
            state = 0;
        }else if (state > 5){
            state = 5;
        }
        if(xValue){
            KickBall.sequence[1][state] -= 0.05;
        }else if(bValue){
            KickBall.sequence[1][state] += 0.05;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        SmartDashboard.putNumber(String.valueOf(state), KickBall.sequence[1][state]);
        System.out.println("Time adjusted on" + state + " to " + KickBall.sequence[1][state]);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
