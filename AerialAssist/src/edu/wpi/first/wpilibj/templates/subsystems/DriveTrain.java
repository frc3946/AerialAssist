/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
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
    
    protected void initDefaultCommand() {
        setDefaultCommand(new MecanumDrive());
    }
    
    public DriveTrain(){
        super();
        System.out.println(this.getClass().getName()+" Initialized");
        drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
    }
    
    //this function should take x,y and a rotation, then pass that to the  mecanumDrive_Cartesian
    //function allong with the gyro
    public void mecanumDrive(double x, double y, double rotation, double gyro) {
//        System.out.println("[DT] X : " + x);
//        System.out.println("[DT] Y : " + y);
//        System.out.println("[DT] Theta : " + rotation);
//        System.out.println("[DT] Gyro : " + gyro);
//        SmartDashboard.putNumber("[DT] X", x);
//        SmartDashboard.putNumber("[DT] Y", y);
//        SmartDashboard.putNumber("[DT] Theta", rotation);
//        SmartDashboard.putNumber("[DT] Gyro", gyro);
        drive.mecanumDrive_Cartesian(.7*x, .7*y, .7*rotation, gyro);
    }
}
