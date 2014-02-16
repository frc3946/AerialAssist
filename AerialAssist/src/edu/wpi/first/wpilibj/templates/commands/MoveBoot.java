/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author OpalStone
 */
public class MoveBoot extends CommandBase {
    double timeOut;
    double speed;
    double tAngle;

    public MoveBoot(double speed, double timeout, double target) {
        requires(pidBoot);
        timeOut = timeout;
        this.speed = speed;
        tAngle = target;
    }

    protected void initialize() {
        setTimeout(timeOut);
        pidBoot.enable();
        pidBoot.setSetpoint(speed);
        System.out.println("Move boot start.");
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        double angleDiff1 = ((pidBoot.angle - tAngle)+360)%360;
        double angleDiff2 = ((tAngle - pidBoot.angle)+360)%360;
        if(Math.min(angleDiff1, angleDiff2) < 30 || isTimedOut()){
              System.out.println("Move boot done.");
            return true;
        } else {
            return false;
        }
    }

    protected void end() {
        pidBoot.disable();
    }

    protected void interrupted() {
        end();
    }

}
