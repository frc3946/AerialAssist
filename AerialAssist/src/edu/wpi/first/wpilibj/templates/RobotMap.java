package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
     // Sidecar:
     public static final int fRight = 2;
     public static final int bLeft = 4;
     public static final int bRight = 3;
     public static final int fLeft = 1;
//     public static final int catapult = 5;

     // Solenoids:
          
     // Analog:
     public static final int gyro = 1;
     
     public static final int xboxController = 1;
     public static final int testDrive = XboxController.ButtonType.kB.value;
     
}
