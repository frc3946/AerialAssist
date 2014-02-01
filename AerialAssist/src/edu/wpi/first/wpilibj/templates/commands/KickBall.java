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
    class KickBall extends Command {
        
    public KickBall(){
    }
    
    protected void initialize(){
        Robot.motor1.kickBall();
        Robot.motor2.kickBall();
        end();
    }
    
    protected void execute(){
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
