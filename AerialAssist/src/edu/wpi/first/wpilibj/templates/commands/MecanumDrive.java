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
        driveTrain.mecanumDrive(GenericHID.Hand.kLeft, Joystick.AxisType.kThrottle);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
   
    
}
