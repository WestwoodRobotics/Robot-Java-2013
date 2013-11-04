package org.warriors2583.frc2013.lib.limitswitch;

import org.warriors2583.frc2013.lib.limitswitch.LimitSwitch.SwitchType;

/**
 *
 * @author Austin Reuland
 */
public class DualLimitSwitchSystem implements ILimitSwitchSystem{
	
	private LimitSwitch topSwitch, bottomSwitch;

	public DualLimitSwitchSystem(int topChannel, SwitchType topType, int bottomChannel, SwitchType bottomType){
		this(new LimitSwitch(topChannel, topType), new LimitSwitch(bottomChannel, bottomType));
	}
	
	public DualLimitSwitchSystem(int topModule, int topChannel, SwitchType topType,
			int bottomModule, int bottomChannel, SwitchType bottomType){
		this(new LimitSwitch(topModule, topChannel, topType),
				new LimitSwitch(bottomModule, bottomChannel, bottomType));
	}
	
	public DualLimitSwitchSystem(LimitSwitch top, LimitSwitch bottom){
		topSwitch = top;
		bottomSwitch = bottom;
	}
	
	public boolean canUp() {
		return !topSwitch.state();
	}

	public boolean canDown() {
		return !bottomSwitch.state();
	}

}