package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    public static Compressor compressor = new Compressor();
    public static DriveTrain driveTrain = new DriveTrain();
    public static Boot boot = new Boot();
    public static Gyro gyro = new Gyro(RobotMap.gyro);
    public static LoadingArm loadingArm = new LoadingArm();
    public static FunLights funLights = new FunLights();
//    public static RaspberryPi raspberryPi = new RaspberryPi();
//    public static ThreadedberryPi threadedberryPi = new ThreadedberryPi();
//   public static CatapultMotor catapult = new CatapultMotor();

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        gyro.reset();
        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(driveTrain);
        SmartDashboard.putData(compressor);
        SmartDashboard.putData(loadingArm);
        SmartDashboard.putData(boot);
        SmartDashboard.putData("PID Controller",boot.getPIDController());
        
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
