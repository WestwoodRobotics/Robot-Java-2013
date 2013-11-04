package org.warriors2583.frc2013;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.warriors2583.frc2013.drivetrain.SS_Drivetrain;
import org.warriors2583.frc2013.pneumatics.C_LiftHooksDown;
import org.warriors2583.frc2013.pneumatics.C_LiftHooksUp;
import org.warriors2583.frc2013.shooter.CG_ShootFrisbee;
import org.warriors2583.frc2013.shooter.SS_Shooter;
import org.warriors2583.frc2013.shooter.SS_ShooterTray;

/**
 *
 * @author Austin Reuland
 */
public class OI {
	
	public static final Joystick joy_drive, joy_shoot;
	public static final JoystickButton shooterFireButton;
	public static final JoystickButton liftHooksUpButton, liftHooksDownButton;
	
	static{
		SmartDashboard.putData(RMap.DASH_INSTANCE_DRIVETRAIN, SS_Drivetrain.getInstance());
		SmartDashboard.putData(RMap.DASH_INSTANCE_SHOOTER, SS_Shooter.getInstance());
		SmartDashboard.putData(RMap.DASH_INSTANCE_SHOOTER_TRAY, SS_ShooterTray.getInstance());
		joy_drive = new Joystick(RMap.JOY_DRIVE);
		joy_shoot = new Joystick(RMap.JOY_SHOOT);
		
		shooterFireButton = new JoystickButton(joy_shoot, 2);
		shooterFireButton.whenPressed(new CG_ShootFrisbee());
		liftHooksUpButton = new JoystickButton(joy_shoot, 3);
		liftHooksUpButton.whenPressed(new C_LiftHooksUp());
		liftHooksDownButton = new JoystickButton(joy_shoot, 4);
		liftHooksDownButton.whenPressed(new C_LiftHooksDown());
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
	
	public static double getShooterSpeedScale(){
		return SmartDashboard.getNumber(RMap.DASH_SHOOTER_SCALE, 0.75);
	}
	
	public static double getShooterAutoAngle(){
		return SmartDashboard.getNumber(RMap.DASH_SHOOTER_AUTO_ANGLE);
	}
}

