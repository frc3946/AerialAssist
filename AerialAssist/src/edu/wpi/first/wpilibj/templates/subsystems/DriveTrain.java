/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.MecanumDrive;

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
    private Gyro gyro = new Gyro(RobotMap.gyro);
    OI oi = new OI();
    
    protected void initDefaultCommand() {
        MecanumDrive mecanumDrive = new MecanumDrive();
                                  
                             
      
    }
    
    private double angle = gyro.getAngle();
           
    public void mecanumDrive(GenericHID.Hand move, Joystick.AxisType rotate) {
        
        drive.mecanumDrive_Cartesian(oi.getXbox().getX(move) , oi.getXbox().getY(move), rotate.value, gyro.getAngle());
        frontLeft.set(10);
        
        
        
    }
}
