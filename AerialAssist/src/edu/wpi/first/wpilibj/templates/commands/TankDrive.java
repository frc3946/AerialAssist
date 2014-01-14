/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;

/**
 *
 * @author AJ
 */
public class TankDrive extends Command {
    DriveTrain driveTrain = new DriveTrain();
    
    public TankDrive() {
        requires(driveTrain);
    }  

    protected void initialize() {
        
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
}
