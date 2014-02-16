/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;


import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.StopBoot;

/**
 *
 * @author OpalStone
 */
public class Boot extends Subsystem {

//    private final Victor bootMotor1 = new Victor(RobotMap.bootMotor1);
//    private final Victor bootMotor2 = new Victor(RobotMap.bootMotor2);

    protected void initDefaultCommand() {
//        setDefaultCommand(new StopBoot());
    }
    
    public Boot() {
        super();
        System.out.println(this.getClass().getName() + " Initialized");
    }
    
//    public void kickBall(double speed) {
//        bootMotor1.set(speed);
//        bootMotor2.set(-speed);
//    }
}
