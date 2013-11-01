package org.warriors2583.frc2013;

public class Teleop {
	
	public int m_loops;
	
	public Teleop(){
		m_loops = 0;
	}
	
	public void run(){
		m_loops++;
		double motor_l = Globals.m_joy1.getRawAxis(0);
		double motor_r = Globals.m_joy1.getRawAxis(1);
		int sign_l = Globals.sign(motor_l);
		int sign_r = Globals.sign(motor_r);
		motor_l = MathUtils.pow(motor_l, 2) * sign_l;
		motor_r = MathUtils.pow(motor_r, 2) * sign_r;
		Globals.m_driveMain.tankDrive(Globals.m_joy1, 0, Globals.m_joy1, 1);
	}
}
