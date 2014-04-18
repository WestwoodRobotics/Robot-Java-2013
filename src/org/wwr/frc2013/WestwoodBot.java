
package org.wwr.frc2013;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.wwr.frc2013.autonomous.CG_AutonomousShoot;
import org.wwr.robolib.robot.AutonMode;
import org.wwr.robolib.robot.Robot;
import org.wwr.robolib.robot.TeleopMode;
import org.wwr.robolib.util.DSInfo;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class WestwoodBot extends Robot {

    public WestwoodBot(){
        super("Slick Shot", "1.3.1");
    }
    
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	OI oi = new OI();
	public void robotInit(){    	
		enableWatchdog(true);
        compressor(RMap.DIO_COMPRESSOR, RMap.RELAY_COMPRESSOR);

        new AutonMode(){
            CommandGroup auton = new CG_AutonomousShoot();
            public void init() {auton.start();}
            public void run() {}
            public void end() {auton.cancel();}
        };
        
        new TeleopMode(){
            
            public void init(){}
            public void run(){
                DSInfo.printLCDLine1(OI.getJDriveLeftY());
                DSInfo.printLCDLine2(OI.getJDriveRightX());
            }
            public void end(){}
        };
        
    }
}
