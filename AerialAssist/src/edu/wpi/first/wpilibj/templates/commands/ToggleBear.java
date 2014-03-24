/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;

/**
 *
 * @author AJ
 */
public class ToggleBear extends CommandBase {
    
    public ToggleBear() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        DriveTrain.polarBear = !(DriveTrain.polarBear);
        if(DriveTrain.polarBear == true){
            SmartDashboard.putString("polarBear", "Polar Mode");
        }else{
            SmartDashboard.putString("polarBear", "Field Orientation");
            CommandBase.gyro.reset();
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
