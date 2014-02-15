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
//    private Solenoid armUp = new Solenoid(RobotMap.raiseArm);
//    private Solenoid armDown = new Solenoid(RobotMap.lowerArm);
    private Solenoid armStop = new Solenoid(RobotMap.stopArm);
 
    
    protected void initDefaultCommand() {
        stopArm();
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
        System.out.println("Lowering Arm");
        armDirection.set(DoubleSolenoid.Value.kReverse);
//        armUp.set(false);
//        armDown.set(true);
        armStop.set(false);                                     //vents
    }
    
    public void stowArm() {
        System.out.println("Raising Arm");
        armDirection.set(DoubleSolenoid.Value.kForward);
//        armUp.set(true);
//        armDown.set(false);
        armStop.set(false);                                     //vents
    }
    
    public void stopArm() {
        System.out.println("Arm Stopped");
        armStop.set(true);                                      //disables passive vent
//        armUp.set(true);
//        armDown.set(true);
//        armDirection.set(DoubleSolenoid.Value.kOff);
//        if (armDirection.get() == DoubleSolenoid.Value.kForward) {
//            armDirection.set(DoubleSolenoid.Value.kReverse);
//        } else if (armDirection.get() == DoubleSolenoid.Value.kReverse) {
//            armDirection.set(DoubleSolenoid.Value.kForward);
//        }
    }
}


