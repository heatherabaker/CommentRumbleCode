package org.usfirst.frc.team115.robot.commands;

import org.usfirst.frc.team115.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StopMotor extends Command {

	public StopMotor() {
		requires(Robot.shooter);
	}

	@Override
	protected void initialize() {
		Robot.shooter.stop();
	}

	@Override
	protected void execute() {}

	@Override
	protected boolean isFinished() {
		//returns true because only care about initialization
		//it stops at the initialization so after initialization it's finished
		return true;
	}

	@Override
	protected void end() {}

	@Override
	protected void interrupted() {}

}
