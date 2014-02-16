
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
    static double[][] sequence = new double[2][6];
    static int i;

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
//        for(i = 0; i < sequence.length; i++){
//            System.out.println("KickBall For Loop");
//            addSequential(new MoveBoot(sequence[0][i], sequence[1][i]));
//        }
        addSequential(new MoveBoot(-.5, .268));
        addSequential(new MoveBoot(-.6, .2));
        addSequential(new MoveBoot(1, .2));
        addSequential(new MoveBoot(-.5, .2));
    }
}
