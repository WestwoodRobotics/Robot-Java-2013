package org.wwr.frc2013.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * The GotoAngle Command Group.
 * This CommandGroup triggers a sequence of commands to move the ShooterTray to
 * the given angle.
 * @author Austin Reuland
 */
public class CG_GotoAngle extends CommandGroup {

	/**
	 * The GotoAngle Command Group
	 * @param angle The Angle to move to
	 */
    public CG_GotoAngle(double angle) {
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
		addSequential(new C_SetTargetAngle(angle));
		addSequential(new C_MoveToTargetAngle());
    }
}