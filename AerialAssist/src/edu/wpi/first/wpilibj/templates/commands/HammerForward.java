/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author OpalStone
 */
class HammerForward extends CommandBase {
    double timeOut;
    double speed;

    public HammerForward(double speed, double timeout) {
        requires(boot);
        timeOut = timeout;
        this.speed = speed;
    }

    protected void initialize() {
        setTimeout(timeOut);
        System.out.println("HammerForward");
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
