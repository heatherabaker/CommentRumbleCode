package org.usfirst.frc.team115.robot.subsystems;

import java.util.ArrayList;

import org.usfirst.frc.team115.robot.exceptions.MotorSpeedException;
import org.usfirst.frc.team115.robot.resources.Resource115;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class VBusMotorSystem extends Subsystem {
	protected ArrayList<CANTalon> motors = new ArrayList<CANTalon>();
	private double speed;
	protected boolean invert;
	
	public void stop() {
		//for all CANTalon motors set the value to 0
		for (CANTalon motor : motors)
			motor.set(0);
	}
		
	public void setSpeed(double speed) throws MotorSpeedException {
		this.speed = speed;
		//if the absolute value of the speed is less than one then it sets the speed
		if (Math.abs(speed) <= 1) {
			for (CANTalon motor : motors) {
				motor.set((invert ? -1 : 1) * this.speed);
			}
		}
		//if the speed is not less than one then will send an error to the calling function
		else {
				throw new MotorSpeedException(Resource115.m_error1, speed);
		}
	}
	
	//gets the speed
	public double getSpeed(){
		return speed;
	}
	
	//sets whether the system is inverted
	public void setInverted(boolean invert){
		this.invert = invert;
	}
	
	//returns inverted
	public boolean isInverted(){
		return invert;
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

		


}
