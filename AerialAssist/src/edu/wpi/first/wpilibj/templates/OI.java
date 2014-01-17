
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI  {RaspberryPiThread extends Thread {
        ThreadedPi m_raspberryPi;
    
        public RaspberryPiThread(ThreadedPi raspberryPi) {
            super("PiSocket");
            m_raspberryPi = raspberryPi;
        }
        
        public void run() {
            while(m_run) {
                if(m_raspberryPi.isEnabled()) { //Checks for Thread to run
                    if(m_raspberryPi.isConnected()) {
                        report = true;
                        try {
                            String[] data = m_raspberryPi.tokenizeData(m_raspberryPi.getRawData()); //Get and examine Data
                            time = Timer.getFPGATimestamp();
                            if(data.length < 2) { //Error Check
                                report = false;
                            } else {
                                try {
                                    distance = Integer.parseInt(data[1]); //Get data
                                    offset = Integer.parseInt(data[0]);
                                } catch(NumberFormatException ex) {
                                    report = false;
                                }
                            }
                        } catch (IOException ex) {
                            report = false;
                        }
                        DataKeeper.setReport(report);
                                
                        if(report) { //Store Data in DataKeeper
                            DataKeeper.setDistance(distance);
                            DataKeeper.setOffset(offset);
                            DataKeeper.setTime(time);
                        }
                    } else {
                        try {
                            m_raspberryPi.connect();
                        } catch (IOException ex) {
                            DataKeeper.setReport(false);
                        }
                    }
                }
                try {
                    Thread.sleep(375); //Wait half second before getting Data again
                } catch(InterruptedException ex) {}
            }
        }
    }
    
    public ThreadedPi() {
        m_enabled = false;
        m_thread = new RaspberryPiThread(this);
        try{
         connect();
        } catch (IOException ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        
        m_thread.start();
public class RaspberryPi extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    SocketPi raspberryPi;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
//        setDefaultCommand(new PrintPiData());
    }
    public SocketPi getPi() {
        return raspberryPi;
    }
    
    public RaspberryPi() {
        super();
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
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

