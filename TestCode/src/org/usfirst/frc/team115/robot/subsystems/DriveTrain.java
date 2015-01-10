package org.usfirst.frc.team115.robot.subsystems;

import org.usfirst.frc.team115.robot.RobotMap;
import org.usfirst.frc.team115.robot.commands.ArcadeDriveWithJoystick;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

//extends is inherit basically inherits the characteristics of a subsystem
public class DriveTrain extends Subsystem {
	//CANTalon is already established in the FRC library so just have to import. This code establishes there is 4 motors
	private CANTalon[] motors = new CANTalon[4];
	//gives numbers to all the motors and establishes as variables
	private final int FrontRight = 0;
	private final int FrontLeft = 1;
	private final int BackRight = 2;
	private final int BackLeft = 3;
	//declared a new object that is of type RobotDrive that is named drive
	private RobotDrive drive;
	
	
	public DriveTrain() {
		//super calls the constructor of the base class which is the class subsystem
		super();
		/*initializing the 4 motors that are needed for the RobotDrive
		*then it is assigning it numbers 
		*the numbers are passed in as parameters from the RobotMap
		*these numbers are the numbers that are assigned to the physical robot (labeled with stickers)
		*it is important to follow these assigned numbers so that everything connects
		*/
		motors[FrontRight] = new CANTalon(RobotMap.FRONTRIGHTMOTOR);
		motors[FrontLeft] = new CANTalon(RobotMap.FRONTLEFTMOTOR);
		motors[BackRight] = new CANTalon(RobotMap.BACKRIGHTMOTOR);
		motors[BackLeft] = new CANTalon(RobotMap.BACKLEFTMOTOR);
		drive = new RobotDrive(motors[FrontRight],motors[FrontLeft],motors[BackLeft],motors[BackRight]);
	}
	
	
	//method that calls arcadeDrive and sets the speed for left and right motors
	//void means that you don't return anything
	//double makes the number larger in value
	public void drive(double left, double right) {
		drive.arcadeDrive(left,right);
	}
	
	
	//method that calls arcadeDrive with joystick as a parameter
	//Overloads the drive function
	//Basically meaning that java will look at the type of the parameter and decides which drive to call
	public void drive(Joystick joystick){
		drive.arcadeDrive(joystick);
	}
	
	public void reset() {}
	
	//method that initiates a default command
	//uses the ArcaderiveWithJoystick as the parameter for setting a default command
	protected void initDefaultCommand() {
		setDefaultCommand(new ArcadeDriveWithJoystick());
	}
	
	
	//get the current of all the motors in the motor array which in this case is 4 motors
	public double getCurrent() {
		double current = 0;
		//for all motors in the motor array, so the number of times this loop runs is equal to the number of motors in the array
		for (CANTalon motor : motors)
			//the current current is added to the current of the next motor in the array
			current += motor.getOutputCurrent();
		return current;
	}

}
