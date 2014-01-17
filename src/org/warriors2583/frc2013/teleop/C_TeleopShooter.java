package org.warriors2583.frc2013.teleop;

import edu.wpi.first.wpilibj.command.Command;
import org.warriors2583.frc2013.OI;
import org.warriors2583.frc2013.shooter.SS_Shooter;

/**
 *
 * @author Austin Reuland
 */
public class C_TeleopShooter extends Command {

    public C_TeleopShooter() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		super("C_TeleopShooter");
		requires(SS_Shooter.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		SS_Shooter.setFeeder(!OI.getJDriveButton(2));
		SS_Shooter.setTargetSpeed(OI.getJDriveThrottle());
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
