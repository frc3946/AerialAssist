/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.StopBoot;

/**
 *
 * @author Caden
 */public class LoadingArm extends Subsystem{      
    public Relay elbow = new Relay(RobotMap.loadArm);
    public Relay fingers = new Relay(RobotMap.loadFingers);
 
    
    protected void initDefaultCommand() {
        setDefaultCommand(new StopBoot());
    }
    
    public void forwardLoad() {
        fingers.set(Relay.Value.kReverse);
    }
    public void reverseLoad(){
        fingers.set(Relay.Value.kForward);
    }
    public void stopLoad(){
        fingers.set(Relay.Value.kOff);
    }
    public void lowerArm() {
        elbow.set(Relay.Value.kReverse);
    }
    public void stowArm() {
        elbow.set(Relay.Value.kForward);
    }
    public void stopArm() {
        elbow.set(Relay.Value.kOff);
    }
}


