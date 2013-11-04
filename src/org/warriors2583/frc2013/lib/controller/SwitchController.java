package org.warriors2583.frc2013.lib.controller;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.parsing.IDeviceController;
import org.warriors2583.frc2013.lib.limitswitch.ILimitSwitchSystem;

/**
 *
 * @author Austin Reuland
 */
public class SwitchController implements SpeedController, IDeviceController, PIDOutput {
	
	private final SpeedController motor;
	private final ILimitSwitchSystem switchSystem;
	
	public SwitchController(SpeedController motor, ILimitSwitchSystem switchSystem){
		this.motor = motor;
		this.switchSystem = switchSystem;
	}

	public double get() {
		return motor.get();
	}

	public void set(double speed, byte syncGroup) {
		speed = speed > 0 && !switchSystem.canUp() ? 0.00 : speed;
		speed = speed < 0 && !switchSystem.canDown() ? 0.00 : speed;
		motor.set(speed, syncGroup);
	}

	public void set(double speed) {
		speed = speed > 0 && !switchSystem.canUp() ? 0.00 : speed;
		speed = speed < 0 && !switchSystem.canDown() ? 0.00 : speed;
		motor.set(speed);
	}

	public void disable() {
		motor.disable();
	}

	public void pidWrite(double output) {
		motor.pidWrite(output);
	}
}