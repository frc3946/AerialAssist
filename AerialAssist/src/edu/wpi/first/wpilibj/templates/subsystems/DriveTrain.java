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

    private final Talon frontLeft = new Talon(RobotMap.fLeft);
    private final Talon frontRight = new Talon(RobotMap.fRight);
    private final Talon backLeft = new Talon(RobotMap.bLeft);
    private final Talon backRight = new Talon(RobotMap.bRight);
    private final RobotDrive drive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
    private final Gyro gyro = new Gyro(RobotMap.gyro);
    
    protected void initDefaultCommand() {
        setDefaultCommand(new MecanumDrive());
        MecanumDrive mecanumDrive = new MecanumDrive();  //todo: remove this line. What does it do?
    }
   
     
    //this function should take x,y and a rotation, then pass that to the  mecanumDrive_Cartesian
    //function allong with the gyro
    public void mecanumDrive(double x, double y, double rotation) {
        drive.mecanumDrive_Cartesian(x, y, rotation, gyro.getAngle());
    }
}
