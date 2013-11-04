package org.warriors2583.frc2013.lib.controller;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;
import edu.wpi.first.wpilibj.parsing.IDeviceController;
import edu.wpi.first.wpilibj.tables.ITable;
import org.warriors2583.frc2013.lib.limitswitch.ILimitSwitchSystem;

/**
 *
 * @author Austin Reuland
 */
public class LimitSwitchController_Victor implements SpeedController, IDeviceController, PIDOutput, LiveWindowSendable {
	
	private final Victor motor;
	private final ILimitSwitchSystem switchSystem;
	
	public LimitSwitchController_Victor(Victor motor, ILimitSwitchSystem switchSystem){
		this.motor = motor;
		this.switchSystem = switchSystem;
	}

	public double get() {
		return motor.get();
	}

	public void set(double speed, byte syncGroup) {
		speed = speed > 0 && !switchSystem.canUp() ? 0.00 : speed;
		speed = speed < 0 && !switchSystem.canDown() ? 0.00 : speed;
		motor.set(speed);
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

	public void updateTable() {
		motor.updateTable();
	}

	public void startLiveWindowMode() {
		motor.startLiveWindowMode();
	}

	public void stopLiveWindowMode() {
		motor.stopLiveWindowMode();
	}

	public void initTable(ITable arg0) {
		motor.initTable(arg0);
	}

	public ITable getTable() {
		return motor.getTable();
	}

	public String getSmartDashboardType() {
		return motor.getSmartDashboardType();
	}

}