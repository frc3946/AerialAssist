/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author OpalStone
 */
    class HammerForward extends CommandBase {
        
    public HammerForward(){
        requires(boot);
    }
    
    protected void initialize(){
        
    }
    
    protected void execute(){
        boot.kickBall();
    }
    
    protected boolean isFinished(){
        return false;
    }
    
    protected void end(){
    }
    
    protected void interrupted(){
        end();
    }

}
