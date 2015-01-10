package org.usfirst.frc.team115.robot.commands;

import org.usfirst.frc.team115.robot.Robot;

import org.usfirst.frc.team115.robot.resources.Resource115;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStraight extends Command {

	public DriveStraight() {
		this(Resource115.m_timeout);
	}
	
	public DriveStraight(double timeout){
		requires(Robot.drive);
		setTimeout(timeout);
	}

	@Override
	protected void initialize() {
		Robot.drive.reset();
	}

	@Override
	protected void execute() {
		double speed = Robot.oi.getJoystick().getY();
		Robot.drive.drive(speed, speed);
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.drive.drive(0 , 0);
	}

	@Override
	protected void interrupted() {
		end();
	}

}
