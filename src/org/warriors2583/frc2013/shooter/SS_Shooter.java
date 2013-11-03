package org.warriors2583.frc2013.shooter;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.warriors2583.frc2013.RMap;
import org.warriors2583.frc2013.lib.Potentiometer;

/**
 *
 * @author Austin Reuland
 */
public class SS_Shooter extends Subsystem{
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	private static final Solenoid feederPiston = new Solenoid(RMap.MODULE_SOLENOID_MAIN, RMap.SOLENOID_FEEDER);
	private static final Victor shooterMotor = new Victor(RMap.MODULE_MOTOR, RMap.MOTOR_SHOOTER);
	
	private static final SS_Shooter instance = new SS_Shooter();
	
	public static SS_Shooter getInstance(){
		return instance;
	}
	
	static{
		//Enable safety (if program not fed, motor will stop)
		shooterMotor.setSafetyEnabled(true);
		
	}
	
	private SS_Shooter(){
		super("SS_Shooter");
	}
	
	private static double avgRPM = 0;
	private static double rawRPM = 0;
	
	private static double targetAngle = 0;
	
	public static double getAvgRPM(){
		return avgRPM;
	}
	
	public static double getRawRPM(){
		return rawRPM;
	}
	
	public static void extendFeeder(){
		feederPiston.set(false);
	}
	
	public static void retractFeeder(){
		feederPiston.set(true);
	}
	
	
	/**
	 * Get whether the feeder is extended or not
	 * @return feederPiston state
	 */
	public static boolean feederExtended(){
		return !feederPiston.get();
	}

	public void initDefaultCommand(){
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}
}
