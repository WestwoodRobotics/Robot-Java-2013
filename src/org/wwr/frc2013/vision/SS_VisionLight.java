package org.wwr.frc2013.vision;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.wwr.frc2013.RMap;

/**
 * @see C_VisionLightOff
 * @see C_VisionLightOn
 * @author Austin Reuland
 */
public class SS_VisionLight extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private static final Relay ledRing;

	private static final SS_VisionLight instance = new SS_VisionLight();

	public static SS_VisionLight getInstance(){
		return instance;
	}

	static{
		 ledRing = new Relay(RMap.MODULE_RELAY, RMap.RELAY_LED, Relay.Direction.kForward);
	}
	private SS_VisionLight(){
		super("SS_VisionLight");
	}
	
	public static void lightOn(){
		ledRing.set(Relay.Value.kOn);
	}
	
	public static void lightOff(){
		ledRing.set(Relay.Value.kOff);
	}
	
	public static boolean isOn(){
		return ledRing.get() == Relay.Value.kOn;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
