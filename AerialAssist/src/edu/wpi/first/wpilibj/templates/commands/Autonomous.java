/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author nrladmin
 */
public class Autonomous extends CommandGroup {
    
    public Autonomous() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        //RobotDrive.setSafetyEnabled(false);
        //Read knob to determine which direction to auto aim.
        AnalogChannel knob;
        knob = new AnalogChannel(RobotMap.knob);
        int knobValue = knob.getValue();
        System.out.println("knobValue = " + knobValue);
  
        //Lower arm.
        addParallel (new LowerArm());
        
        //Move forward slightly. 
        addSequential (new AutoDrive());
        
        //Run AutoAim for up to 4 seconds. 
        if(knobValue <= 6000){
              addSequential (new AutoAimLeft());
        }else if(knobValue >= 60000){
              addSequential (new AutoAimRight());
        }

        //Run KickBall to shoot
        addSequential (new KickBall());        
    }
}
