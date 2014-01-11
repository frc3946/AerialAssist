/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;

// @author OpalStone

public class ClawPiston extends Subsystem {
    private DoubleSolenoid piston = new DoubleSolenoid(RobotMap.clawPistonExtend, RobotMap.clawPistonRetract);
    
               
    public void initDefaultCommand() {

    }
    
    public void extend(){
        set(DoubleSolenoid.Value.kForward);
    }
    
    public void stop(){
        set(DoubleSolenoid.Value.kOff);
    }
    
    public void retract(){
        set(DoubleSolenoid.Value.kReverse);
    }
    
    public void set(DoubleSolenoid.Value value) {
        piston.set(value);
        if(value == DoubleSolenoid.Value.kForward) {
            SmartDashboard.putString("Loader", "Extend");
        } else if(value == DoubleSolenoid.Value.kReverse) {
            SmartDashboard.putString("Loader", "Retract");
        } else {
            SmartDashboard.putString("Loader", "Off");
        }
    }
    
    public ClawPiston() {
        super();
        LiveWindow.addActuator("ClawPiston", "ClawPiston", piston);
        System.out.println(this.getClass().getName()+" Initialized");
    }
}