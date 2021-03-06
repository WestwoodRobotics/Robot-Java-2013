package org.wwr.frc2013.pneumatics;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.wwr.frc2013.RMap;

/**
 *
 * @author Austin Reuland
 */
public class SS_LiftHooks extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private static final Solenoid hooks = new Solenoid(RMap.MODULE_SOLENOID_MAIN, RMap.SOLENOID_LIFT_VALVE);

	private static final SS_LiftHooks instance = new SS_LiftHooks();

	public static SS_LiftHooks getInstance(){
		return instance;
	}

	static{
		
	}

	private SS_LiftHooks(){
		super("SS_LiftHooks");
	}
	
	public static boolean get(){
		return hooks.get();
	}

	public static void set(boolean var){
		hooks.set(var);
	}
	
	public static void up(){
		hooks.set(true);
	}
	
	public static void down(){
		hooks.set(false);
	}
	
	public static boolean isUp(){
		return hooks.get() == true;
	}
	
	public static boolean isDown(){
		return hooks.get() == false;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
