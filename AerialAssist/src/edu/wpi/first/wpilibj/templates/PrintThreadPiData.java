/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author Gustave Michel
 */
public class PrintThreadPiData extends CommandBase {

    private double lastTime;
    private Subsystem pi;

    public PrintThreadPiData() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(pi);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        lastTime = 0;
//        if (!pi.isConnected() || !pi.isEnabled()) {
//            pi.startPi();
//        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//        if (pi.getTime() > lastTime) {
//            lastTime = pi.getTime();
//            SmartDashboard.putString("Found", pi.getFound());
//            SmartDashboard.putNumber("Offset", pi.getOffset()); //Print Data to SmartDashboard
//            SmartDashboard.putNumber("Distance", (double) pi.getDistance() / 1000); //Convert from Millifeet to Feet
//            SmartDashboard.putString("Hot", pi.getHot());
////          SmartDashboard.putDaftPunk("Lucky", pi.getLucky());  
//            System.out.println("Found" + pi.getFound());
//            System.out.println("Offset" + pi.getOffset()); //Print Data to Output
//            System.out.println("Distance" + (double) pi.getDistance() / 1000); //Convert from Millifeet to Feet
//            System.out.println("Hot" + pi.getHot());
//        }
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