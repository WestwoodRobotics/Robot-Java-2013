package org.warriors2583.frc2013.pneumatics;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.warriors2583.frc2013.RMap;

/**
 *
 * @author Austin Reuland
 */
public class SS_Compressor extends Subsystem {
	
	private static final Compressor compressor = new Compressor(RMap.DIO_COMPRESSOR, RMap.RELAY_COMPRESSOR);
	
	private static final SS_Compressor instance = new SS_Compressor();
	
	public static SS_Compressor getInstance() {
	return instance;
	}
	
	public static void start() {
	compressor.start();
	}
	
	public static void stop() {
	compressor.stop();
	}
	

	protected void initDefaultCommand() {
	setDefaultCommand(new C_CompressorStart());
	}
}
