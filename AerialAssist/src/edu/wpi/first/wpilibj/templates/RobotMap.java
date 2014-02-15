package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
     // PWM:
     public static final int fLeft = 1;
     public static final int fRight = 2;
     public static final int bRight = 3;
     public static final int bLeft = 4;
     public static final int bootMotor1 = 5;
     public static final int bootMotor2 = 6;
     public static final int loadArm = 7;
     public static final int loadFingers = 8;
     
     // Relays
     public static final int compressor = 1;
     public static final int compressorRelay = 2;
     
     // Solenoids:
     public static final int pG = 1;
     public static final int xG = 2;
     public static final int pW = 3;
     public static final int xW = 4;
     
     // Digital:
     public static final int pressureSwitch = 1;
     
     // Analog:
     public static final int gyro = 1;
     public static final int knob = 2;
     
     public static final int xboxController = 1;
     public static final int kickBall = XboxController.ButtonType.kX.value;
     public static final int raiseArm = XboxController.ButtonType.kL.value;
     public static final int lowerArm = XboxController.ButtonType.kR.value;
     public static final int grabBall = XboxController.ButtonType.kY.value;
     public static final int releaseBall = XboxController.ButtonType.kA.value;
     public static final int autoAim = XboxController.ButtonType.kB.value;
     public static final int adjustSpeed = XboxController.ButtonType.kLeftStick.value;
     public static final int adjustTime = XboxController.ButtonType.kRightStick.value;
}
