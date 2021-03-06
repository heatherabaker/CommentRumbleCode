package org.usfirst.frc.team115.robot;

import org.usfirst.frc.team115.robot.commands.ArcadeDriveWithJoystick;
import org.usfirst.frc.team115.robot.commands.DriveStraight;
import org.usfirst.frc.team115.robot.commands.FireMotor;
import org.usfirst.frc.team115.robot.commands.StopMotor;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI {
	private Joystick joystick;
	private JoystickButton shoot;
	
	public OI() {
		//initializing the joystick and passing the value of JOYSTICK from the RobotMap
		joystick = new Joystick(RobotMap.JOYSTICK);
		shoot = new JoystickButton(joystick, RobotMap.TRIGGER_BUTTON_SHOOT);
		
		shoot.whenPressed(new FireMotor());
		shoot.whenReleased(new StopMotor());
		
		SmartDashboard.putData("DriveStraight", new DriveStraight());
		SmartDashboard.putData("ArcadeDriveWithJoystick", new ArcadeDriveWithJoystick());
		SmartDashboard.putData("FireMotor", new FireMotor());
		SmartDashboard.putData("StopMotor", new StopMotor());
		
	}
	
	public Joystick getJoystick() {
		return joystick;
	}
    /** CREATING BUTTONS
    One type of button is a joystick button which is any button on a joystick.
    You create one by telling it which joystick it's on and which button
    number it is.
    Joystick stick = new Joystick(port);
    Button button = new JoystickButton(stick, buttonNumber);
    
    There are a few additional built in buttons you can use. Additionally,
    by subclassing Button you can create custom triggers and bind those to
    commands the same as any other Button.
    
       TRIGGERING COMMANDS WITH BUTTONS
    Once you have a button, it's trivial to bind it to a button in one of
    three ways:
    
    Start the command when the button is pressed and let it run the command
    until it is finished as determined by it's isFinished method.
    button.whenPressed(new ExampleCommand());
    
    Run the command while the button is being held down and interrupt it once
    the button is released.
    button.whileHeld(new ExampleCommand());
    
    Start the command when the button is released  and let it run the command
    until it is finished as determined by it's isFinished method.
    button.whenReleased(new ExampleCommand()); **/
}

