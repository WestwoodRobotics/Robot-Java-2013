package org.wwr.frc2013.pneumatics;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Austin Reuland
 */
public class C_LiftHooksDown extends Command {

    public C_LiftHooksDown() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		super("C_LiftHooksDown");
		requires(SS_LiftHooks.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		SS_LiftHooks.down();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return SS_LiftHooks.isDown();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
