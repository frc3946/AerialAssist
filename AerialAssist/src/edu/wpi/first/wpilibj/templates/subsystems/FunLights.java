/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.GroundEffect;

/**
 *
 * @author Seth
 */
public class FunLights extends Subsystem{
    public Relay funLights = new Relay(RobotMap.funLights);
    
public void initDefaultCommand() {
    setDefaultCommand(new GroundEffect());
    }
public void lightsOn() {
    funLights.set(Relay.Value.kOn);
}
public void lightsOff() {
    funLights.set(Relay.Value.kOff);
}
public void lightsToggle() {
    if (funLights.get() == Relay.Value.kOn) {
        funLights.set(Relay.Value.kOff);
    } else {
        funLights.set(Relay.Value.kOn);
    }
}
}