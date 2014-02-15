/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.StopBoot;

/**
 *
 * @author OpalStone
 */
public class Boot extends Subsystem {

    private static final Victor bootMotor = new Victor(RobotMap.bootMotor1);
    private static final Victor bootMotor2 = new Victor(RobotMap.bootMotor2);

    protected void initDefaultCommand() {
        setDefaultCommand(new StopBoot());
    }

    public void kickBall(double speed) {
        bootMotor.set(speed);
        System.out.println("THE BOOT MOTORS ARE CURRENTLY BEING SET TO A SPEED OF " + speed);
        bootMotor2.set(-speed);
    }
}
