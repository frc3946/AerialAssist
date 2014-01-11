/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.RobotMap;
/**
 *
 * @author Makaylah
 */
public class ClawWheels extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Relay topWheel = new Relay(RobotMap.clawTopWheel);
//    public Relay bottomWheel = new Relay(RobotMap.clawBottomWheel);
    
    public void set(Relay.Value speed) {
        if (speed == Relay.Value.kForward) {
            topWheel.set(Relay.Value.kReverse);
//            bottomWheel.set(speed);
        } else if (speed == Relay.Value.kReverse) {
//            bottomWheel.set(Relay.Value.kReverse);
            topWheel.set(speed); 
        } else {
            topWheel.set(speed);
//            bottomWheel.set(speed); 
        }
    }
    
    public boolean isRunning() {
        if(topWheel.get() != Relay.Value.kOff) {
            return true;
        } else {
            return false;
        }
    }
        
    public ClawWheels() {
        super();
        LiveWindow.addActuator("ClawWheels", "TopWheel", topWheel);
//        LiveWindow.addActuator("ClawWheels", "BottomWheel", bottomWheel);
        System.out.println(this.getClass().getName()+" Initialized");
    }

    protected void initDefaultCommand() {
        topWheel.set(Relay.Value.kOff);
//        bottomWheel.set(Relay.Value.kOff);
        
    }
}