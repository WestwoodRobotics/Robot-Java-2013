package org.wwr.frc2013.drivetrain;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.wwr.frc2013.OI;
import org.wwr.frc2013.RMap;
import org.wwr.frc2013.teleop.C_TeleopDrive;

/**
 *
 * @author Austin Reuland
 */
public class SS_Drivetrain extends Subsystem {
	
	//private static final Victor motor_front_left, motor_front_right;//, motor_back_left, motor_back_right;
	
	private static final RobotDrive driveMain;
	
	private static final SS_Drivetrain instance = new SS_Drivetrain();

	public static SS_Drivetrain getInstance() {
		return instance;
	}

	static {
		//motor_front_left = new Victor(RMap.MODULE_DRIVE, RMap.DRIVE_FRONT_LEFT);
		//motor_front_right = new Victor(RMap.MODULE_DRIVE, RMap.DRIVE_FRONT_RIGHT);
        //motor_back_left = new Victor(RMap.MODULE_DRIVE, RMap.DRIVE_BACK_LEFT);
        //motor_back_right = new Victor(RMap.MODULE_DRIVE, RMap.DRIVE_BACK_RIGHT);
	
		driveMain = new RobotDrive(RMap.DRIVE_FRONT_LEFT, RMap.DRIVE_FRONT_RIGHT);
        //RMap.DRIVE_FRONT_RIGHT, RMap.DRIVE_BACK_RIGHT); //motor_front_left, motor_front_right);//, motor_back_left, motor_back_right);
	}
	
	
	private SS_Drivetrain(){
		super("SS_Drivetrain");
	}
	
	
	public static void tank(double l, double r) {
		driveMain.tankDrive(l, r);
	}
	
	public static void arcade(double throt, double rot) {
		driveMain.arcadeDrive(throt * OI.getDriveSpeedScale(), rot);
	}
	
	public static void drive(double mag, double curve) {
		driveMain.drive(mag, curve);
	}


	protected void initDefaultCommand() {
		setDefaultCommand(new C_TeleopDrive());
	}

}
