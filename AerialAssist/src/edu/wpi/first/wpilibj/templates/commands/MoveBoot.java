/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author OpalStone
 */
public class MoveBoot extends CommandBase {

    double timeOut;
    double speed;
    double tAngle;
    public static int useRotation = 0;    //0 to ignore; 1 to use

    public MoveBoot(double speed, double timeout, double target) {
        requires(boot);
        timeOut = timeout;
        this.speed = speed;
        tAngle = target;
    }

    protected void initialize() {
        setTimeout(timeOut);
        boot.enable();
        boot.setSetpoint(speed);
        System.out.println("Boot moving...");
    }

    protected void execute() {
        SmartDashboard.putNumber("Rotation Sensor", boot.angle);
    }

    protected boolean isFinished() {
        double angleDiff1 = ((boot.angle - tAngle) + 360) % 360;
        double angleDiff2 = ((tAngle - boot.angle) + 360) % 360;
        if (Math.min(angleDiff1, angleDiff2) < 30 * (2 * useRotation - 1) || isTimedOut()) {
            System.out.println("Boot stopped...");
            return true;
        } else {
            return false;
        }
    }

    protected void end() {
        boot.disable();
    }

    protected void interrupted() {
        end();
    }

}
