/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;




/**
 *
 * @author Seth
 */
public class GroundEffect extends CommandBase {
    double timeout = 1;
    final double[] pattern;
    int patternIndex = 0;
    double life = 0;
    double factor = 1;
    
    public GroundEffect() {
        this.pattern = new double[]{1, 1, 1, 1, 1, 3, 3, 1, 3, 1, 3, 3, 1, 1, 1, 1, 1, 1};
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        funLights.lightsOn();
        setTimeout(pattern[patternIndex]);
        life = Timer.getFPGATimestamp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (isTimedOut() == true){
            funLights.lightsToggle();
            patternIndex ++;
            if (patternIndex >= pattern.length){
                patternIndex = 0;
            }
            if (Timer.getFPGATimestamp() - life > 45) {
                factor = 0.5;
            }
            if (Timer.getFPGATimestamp() - life > 75) {
                factor = 0.25;
            }
            if (Timer.getFPGATimestamp() - life > 105) {
                factor = 0.125;
            }
            if (Timer.getFPGATimestamp() - life > 135) {
                factor = 0.25;
            }
            if (Timer.getFPGATimestamp() - life > 165) {
                factor = 0.5;
            }
            setTimeout(pattern[patternIndex] * factor);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
