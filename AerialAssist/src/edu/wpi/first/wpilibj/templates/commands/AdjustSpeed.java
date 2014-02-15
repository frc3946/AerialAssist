/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.OI;

/**
 *
 * @author AJ
 */
public class AdjustSpeed extends CommandBase {
    
    boolean aValue;
    boolean bValue;
    boolean xValue;
    boolean yValue;
    OI OI = new OI();
    int state;
    
    public AdjustSpeed() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        aValue = !OI.getXbox().getAButton();
        bValue = !OI.getXbox().getBButton();
        xValue = !OI.getXbox().getXButton();
        yValue = !OI.getXbox().getYButton();
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
            KickBall.sequence[0][state] -= 0.05;
        }else if(bValue){
            KickBall.sequence[0][state] += 0.05;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("Speed adjusted on" + state + " to " + KickBall.sequence[0][state]);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
