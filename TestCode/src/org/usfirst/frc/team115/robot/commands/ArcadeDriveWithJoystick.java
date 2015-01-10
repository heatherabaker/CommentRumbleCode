package org.usfirst.frc.team115.robot.commands;

import org.usfirst.frc.team115.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArcadeDriveWithJoystick extends Command {
	
	
	public ArcadeDriveWithJoystick() {
		//ArcadeDriveWithJoystick requires the Robot.drive to command
		requires(Robot.drive);
	}
	
	
	protected void execute() {
		Robot.drive.drive(Robot.oi.getJoystick());
	}
	
	
	protected boolean isFinished() {
		//will run until is interrupted
		return false;
	}
	
	protected void end() {
		//stops the robot 
		Robot.drive.drive(0 , 0);
	}


	@Override
	protected void initialize() {
	}


	@Override
	protected void interrupted() {
		end();
		
	}


}
