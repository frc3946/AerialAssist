/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Caden
 */
    public class LoadingArm extends Subsystem{
    public Relay fingers = new Relay(RobotMap.loadFingers);
//    private DoubleSolenoid armDirection = new DoubleSolenoid(RobotMap.pW, RobotMap.xG);
    private DoubleSolenoid green = new DoubleSolenoid(RobotMap.pG, RobotMap.xG);
    private DoubleSolenoid white = new DoubleSolenoid(RobotMap.pW, RobotMap.xW);
    
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
        green.set(DoubleSolenoid.Value.kForward);
        white.set(DoubleSolenoid.Value.kReverse);
    }
    public void stowArm() {
        green.set(DoubleSolenoid.Value.kReverse);
        white.set(DoubleSolenoid.Value.kForward);
    }
    public void stopArm(){
        green.set(DoubleSolenoid.Value.kForward);
        white.set(DoubleSolenoid.Value.kForward);
    }
}


