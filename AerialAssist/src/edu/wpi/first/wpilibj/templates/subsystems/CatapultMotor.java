/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.StopCatapult;

/**
 *
 * @author Caden
 */public class CatapultMotor extends Subsystem{
    Talon catapultMotor = new Talon(RobotMap.catapult);            
    private double speed;
       
    public void launchBall() {
        catapultMotor.set(speed);
    }
    public void loadBall(){
        catapultMotor.set(-speed);
    }
    public void stopBall(){
        catapultMotor.stopMotor();
    }

    protected void initDefaultCommand() {
        new StopCatapult();
    }
}


