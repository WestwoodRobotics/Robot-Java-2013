/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc2583;

import org.usfirst.frc2583.commands.CommandBase;
import org.usfirst.frc2583.commands.ExampleCommand;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Watchdog;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class WestwoodBot extends IterativeRobot {
	
	Autonomous autono;
	Teleop teleop;

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	
    	//Joystick Variables
    	Globals.m_joy1 = new Joystick(1);
    	Globals.m_joy2 = new Joystick(2);
    	//Front Left, Rear Left, Front Right, Rear Right (PWM Ports)
    	Globals.m_driveMain = new RobotDrive(1, 3, 2, 4);
        // instantiate the command used for the autonomous period
        autonomousCommand = new ExampleCommand();

        // Initialize all subsystems
        CommandBase.init();
        
        //Disable ONLY FOR DEBUG
        //RE-ENABLE BEFORE DEPLOY
        Watchdog.getInstance().setEnabled(true);
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        autonomousCommand.start();
        autono = new Autonomous();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	// feed the user watchdog at every period when in autonomous
    	Watchdog.getInstance().feed();
    	
        Scheduler.getInstance().run();
        
        autono.run();
    }

    /**
     * Called when the robot is first disabled
     */

    public void disabledInit() {

    }

    /**
     * Called periodically during the disabled time based 
     * on a periodic timer for the class. 
     */

    public void disabledPeriodic() {
    	// feed the user watchdog at every period when in autonomous
    	Watchdog.getInstance().feed();

    }

    /**
     * Called continuously while the robot is disabled. Each 
     * time the program returns from this function, it is 
     * immediately called again provided that the state 
     * hasn’t changed. 
     */
    public void disabledContinuous() {

    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to 
		// continue until interrupted by another command, remove
		// this line or comment it out.
		autonomousCommand.cancel();
		teleop = new Teleop();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	// feed the user watchdog at every period when in autonomous
    	Watchdog.getInstance().feed();
    	
        Scheduler.getInstance().run();
        teleop.run();
    }
}
