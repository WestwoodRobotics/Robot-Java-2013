package org.warriors2583.frc2013.shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Austin Reuland
 */
public class C_MoveToTargetAngle extends Command {

    public C_MoveToTargetAngle() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		super("C_MoveToTargetAngle");
		requires(SS_ShooterTray.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		SS_ShooterTray.move(0.75 * SS_ShooterTray.getDirToTarget());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return SS_ShooterTray.atTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
		SS_ShooterTray.move(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
		end();
    }
}
