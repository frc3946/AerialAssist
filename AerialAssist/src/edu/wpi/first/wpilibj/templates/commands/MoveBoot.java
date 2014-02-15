/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

//import edu.wpi.first.wpilibj.templates.CodeMonitor;

/**
 *
 * @author OpalStone
 */
class MoveBoot extends CommandBase {
    double timeOut;
    double speed;

    public MoveBoot(double speed, double timeout) {
        requires(boot);
        timeOut = timeout;
        this.speed = speed;
    }

    protected void initialize() {
        setTimeout(timeOut);
        System.out.println("");
//        CodeMonitor.CodeButtonUpdate(null);
    }

    protected void execute() {
        while(!isTimedOut()) {
            boot.kickBall(speed);
        }
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
        end();
    }

}