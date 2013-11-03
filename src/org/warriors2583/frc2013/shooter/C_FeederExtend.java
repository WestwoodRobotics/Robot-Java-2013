package org.warriors2583.frc2013.shooter;

import edu.wpi.first.wpilibj.command.Command;


/**
 *
 * @author Austin Reuland
 */
public class C_FeederExtend extends Command {

    public C_FeederExtend() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		super("C_FeederExtend");
		requires(SS_Shooter.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		SS_Shooter.extendFeeder();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return SS_Shooter.feederExtended();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}