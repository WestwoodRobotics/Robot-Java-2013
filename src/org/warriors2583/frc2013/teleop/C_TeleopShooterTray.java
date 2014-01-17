package org.warriors2583.frc2013.teleop;

import edu.wpi.first.wpilibj.command.Command;
import org.warriors2583.frc2013.OI;
import org.warriors2583.frc2013.shooter.SS_ShooterTray;

/**
 * 
 * @author Austin Reuland
 */
public class C_TeleopShooterTray extends Command {

    public C_TeleopShooterTray() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		super("C_TeleopShooterTray");
		requires(SS_ShooterTray.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		SS_ShooterTray.move(OI.getJDriveRightY());
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
    }
}
