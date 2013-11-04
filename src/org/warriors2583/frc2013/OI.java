package org.warriors2583.frc2013;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.warriors2583.frc2013.drivetrain.SS_Drivetrain;
import org.warriors2583.frc2013.pneumatics.C_LiftHooksDown;
import org.warriors2583.frc2013.pneumatics.C_LiftHooksUp;
import org.warriors2583.frc2013.pneumatics.SS_Compressor;
import org.warriors2583.frc2013.pneumatics.SS_LiftHooks;
import org.warriors2583.frc2013.shooter.SS_Shooter;
import org.warriors2583.frc2013.shooter.SS_ShooterTray;
import org.warriors2583.frc2013.vision.C_VisionLightOff;
import org.warriors2583.frc2013.vision.C_VisionLightOn;
import org.warriors2583.frc2013.vision.SS_VisionLight;

/**
 *
 * @author Austin Reuland
 */
public class OI {
	
	public static final Joystick joy_drive, joy_shoot;
	public static final JoystickButton liftHooksUpButton, liftHooksDownButton;
	public static final JoystickButton visionLightOffButton, visionLightOnButton;
	
	static{
		SmartDashboard.putData(RMap.DASH_INSTANCE_DRIVETRAIN, SS_Drivetrain.getInstance());
		SmartDashboard.putData(RMap.DASH_INSTANCE_SHOOTER, SS_Shooter.getInstance());
		SmartDashboard.putData(RMap.DASH_INSTANCE_SHOOTER_TRAY, SS_ShooterTray.getInstance());
		SmartDashboard.putData(RMap.DASH_INSTANCE_COMPRESSOR, SS_Compressor.getInstance());
		SmartDashboard.putData(RMap.DASH_INSTANCE_LIFT_HOOKS, SS_LiftHooks.getInstance());
		SmartDashboard.putData(RMap.DASH_INSTANCE_VISION_LIGHT, SS_VisionLight.getInstance());
		
		joy_drive = new Joystick(RMap.JOY_DRIVE);
		joy_shoot = new Joystick(RMap.JOY_SHOOT);
		
		liftHooksUpButton = new JoystickButton(joy_shoot, 3);
		liftHooksUpButton.whenPressed(new C_LiftHooksUp());
		liftHooksDownButton = new JoystickButton(joy_shoot, 4);
		liftHooksDownButton.whenPressed(new C_LiftHooksDown());
		
		visionLightOffButton = new JoystickButton(joy_shoot, 7);
		visionLightOffButton.whenPressed(new C_VisionLightOff());
		visionLightOnButton = new JoystickButton(joy_shoot, 8);
		visionLightOnButton.whenPressed(new C_VisionLightOn());
	}

	public static double getJDriveLeftX(){ return joy_drive.getX(); }
	public static double getJDriveLeftY(){ return joy_drive.getY(); }
	public static double getJDriveRightX(){ return joy_drive.getZ(); }
	public static double getJDriveRightY(){ return joy_drive.getTwist(); }
	public static double getJDriveThrottle(){ return joy_drive.getThrottle(); }
	
	public static boolean getJDriveButton(int button){ return joy_drive.getRawButton(button); }
	
	public static double getJShootLeftX(){ return joy_shoot.getX(); }
	public static double getJShootLeftY(){ return joy_shoot.getY(); }
	public static double getJShootRightX(){ return joy_shoot.getZ(); }
	public static double getJShootRightY(){ return joy_shoot.getTwist(); }
	public static double getJShootThrottle(){ return joy_shoot.getThrottle(); }
	
	public static boolean getJShootButton(int button){ return joy_shoot.getRawButton(button); }
	
	public static double getShooterSpeedScale(){
		return SmartDashboard.getNumber(RMap.DASH_SHOOTER_SCALE, 0.75);
	}
	
	public static double getShooterAutoAngle(){
		return SmartDashboard.getNumber(RMap.DASH_SHOOTER_AUTO_ANGLE);
	}
}

