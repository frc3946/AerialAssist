
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.*;

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
    private XboxController xbox;
    private Joystick genius;
    
    private Button launchFrisbee;
    private Button loadFrisbee;
//    private Button firePiston;
    private Button TopClimbingPiston;
    private Button BottomClimbingPiston;
    private Button fender;
//    private Button Climb;
    private Button pitchFore;
    private Button pitchAft;
    private Button StopMotors;
    private Button AutoAim;
    private Button debug;
    
    private Button adjustUp;
    private Button adjustLeft;
    private Button adjustRight;
    private Button adjustDown;
    
    private XboxController.AxisType leftY = XboxController.AxisType.kLeftY;
    private XboxController.AxisType rightY = XboxController.AxisType.kRightY;
    private XboxController.AxisType leftX = XboxController.AxisType.kLeftX;
    private XboxController.AxisType rightX = XboxController.AxisType.kRightX;
    private XboxController.AxisType Trigger = XboxController.AxisType.kTrigger;
    private XboxController.AxisType dLeftRight = XboxController.AxisType.kDLeftRight;
    
    public XboxController getXbox() {
        return xbox;
    }
    
    
    
    
    
    public OI() {
        xbox = new XboxController(RobotMap.xboxController);
    }
}/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
