package org.warriors2583.frc2013.lib.limitswitch;

import org.warriors2583.frc2013.lib.limitswitch.LimitSwitch.SwitchType;

/**
 *
 * @author Austin Reuland
 */
public class SingleLimitSwitchSystem implements ILimitSwitchSystem{
	
	public static class SingleSystemType{
		private final int type;
		private SingleSystemType(int type){
			this.type = type;
		}
		public int getType(){
			return type;
		}
		public static final SingleSystemType
				TOP = new SingleSystemType(1),
				BOTTOM = new SingleSystemType(2);
	}
	
	private LimitSwitch limitSwitch;
	private SingleSystemType type;
	
	public static final int SYSTEM_TOP = 1, SYSTEM_BOTTOM = 2;

	public SingleLimitSwitchSystem(int channel, SwitchType switchType, SingleSystemType systemType){
		this(new LimitSwitch(channel, switchType), systemType);
	}
	
	public SingleLimitSwitchSystem(int module, int channel, SwitchType switchType, SingleSystemType systemType){
		this(new LimitSwitch(module, channel, switchType), systemType);
	}
	
	public SingleLimitSwitchSystem(LimitSwitch limitSwitch, SingleSystemType type){
		this.limitSwitch = limitSwitch;
		this.type = type;
	}
	
	public boolean canUp() {
		if(type == SingleSystemType.BOTTOM) return true;
		return !limitSwitch.state();
	}

	public boolean canDown() {
		if(type == SingleSystemType.TOP) return true;
		return !limitSwitch.state();
	}

}
