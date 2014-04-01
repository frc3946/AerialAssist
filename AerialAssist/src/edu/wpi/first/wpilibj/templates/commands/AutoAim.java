///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package edu.wpi.first.wpilibj.templates.commands;
//
//import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.templates.RobotTemplate;
//import edu.wpi.first.wpilibj.templates.subsystems.ThreadedberryPi;
//
///**
// *
// * @author nrladmin
// */
//public class AutoAim extends CommandBase {
//
//    private static double distAdjust;
//    private static double centerAdjust;
//    ThreadedberryPi pi;
//    int distance;
//    int offset;
//    boolean output;
//
//    public AutoAim() {
//        // Use requires() here to declare subsystem dependencies
//        requires(driveTrain);
//    }
//
//    // Called just before this Command runs the first time
//    protected void initialize() {
//        pi = new ThreadedberryPi();
//        distance = 0;
//        offset = 0;
//        output = false;
//        setTimeout(3);
////        CodeMonitor.CodeButtonUpdate("B");
//    }
//
//    // Called repeatedly when this Command is scheduled to run
//    //Numbers subject to change.0
//    protected void execute() {
//        distance = pi.getDistance();
//        offset = pi.getOffset();
//        if (Math.abs(offset) >= 15) {
//            driveTrain.mecanumDrive(0, 0, offset / 240, (gyro.getAngle()- (RobotTemplate.gyroOff * Timer.getFPGATimestamp())));
//        } else if (Math.abs(distance - 11000) >= 250) {
//            driveTrain.mecanumDrive((distance - 11000) * Math.cos((gyro.getAngle()- (RobotTemplate.gyroOff * Timer.getFPGATimestamp()))),
//                    (distance - 11000) * Math.sin((gyro.getAngle()- (RobotTemplate.gyroOff * Timer.getFPGATimestamp()))),
//                    0, (gyro.getAngle()- (RobotTemplate.gyroOff * Timer.getFPGATimestamp())));
//        } else {
//            output = true;
//        }
//    }
//
//    protected static void aimUp() {
//        distAdjust += 250;
//        SmartDashboard.putNumber("Distance Adjustment", distAdjust);
//    }
//
//    protected static void aimDown() {
//        distAdjust -= 250;
//        SmartDashboard.putNumber("Distance Adjustment", distAdjust);
//    }
//
//    protected static void aimLeft() {
//        centerAdjust -= 15;
//        SmartDashboard.putNumber("Windage Adjustment", centerAdjust);
//    }
//
//    protected static void aimRight() {
//        centerAdjust += 15;
//        SmartDashboard.putNumber("Windage Adjustment", centerAdjust);
//    }
//
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished() {
//        if (isTimedOut()) {
//            return output;
//        } else {
//            return false;
//        }
//    }
//
//    // Called once after isFinished returns true
//    protected void end() {
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    }
//}
