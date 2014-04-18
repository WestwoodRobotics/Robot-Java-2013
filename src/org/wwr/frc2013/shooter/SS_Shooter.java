package org.wwr.frc2013.shooter;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.wwr.frc2013.OI;
import org.wwr.frc2013.RMap;

/**
 * @see C_FeederExtend
 * @see C_FeederRetract
 * @see C_StartShooter
 * @see CG_ShootFrisbee
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
		shooterMotor.setSafetyEnabled(false);
		
	}
	
	private SS_Shooter(){
		super("SS_Shooter");
	}
	
	private static double rawRPM = 0;
	
	private static double targetSpeed = 0;
	
	public static double getAvgRPM(){
		rawRPM = (rawRPM + shooterMotor.get())/2;
		return rawRPM;
	}
	
	public static double getRawRPM(){
		return rawRPM;
	}
	
	public static double getSpeed(){
		return shooterMotor.getSpeed();
	}
	
	public static void setSpeed(double speed){
		shooterMotor.set(speed * OI.getShooterSpeedScale());
	}
	
	public static double getTargetSpeed(){
		return targetSpeed;
	}
	
	public static void setTargetSpeed(double speed){
		targetSpeed = speed;
		setSpeed(speed);
	}
	
	public static void extendFeeder(){
		feederPiston.set(false);
	}
	
	public static void retractFeeder(){
		feederPiston.set(true);
	}
	
	public static void setFeeder(boolean state){
		feederPiston.set(state);
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
		//setDefaultCommand(new C_RunShooterMotor());
	}
}
