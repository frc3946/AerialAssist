/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Caden
 */
    public class LoadingArm extends Subsystem{
    public Relay fingers = new Relay(RobotMap.loadFingers);
    private DoubleSolenoid armDirection = new DoubleSolenoid(RobotMap.armHigh, RobotMap.armLow);
    private Solenoid armStop = new Solenoid(RobotMap.stopArm);
 
    
    protected void initDefaultCommand() {
  
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
        armDirection.set(DoubleSolenoid.Value.kReverse);
    }
    public void stowArm() {
        armDirection.set(DoubleSolenoid.Value.kForward);
    }
    public void stopArm() {
        armDirection.set(DoubleSolenoid.Value.kOff);
        armStop.set(true);
    }
}


