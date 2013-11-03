package org.warriors2583.frc2013;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author Austin Reuland
 */
public class OI {
	
	public static final Joystick joy_drive, joy_shoot;
	
	static{
		joy_drive = new Joystick(RMap.JOY_DRIVE);
		joy_shoot = new Joystick(RMap.JOY_SHOOT);
	}

	public static double getJDriveLeftX(){ return joy_drive.getX(); }
	public static double getJDriveLeftY(){ return joy_drive.getY(); }
	public static double getJDriveRightX(){ return joy_drive.getZ(); }
	public static double getJDriveRightY(){ return joy_drive.getTwist(); }
	public static double getJDriveTrigger(){ return joy_drive.getThrottle(); }
	
	public static double getJShootLeftX(){ return joy_shoot.getX(); }
	public static double getJShootLeftY(){ return joy_shoot.getY(); }
	public static double getJShootRightX(){ return joy_shoot.getZ(); }
	public static double getJShootRightY(){ return joy_shoot.getTwist(); }
	public static double getJShootTrigger(){ return joy_shoot.getThrottle(); }
}

