package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.InternalButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.*;
import edu.wpi.first.wpilibj.templates.subsystems.Boot;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    // Run the command while the button is being held down and interrupt it once
    // the button is released
    // button.whileHeld(new ExampleCommand());
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    private final XboxController xbox;

    private final Button kickBall;
    private final Button raiseArm;
    private final Button lowerArm;
    private final Button loadBall;
    private final Button leaveBall;
    private final Button autoAim;
    private final Button togglePolar;
    
    private final InternalButton setKick;
    private final InternalButton toggleRotation;
    private final InternalButton toggleDrive;
    private final InternalButton testDrive;
    private final InternalButton reZero;
    

    public OI() {
        xbox = new XboxController(RobotMap.xboxController);

        kickBall = new JoystickButton(xbox, RobotMap.kickBall);
        loadBall = new JoystickButton(xbox, RobotMap.grabBall);
        leaveBall = new JoystickButton(xbox, RobotMap.releaseBall);
        raiseArm = new JoystickButton(xbox, RobotMap.raiseArm);
        lowerArm = new JoystickButton(xbox, RobotMap.lowerArm);
        autoAim = new JoystickButton(xbox, RobotMap.autoAim);
        togglePolar = new JoystickButton(xbox, RobotMap.togglePolar);
        
        setKick = new InternalButton();
        toggleRotation = new InternalButton();
        toggleDrive = new InternalButton();
        testDrive = new InternalButton();
        reZero = new InternalButton();
        
        
        kickBall.whenPressed(new KickBall());
        loadBall.whileHeld(new ForwardLoad());
        leaveBall.whileHeld(new ReverseLoad());
        raiseArm.whileHeld(new StowArm());
        lowerArm.whileHeld(new LowerArm());
        togglePolar.whenPressed(new ToggleBear());
//        autoAim.whileHeld(new AutoAim());
        
        SmartDashboard.putData("Set Kick", setKick);
        setKick.whenPressed(new SetKick());
        SmartDashboard.putData("Toggle Rotation", toggleRotation);
        toggleRotation.whenPressed(new ToggleRotation());
        SmartDashboard.putData("Toggle Drive Mode", toggleDrive);
        toggleDrive.whenPressed(new ToggleBear());
        SmartDashboard.putData("Test Drive Wheels", testDrive);
        testDrive.whenPressed(new testDrive());
        SmartDashboard.putData("Reset Boot Zero", reZero);
        reZero.whenPressed(new ReZero());
        
    }

    public XboxController getXbox() {
        return xbox;
    }
}
