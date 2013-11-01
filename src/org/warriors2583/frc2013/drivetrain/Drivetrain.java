package org.warriors2583.frc2013.drivetrain;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.warriors2583.frc2013.RMap;

public class Drivetrain extends Subsystem {
    
    public static final Talon motor_left, motor_right;
    
    public static final RobotDrive driveMain;
	
    public static final Drivetrain instance = new Drivetrain();

    public static Drivetrain getInstance() {
            return instance;
    }

    static {
        motor_left = new Talon(RMap.MODULE_DRIVE, RMap.DRIVE_LEFT);
	motor_right = new Talon(RMap.MODULE_DRIVE, RMap.DRIVE_RIGHT);
	
	driveMain = new RobotDrive(motor_left, motor_right);
    }
    
    public static void tank(double l, double r) {
        driveMain.tankDrive(l, r);
    }
    
    public static void arcade(double throt, double rot) {
	driveMain.arcadeDrive(throt, rot);
    }
    
    public static void drive(double mag, double curve) {
	driveMain.drive(mag, curve);
    }


    protected void initDefaultCommand() {
	// TODO Auto-generated method stub

    }

}
