package org.warriors2583.frc2013.drivetrain;

import org.warriors2583.frc2013.OI;
import org.warriors2583.frc2013.commands.CommandBase;

/**
 *
 * @author Austin Reuland
 */
public class C_TeleopDrive extends CommandBase {
	
	public C_TeleopDrive() {
		// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
	super("Command_TeleopDrive");
	requires(SS_Drivetrain.getInstance());
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	SS_Drivetrain.arcade(OI.getJDriveLeftY(), OI.getJDriveRightX());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
	return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	end();
	}
}
