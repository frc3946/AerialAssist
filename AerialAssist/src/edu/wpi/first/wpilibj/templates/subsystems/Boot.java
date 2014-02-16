/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.StopBoot;

/**
 *
 * @author AJ
 */
public class Boot extends PIDSubsystem {

    private static final double Kp = 0.005;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    
    Victor bootMotor1 = new Victor(RobotMap.bootMotor1);
    Victor bootMotor2 = new Victor(RobotMap.bootMotor2);
    AnalogChannel rotationSensor = new AnalogChannel(RobotMap.bootSensor);
    
    public double angle;
    private double oldAngle = 1;
    private double time = 1;
    private double lastTime = 1;
    private double rpm;
    private double speed;

    // Initialize your subsystem here
    public Boot() {
        super("Boot", Kp, Ki, Kd);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
        enable();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new StopBoot());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        angle = ((((rotationSensor.getVoltage() - .5)/4)*360) + 132)%360;
        time = Timer.getFPGATimestamp();
        double angleDiff1 = ((angle - oldAngle)+360)%360;
        double angleDiff2 = ((oldAngle - angle)+360)%360;
        rpm = (Math.min(angleDiff1, angleDiff2)%360)/(time-lastTime)/1000;
        System.out.println("Angle : " + angle + "\nRPM : " + rpm);
        oldAngle = angle;
        lastTime = time;
        return rpm;
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
        if(Math.abs(output) < .25 && output != 0)
            output = (output/Math.abs(output))*.25;
        System.out.println("[Boot] Output : " + output);
        bootMotor1.set(output);
        bootMotor2.set(-output);
    }
    
    public void kickBall(double speed) {
        this.speed = speed;
        bootMotor1.set(speed);
        bootMotor2.set(-speed);
    }

    public void updateStatus() {
        SmartDashboard.putDouble("RPM", rpm);
    }
}
