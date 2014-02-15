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

    public MoveBoot(double speed, double timeout) {
        requires(boot);
        timeOut = timeout;
        this.speed = speed;
    }

    protected void initialize() {
        setTimeout(timeOut);
        boot.kickBall(speed);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    }

    protected void interrupted() {
        end();
    }

}
