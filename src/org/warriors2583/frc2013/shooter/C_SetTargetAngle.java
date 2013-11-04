package org.warriors2583.frc2013.shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Austin Reuland
 */
public class C_SetTargetAngle extends Command {
	
	private final double angle;
	
    public C_SetTargetAngle(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		super("C_SetTargetAngle");
		requires(SS_ShooterTray.getInstance());
		this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		SS_ShooterTray.setTargetAngle(angle);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
