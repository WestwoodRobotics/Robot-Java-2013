package org.warriors2583.frc2013.lib;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.warriors2583.frc2013.RMap;
import org.warriors2583.frc2013.pneumatics.SS_Compressor;
import org.warriors2583.frc2013.shooter.SS_Shooter;
import org.warriors2583.frc2013.shooter.SS_ShooterTray;

/**
 *
 * @author Austin Reuland
 */
public class SS_Dashboard extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	
	private static final String memMax;
	private static final SS_Dashboard instance = new SS_Dashboard();

	public static SS_Dashboard getInstance(){
		return instance;
	}

	static{
		memMax = String.valueOf((MathUtils.round(((double)Runtime.getRuntime().totalMemory()/1048576) * 1e2))/1e2) + "M";
	}
	
	public static void update(){
		SmartDashboard.putNumber(RMap.DASH_SHOOTER_ANGLE, SS_ShooterTray.getAngle());
		SmartDashboard.putNumber(RMap.DASH_SHOOTER_SPEED, SS_Shooter.getSpeed());
		SmartDashboard.putBoolean(RMap.DASH_SHOOTER_LIMIT, SS_ShooterTray.atLimit());
		SmartDashboard.putBoolean(RMap.DASH_COMPRESSOR_RUNNING, SS_Compressor.isRunning());
		double memFree = ((MathUtils.round(((double)Runtime.getRuntime().freeMemory()/1048576) * 1e2))/1e2);
		SmartDashboard.putString(RMap.DASH_MEMORY_STATUS, memFree + "M/" + memMax);
	}

	private SS_Dashboard(){
		super("SS_Dashboard");
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new C_UpdateDashboard());
    }
}
