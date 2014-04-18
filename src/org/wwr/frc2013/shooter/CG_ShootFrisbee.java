package org.wwr.frc2013.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.wwr.frc2013.lib.C_Delay;

/**
 *
 * @author Austin Reuland
 */
public class CG_ShootFrisbee extends CommandGroup {

    public CG_ShootFrisbee() {
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
		//addParallel(new CG_GotoAngle(170));
		//addSequential(new C_StartShooter(1.0));
		addSequential(new C_FeederExtend());
		addSequential(new C_Delay(0.25));
		addSequential(new C_FeederRetract());
		addSequential(new C_Delay(0.5));
    }
}