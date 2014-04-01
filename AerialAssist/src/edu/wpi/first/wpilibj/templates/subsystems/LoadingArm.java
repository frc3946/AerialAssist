/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.StopArm;

/**
 *
 * @author Caden
 */
public class LoadingArm extends Subsystem {

    private final DoubleSolenoid green = new DoubleSolenoid(RobotMap.pG, RobotMap.xG);
    private final DoubleSolenoid white = new DoubleSolenoid(RobotMap.pW, RobotMap.xW);

    protected void initDefaultCommand() {
        setDefaultCommand(new StopArm());
    }
    
    public void lowerArm() {
//        green.set(DoubleSolenoid.Value.kForward);       //pressurised
        white.set(DoubleSolenoid.Value.kReverse);       //exhausted
    }

    public void stowArm() {
        green.set(DoubleSolenoid.Value.kReverse);       //exhausted
//        white.set(DoubleSolenoid.Value.kForward);       //pressurised
    }

    public void stopArm() {
        green.set(DoubleSolenoid.Value.kForward);       //pressurised
        white.set(DoubleSolenoid.Value.kForward);       //pressurised
    }
}
