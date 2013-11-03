package org.warriors2583.frc2013.shooter;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.warriors2583.frc2013.RMap;
import org.warriors2583.frc2013.lib.Potentiometer;

/**
 *
 * @author Austin Reuland
 */
public class SS_ShooterTray extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private static final Potentiometer shooterAngle = new Potentiometer(RMap.POT_1, RMap.POT_1_AVGBITS, RMap.POT_1_OVRBITS);
	private static final DigitalInput trayLimit = new DigitalInput(RMap.MODULE_DIO, RMap.DIO_LEADSCREWEND);
	private static final Victor leadScrew = new Victor(RMap.MODULE_MOTOR, RMap.MOTOR_LEADSCREW);

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

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}