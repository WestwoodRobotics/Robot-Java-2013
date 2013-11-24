package org.warriors2583.frc2013.shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Austin Reuland
 */
public class C_RunShooterMotor extends Command {

    public C_RunShooterMotor() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		super("C_RunShooterMotor");
		requires(SS_Shooter.getInstance());
		setInterruptible(false);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		SS_Shooter.setSpeed(SS_Shooter.getTargetSpeed());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
		SS_Shooter.setSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
		end();
    }
}
