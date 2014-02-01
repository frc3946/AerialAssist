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
        double X = oi.getXbox().getX(GenericHID.Hand.kLeft);
        if (java.lang.Math.abs(X) <= 0.25) {
            X = 0.0;
        } else {
        }
        double Y = oi.getXbox().getY(GenericHID.Hand.kLeft);
        if (java.lang.Math.abs(Y) <= 0.25) {
            Y = 0.0;
        }
       
        double throttle = oi.getXbox().getThrottle();
        if (java.lang.Math.abs(throttle) <= 0.25) {
            throttle = 0.0;          
        }
        driveTrain.mecanumDrive(X,
                                Y,
                                throttle,
                                gyro.getAngle());
        System.out.println("[MC] X" + X);
        System.out.println("[MC] Y" + Y);
        System.out.println("[MC] Theta" + throttle);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
   
    
}
