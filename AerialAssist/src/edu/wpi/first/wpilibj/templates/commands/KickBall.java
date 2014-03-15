
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author nrladmin
 */
public class KickBall extends CommandGroup {
    public static double[][] sequence = new double[3][3];
    public static int i;

    public KickBall() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        System.out.println(sequence.length);
        for(i = 0; i < sequence.length; i++){
            System.out.println("KickBall For Loop");
            addSequential(new MoveBoot(sequence[i][0], sequence[i][1], sequence[i][2]));
        }
        
//        addSequential(new MoveBoot(-20, .7, 147));
//        addSequential(new MoveBoot(1575, .5, 205));
    }
}
