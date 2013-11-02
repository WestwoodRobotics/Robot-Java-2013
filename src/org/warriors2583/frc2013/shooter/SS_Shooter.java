package org.warriors2583.frc2013.shooter;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.warriors2583.frc2013.RMap;

/**
 *
 * @author Austin Reuland
 */
public class SS_Shooter extends Subsystem{
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public static final Solenoid feederPiston = new Solenoid(RMap.MODULE_SOLENOID_MAIN, RMap.SOLENOID_FEEDER);
    public static final Victor shooterMotor = new Victor(RMap.MODULE_MOTOR, RMap.MOTOR_SHOOTER);
    
    public static final SS_Shooter instance = new SS_Shooter();
    
    public static SS_Shooter getInstance(){
	return instance;
    }
    
    static{
	
    }
    
    private SS_Shooter(){
	super("Shooter");
    }

    public void initDefaultCommand(){
        // Set the default command for a subsystem here.
	//setDefaultCommand(new MySpecialCommand());
    }
}