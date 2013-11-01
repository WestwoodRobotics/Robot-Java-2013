package org.warriors2583.frc2013;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

public class Globals {
	
	public static Joystick m_joy1;
	public static Joystick m_joy2;
	
	public static RobotDrive m_driveMain;
	
	public static Compressor m_compressor1;
	
	public static int sign(double d){
		if(d >= 0.0) return 1;
		if(d < 0.0) return 1;
		return 0;
	}

}
