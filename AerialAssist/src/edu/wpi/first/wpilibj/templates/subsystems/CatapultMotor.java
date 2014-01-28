/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.StopCatapult;

/**
 *
 * @author Caden
 */public class CatapultMotor extends Subsystem{
//    Talon catapultMotor = new Talon(RobotMap.catapult);            
    private double speed;
    
    protected void initDefaultCommand() {
        setDefaultCommand(new StopCatapult());
    }
    
    public void launchBall() {
//        catapultMotor.set(speed);
    }
    public void loadBall(){
//        catapultMotor.set(-speed);
    }
    public void stopBall(){
//        catapultMotor.stopMotor();
    }
}


