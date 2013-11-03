package org.warriors2583.frc2013.lib.limitswitch;

import org.warriors2583.frc2013.lib.limitswitch.LimitSwitch.SwitchType;

/**
 *
 * @author Austin Reuland
 */
public class SingleLimitSwitchSystem implements LimitSwitchInterface{
	
	public static class SingleSystemType{
		private final int type;
		private SingleSystemType(int type){
			this.type = type;
		}
		public int getType(){
			return type;
		}
		public boolean canUp(){
			return type == 1;
		}
		public boolean canDown(){
			return type == 2;
		}
		public static final SingleSystemType
				TOP = new SingleSystemType(1),
				BOTTOM = new SingleSystemType(2);
	}
	
	private LimitSwitch limitSwitch;
	private SingleSystemType type;

	public SingleLimitSwitchSystem(int channel, SwitchType type){
		this(new LimitSwitch(channel, type));
	}
	
	public SingleLimitSwitchSystem(int module, int channel, SwitchType type){
		this(new LimitSwitch(module, channel, type));
	}
	
	public SingleLimitSwitchSystem(LimitSwitch limitSwitch){
		this.limitSwitch = limitSwitch;
	}
	
	public boolean canUp() {
		return !limitSwitch.state();
	}

	public boolean canDown() {
		return !limitSwitch.state();
	}

}