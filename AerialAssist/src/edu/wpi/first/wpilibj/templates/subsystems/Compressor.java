/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.StartCompressor;

/**
 *
 * @author Gustave Michel
 */
public class Compressor extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    edu.wpi.first.wpilibj.Compressor compressor = new edu.wpi.first.wpilibj.Compressor(RobotMap.pressureSwitch, RobotMap.compressor);
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new StartCompressor());
    }
    
    public void start() {
        System.out.println("Compressor Running");
        compressor.start();
    }
    
    public void stop() {
        System.out.println("Compressor Stopped");
        compressor.stop();
    }
    
    public void testCompressor() {
        compressor.setRelayValue(Relay.Value.kForward);
    }
    
    public Compressor() {
        super();
        LiveWindow.addActuator("Compressor", "Compressor", compressor);
        System.out.println(this.getClass().getName()+" Initialized");
    }
}
