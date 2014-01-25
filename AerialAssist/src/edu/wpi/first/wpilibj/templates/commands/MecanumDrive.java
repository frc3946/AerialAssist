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
        //todo:   COMPLETE?
        //here we already have to access the io object. 
        //read the up/down and left/right from io.
        //then pass those values to the mecanum drive funtion. 
        //remember you'll need to read both the left and right triggers
        //I would just add them to gether to get a final rotation value
        //make one negative for a counter clockwise rotation
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
