/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.warriors2583.frc2013.drivetrain;

import org.warriors2583.frc2013.OI;
import org.warriors2583.frc2013.commands.CommandBase;

/**
 *
 * @author Austin Reuland
 */
public class Command_TeleopDrive extends CommandBase {
    
    public Command_TeleopDrive() {
        // Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
	super("Command_TeleopDrive");
	requires(Drivetrain.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	Drivetrain.arcade(OI.getJDriveY0(), OI.getJDriveX1());
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
