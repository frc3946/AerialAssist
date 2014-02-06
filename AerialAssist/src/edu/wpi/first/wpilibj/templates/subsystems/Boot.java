/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author OpalStone
 */
public class Boot extends Subsystem {
    
    private static final Victor bootMotor = new Victor(RobotMap.bootMotor1);
    private static final Victor victor2 = new Victor(RobotMap.bootMotor2);
    
    protected void initDefaultCommand() {
        
    }
    
    public void kickBall(){
        System.out.println("Boot Kicking");
        bootMotor.set(-1.0);
        bootMotor.set(-1.0);
    }
    public void retractBall(){
        System.out.println("Boot Retracting");
        bootMotor.set(1.0);
        bootMotor.set(1.0);
    }
    public void stopKick(){
        System.out.println("Boot Stop");
        bootMotor.set(0);
        bootMotor.set(0);
    }
}