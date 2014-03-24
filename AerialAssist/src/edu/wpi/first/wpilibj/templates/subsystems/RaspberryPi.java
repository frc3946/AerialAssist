/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.SocketPi;
import edu.wpi.first.wpilibj.templates.commands.PrintPiData;
//import org.usfirst.frc3946.UltimateAscent.commands.PrintPiData;

/**
 *
 * @author Gustave Michel
 */
public class RaspberryPi extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    SocketPi raspberryPi;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new PrintPiData());
    }
    public SocketPi getPi() {
        return raspberryPi;
    }
    
    public RaspberryPi() {
        super();
//        raspberryPi = new SocketPi();
        System.out.println(this.getClass().getName()+" Initialized");
    }
}
