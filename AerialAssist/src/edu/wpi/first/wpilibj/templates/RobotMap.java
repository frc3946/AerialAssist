package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static int clawTopWheel;
    
     // Sidecar:
     public static final int fRight = 1;
     public static final int bLeft = 2;
     public static final int bRight = 3;
     public static final int fLeft = 4;
     public static final int catapult = 5;
     
     
     // Solenoids:
     public static final int clawPistonExtend = 0;
     public static final int clawPistonRetract = 1;
     
     public static final int gyro = 1;
     
     public static final int xboxController = 0;
     public static final double leftY = 1;
     public static final double rightY = 2;
     public static final double leftX = 3;
     public static final double rightX = 4;
     public static final double Trigger = 5;
     public static final double dLeftRight = 6;
}
