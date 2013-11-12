package org.warriors2583.frc2013.shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Austin Reuland
 */
public class C_SetShooterSpeed extends Command {

	private final double speed;
	
    public C_SetShooterSpeed(double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		super("C_StartShooter");
		requires(SS_Shooter.getInstance());
		this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		SS_Shooter.setSpeed(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return SS_Shooter.getSpeed() == speed;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
