package org.warriors2583.frc2013.lib.limitswitch;

import org.warriors2583.frc2013.lib.limitswitch.LimitSwitch.SwitchType;

/**
 *
 * @author Austin Reuland
 */
public interface StandardSwitch {
	
	public boolean state();
	
	public int getChannel();
	
	public SwitchType getType();
}
