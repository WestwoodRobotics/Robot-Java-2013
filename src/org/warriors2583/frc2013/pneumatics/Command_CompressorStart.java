package org.warriors2583.frc2013.pneumatics;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Austin Reuland
 */
public class Command_CompressorStart extends Command {
    

    public Command_CompressorStart() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Compressor.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Compressor.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
