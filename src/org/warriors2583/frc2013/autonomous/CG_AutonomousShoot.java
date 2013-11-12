package org.warriors2583.frc2013.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.warriors2583.frc2013.lib.C_Delay;
import org.warriors2583.frc2013.shooter.CG_GotoAngle;
import org.warriors2583.frc2013.shooter.CG_ShootFrisbee;
import org.warriors2583.frc2013.shooter.C_SetShooterSpeed;

/**
 *
 * @author Austin Reuland
 */
public class CG_AutonomousShoot extends CommandGroup {

    public CG_AutonomousShoot() {
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
		addSequential(new C_SetShooterSpeed(1));
		addSequential(new CG_GotoAngle(177));
		addSequential(new C_Delay(0.5));
		addSequential(new CG_ShootFrisbee());
		addSequential(new CG_ShootFrisbee());
		addSequential(new CG_ShootFrisbee());
    }
}