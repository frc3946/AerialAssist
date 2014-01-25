/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author AJ
 */
public class MecanumDrive extends CommandBase {

    public MecanumDrive() {
        requires(driveTrain);
    }
    protected void initialize() {
    }

    protected void execute() {
       
        //here we already have to access the io object. 
        //read the up/down and left/right from io.
        //then pass those values to the mecanum drive function. 
        driveTrain.mecanumDrive(oi.getXbox().getX(GenericHID.Hand.kLeft),
                                oi.getXbox().getY(GenericHID.Hand.kLeft),
                                oi.getXbox().getThrottle());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
   
    
}
