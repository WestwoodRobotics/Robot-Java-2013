package org.warriors2583.frc2013;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RMap {
	
	public static final int JOY_DRIVE = 1,
			JOY_SHOOT = 2,
			
			MODULE_DRIVE = 1,
			
			DRIVE_LEFT = 1,
			DRIVE_RIGHT = 2,
			
			MOTOR_SHOOTER = 3,
			MOTOR_LEADSCREW = 4,
			MOTOR_LIFT1 = 5,
			MOTOR_LIFT2 = 6,
			MOTOR_LIFT3 = 7,
		
			POT_1 = 2,
		
			SUCTION_VALVE = 1,
		 	SUCTION_ARM = 2,
		 	SUCTION_ROTATE = 3,
		 	FEEDER = 4,
		 	LIFT_VALVE = 5,
		
		 	RELAY_COMPRESSOR = 1,
		 	RELAY_LED = 2,
		 
		 	DIO_COMPRESSOR = 1,
		 	DIO_FRISBEECATCH = 5,
		 	DIO_LEADSCREWEND = 7,
		 	DIO_SHOOTERREADY = 8;

}
