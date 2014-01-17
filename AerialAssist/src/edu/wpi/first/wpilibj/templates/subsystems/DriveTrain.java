/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author AJ
 */
public class DriveTrain extends Subsystem {

    private Talon frontLeft = new Talon(RobotMap.fLeft);
    private Talon frontRight = new Talon(RobotMap.fRight);
    private Talon backLeft = new Talon(RobotMap.bLeft);
    private Talon backRight = new Talon(RobotMap.bRight);
    private RobotDrive drive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
    
    protected void initDefaultCommand() {
       
    }
    
    public void mecanumDrive(GenericHID move, Joystick.AxisType rotate) {
        
        drive.mecanumDrive_Cartesian(move.getX(), move.getY(), rotate.value, 0);
        frontLeft.set(10);
        
        
        
    }
}
