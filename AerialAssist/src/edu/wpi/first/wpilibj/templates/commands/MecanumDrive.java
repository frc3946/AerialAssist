/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;




/**
 *
 * @author AJ
 */
public class MecanumDrive extends CommandBase {
    double X;
    double Y;
    double throttle;
    double xOld;
    double yOld;
    double throttleOld;
    
    public MecanumDrive() {
        requires(driveTrain);
    }
    
    protected void initialize(){
    }

    protected void execute() {
        //here we already have to access the io object. 
        //read the up/down and left/right from io.
        //then pass those values to the mecanum drive function.
        
        SmartDashboard.putNumber("[MC] X", oi.getXbox().getX(GenericHID.Hand.kLeft));
        SmartDashboard.putNumber("[MC] Y", oi.getXbox().getY(GenericHID.Hand.kLeft));
        SmartDashboard.putNumber("[MC] Theta", oi.getXbox().getThrottle());
        X = oi.getXbox().getX(GenericHID.Hand.kLeft);
        if (java.lang.Math.abs(X) <= 0.25) {
            X = 0.0;
        } else {
        }
        Y = oi.getXbox().getY(GenericHID.Hand.kLeft);
        if (java.lang.Math.abs(Y) <= 0.25) {
            Y = 0.0;
        }
        throttle = oi.getXbox().getThrottle();
        if (java.lang.Math.abs(throttle) <= 0.25) {
            throttle = 0.0;          
        }
        
//        for(double i = 1.0; i < 10.0*(X-xOld) &&
//                            i < 10.0*(Y-yOld) &&
//                            i < 10.0*(throttle-throttleOld); i += 1.0) {
//            setTimeout(.02);
//            while(!isTimedOut()){
//                driveTrain.mecanumDrive(i*(X-xOld)/10.0,
//                                        i*(Y-yOld)/10.0,
//                                        i*(throttle-throttleOld)/10.0,
//                                        gyro.getAngle());
//            }
            driveTrain.mecanumDrive(X, Y, throttle, gyro.getAngle());
//            driveTrain.mecanumDrive(i*(X-xOld)/10.0,
//                                    i*(Y-yOld)/10.0,
//                                    i*(throttle-throttleOld)/10.0,
//                                    gyro.getAngle());
//        }
        System.out.println("[MC] X " + X);
        System.out.println("[MC] Y " + Y);
        System.out.println("[MC] Theta " + throttle);
    }

    protected boolean isFinished() {
        xOld = X;
        yOld = Y;
        throttleOld = throttle;
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
   
    
}
