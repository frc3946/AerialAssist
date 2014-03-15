/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author AJ
 */
public class SetKick extends CommandBase {
    int uRPM;
    int uAngle;
    double uTime;
    int stage;
    
    public SetKick() {
        // Use requires() here to declare subsystem deTpendencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        SmartDashboard.putNumber("Use Rotation", MoveBoot.useRotation);
        KickBall.sequence[0][0] = SmartDashboard.getNumber("Speed 1");  
        KickBall.sequence[0][1] = SmartDashboard.getNumber("Timeout 1");  
        KickBall.sequence[0][2] = SmartDashboard.getNumber("Angle 1");  
        
        KickBall.sequence[1][0] = SmartDashboard.getNumber("Speed 2");  
        KickBall.sequence[1][1] = SmartDashboard.getNumber("Timeout 2");  
        KickBall.sequence[1][2] = SmartDashboard.getNumber("Angle 2");
        
        KickBall.sequence[2][0] = SmartDashboard.getNumber("Speed 3");  
        KickBall.sequence[2][1] = SmartDashboard.getNumber("Timeout 3");  
        KickBall.sequence[2][2] = SmartDashboard.getNumber("Angle 3");  
//        uRPM = (int) SmartDashboard.getNumber("Kick Setpoint", 0);
//        uAngle = (int) SmartDashboard.getNumber("Kick Angle", 0);
//        uTime = SmartDashboard.getNumber("Kick Timeout", 0);
//        stage = (int) SmartDashboard.getNumber("Kick Stage", 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//        KickBall.sequence[0][stage] = uRPM;
//        KickBall.sequence[1][stage] = uTime;
//        KickBall.sequence[2][stage] = uAngle;
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
