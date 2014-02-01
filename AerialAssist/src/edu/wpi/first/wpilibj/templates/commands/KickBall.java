/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands;


import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author OpalStone
 */
    class KickBall extends CommandBase {
        static boolean retracting;
    public KickBall(){
    }
    
    protected void initialize(){
        requires(boot);
        boot.retractBall();
        setTimeout(1);
        retracting = true;
    }
    
    protected void execute(){
        if (isTimeout() == true){
            boot.kickBall();
        }
    }
    
    protected boolean isFinished(){
        return false;
    }
    
    protected void end(){
        Robot.motor1.stop();
        Robot.motor2.stop();
    }
    
    protected void interrupted(){
        end();
    }

}
