/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.warriors2583.frc2013;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Watchdog;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.warriors2583.frc2013.autonomous.CG_AutonomousShoot;
import org.warriors2583.frc2013.lib.C_UpdateDashboard;
import org.warriors2583.frc2013.pneumatics.C_CompressorStart;
import org.warriors2583.frc2013.pneumatics.C_LiftHooksUp;
import org.warriors2583.frc2013.pneumatics.SS_Compressor;
import org.warriors2583.frc2013.teleop.CG_TeleopRun;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class WestwoodBot extends IterativeRobot {

	//Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	OI oi = new OI();
	CommandGroup auton = new CG_AutonomousShoot();
	Command compressor = new C_CompressorStart();
	Command dashUpdater = new C_UpdateDashboard();
	public void robotInit(){    	
		
		// instantiate the command used for the autonomous period
		//autonomousCommand = new ExampleCommand();

		// Initialize all subsystems
		//CommandBase.init();
		
		//Disable ONLY FOR DEBUG
		//RE-ENABLE BEFORE DEPLOY
		Watchdog.getInstance().setEnabled(true);
		System.out.println("Robot Initiated");
		dashUpdater.start();
	}

	public void autonomousInit(){
		System.gc();
		auton.start();
		if(!SS_Compressor.isOn()) compressor.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		// feed the user watchdog at every period when in autonomous
		Watchdog.getInstance().feed();
		Scheduler.getInstance().run();
	}

	/**
	 * Called when the robot is first disabled
	 */

	public void disabledInit(){
		compressor.cancel();
		System.gc();
	}

	/**
	 * Called periodically during the disabled time based 
	 * on a periodic timer for the class. 
	 */

	public void disabledPeriodic() {
		// feed the user watchdog at every period when in autonomous
		Watchdog.getInstance().feed();
		Scheduler.getInstance().run();
	}

	/**
	 * Called continuously while the robot is disabled. Each 
	 * time the program returns from this function, it is 
	 * immediately called again provided that the state 
	 * hasn’t changed. 
	 */
	public void disabledContinuous(){
		
	}

	public void teleopInit(){
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to 
		// continue until interrupted by another command, remove
		// this line or comment it out.
		//autonomousCommand.cancel();
		auton.cancel();
		if(!SS_Compressor.isOn()) compressor.start();
		//(new C_LiftHooksUp()).start();
		(new CG_TeleopRun()).start();
		System.gc();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic(){
		// feed the user watchdog at every period when in autonomous
		Watchdog.getInstance().feed();
		
		Scheduler.getInstance().run();
	}
	
	public void testPeriodic(){
		Watchdog.getInstance().feed();
		LiveWindow.run();
		Scheduler.getInstance().run();
	}
}
