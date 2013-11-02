package org.warriors2583.frc2013.pneumatics;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.warriors2583.frc2013.RMap;

/**
 *
 * @author Austin Reuland
 */
public class Compressor extends Subsystem {
    
    private static final edu.wpi.first.wpilibj.Compressor compressor = new edu.wpi.first.wpilibj.Compressor(RMap.DIO_COMPRESSOR, RMap.RELAY_COMPRESSOR);
    
    private static final Compressor instance = new Compressor();
    
    public static Compressor getInstance() {
	return instance;
    }
    
    public static void start() {
	compressor.start();
    }
    
    public static void stop() {
	compressor.stop();
    }
    

    protected void initDefaultCommand() {
	setDefaultCommand(new Command_CompressorStart());
    }
}
