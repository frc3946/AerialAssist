/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author AJ
 */
public class LoadingFingers extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public Relay fingers = new Relay(RobotMap.loadFingers);

    public void initDefaultCommand() {
        stopLoad();
    }
    
    public void forwardLoad() {
        fingers.set(Relay.Value.kReverse);
    }

    public void reverseLoad() {
        fingers.set(Relay.Value.kForward);
    }

    public void stopLoad() {
        fingers.set(Relay.Value.kOff);
    }

}
