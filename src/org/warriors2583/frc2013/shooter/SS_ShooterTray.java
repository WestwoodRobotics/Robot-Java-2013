package org.warriors2583.frc2013.shooter;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.warriors2583.frc2013.RMap;
import org.warriors2583.frc2013.lib.Potentiometer;
import org.warriors2583.frc2013.lib.controller.LimitSwitchController;
import org.warriors2583.frc2013.lib.limitswitch.LimitSwitch;
import org.warriors2583.frc2013.lib.limitswitch.LimitSwitch.SwitchType;
import org.warriors2583.frc2013.lib.limitswitch.SingleLimitSwitchSystem;
import org.warriors2583.frc2013.lib.limitswitch.SingleLimitSwitchSystem.SingleSystemType;

/**
 *
 * @author Austin Reuland
 */
public class SS_ShooterTray extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private static final Potentiometer shooterAngle = new Potentiometer(RMap.POT_1, RMap.POT_1_AVGBITS, RMap.POT_1_OVRBITS);
	private static final LimitSwitchController leadScrew = new LimitSwitchController(new Victor(RMap.MODULE_MOTOR, RMap.MOTOR_LEADSCREW),
			new SingleLimitSwitchSystem(new LimitSwitch(RMap.DIO_LEADSCREWEND, SwitchType.NO), SingleSystemType.TOP));

	private static final SS_ShooterTray instance = new SS_ShooterTray();

	public static SS_ShooterTray getInstance(){
		return instance;
	}

	static{
		
	}

	private SS_ShooterTray(){
		super("SS_ShooterTray");
	}
	
	private static double targetAngle = 0;
	
	public static void setTargetAngle(double angle){
		targetAngle = angle;
	}
	
	public static double getTargetAngle(){
		return targetAngle;
	}
	
	public static double getAngle(){
		return shooterAngle.getAverage() * 60.0;
	}
		
	public static int getDirToTarget(){
		if(getAngle() >= targetAngle) return -1;
		if(getAngle() < targetAngle) return 1;
		return 0;
	}
	
	private static final double atRange = 3.5;
	
	public static boolean atTarget(){
		return Math.abs(getAngle() - targetAngle) < atRange;
	}

	public static boolean atLimit(){
		return leadScrew.atLimit();
	}
	
	public static void holdPos(){
		leadScrew.set(0);
	}
	
	public static void move(double speed){
		leadScrew.set(speed);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}