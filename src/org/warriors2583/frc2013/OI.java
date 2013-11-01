
package org.warriors2583.frc2013;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
    
    public static final Joystick joy_drive, joy_shoot;
    
    static {
    	
    	joy_drive = new Joystick(RMap.JOY_DRIVE);
        joy_shoot = new Joystick(RMap.JOY_SHOOT);

    }

    public static double getJDriveX0(){ return joy_drive.getX(); }
    public static double getJDriveY0(){ return joy_drive.getY(); }
    public static double getJDriveX1(){ return joy_drive.getZ(); }
    public static double getJDriveY1(){ return joy_drive.getTwist(); }
    public static double getJDriveTrigger(){ return joy_drive.getThrottle(); }
    
    public static double getJShootX0(){ return joy_shoot.getX(); }
    public static double getJShootY0(){ return joy_shoot.getY(); }
    public static double getJShootX1(){ return joy_shoot.getZ(); }
    public static double getJShootY1(){ return joy_shoot.getTwist(); }
    public static double getJShootTrigger(){ return joy_shoot.getThrottle(); }
}

