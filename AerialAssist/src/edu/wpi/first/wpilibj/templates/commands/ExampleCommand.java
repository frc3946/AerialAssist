
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author bradmiller
 */
public class ExampleCommand extends CommandBase {

    public ExampleCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        setTimeout(3);
        while(!isTimedOut()){
            driveTrain.mecanumDrive(0, 1, 0);
        }
        driveTrain.mecanumDrive(0, -.7, 0);
        setTimeout(3);
        while(!isTimedOut()){
            driveTrain.mecanumDrive(0, -.7, 0);
        }
//        setTimeout(3);
//        while(!isTimedOut()){
//            driveTrain.mecanumDrive(0, -1, 0);
//        }
//        driveTrain.mecanumDrive(0, 0, 0);
//        setTimeout(1.5);
//        while(!isTimedOut()){
//            driveTrain.mecanumDrive(0, 0, 0);
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
