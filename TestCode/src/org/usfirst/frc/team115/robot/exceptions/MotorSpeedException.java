package org.usfirst.frc.team115.robot.exceptions;

public class MotorSpeedException extends Exception{
	private static final long serialVersionUID = 7843672830611527699L;
	private final double speed;
	

	//states that the speed is not allowed
	public MotorSpeedException(String err, double speed) {
		super(err + "Speed of" + speed + "is prohibited.");
		this.speed = speed;
	}
	
	//returns error message
	public String getMessage() {
		return super.getMessage();
	}
	
	//returns speed of the error
	public double getSpeed() {
		return speed;
	}

}
