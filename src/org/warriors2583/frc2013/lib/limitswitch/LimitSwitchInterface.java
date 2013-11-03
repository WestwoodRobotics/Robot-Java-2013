package org.warriors2583.frc2013.lib.limitswitch;

/**
 *
 * @author Austin Reuland
 */
public interface LimitSwitchInterface {
	/**
	 * 
	 * @return Can we go Up
	 */
	public boolean canUp();
	
	/**
	 * 
	 * @return Can we go Down 
	 */	
	public boolean canDown();
	
}
