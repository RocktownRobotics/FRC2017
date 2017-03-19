package org.usfirst.frc.team3274.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.

    ////////////////////////////////////////////////
    ///////////// JOYSTICK AXIS ////////////////////
    ////////////////////////////////////////////////
    
    // xbox controller
    public static final int XBOX_LEFT_Y_AXIS = 1;
    public static final int XBOX_RIGHT_X_AXIS = 4;
    
    // flight stick
    public static final int FLIGHT_STICK_FORWARD_AXIS = 1;
    public static final int FLIGHT_STICK_THROTTLE_AXIS = 2;
    
    
    ////////////////////////////////////////////////
    //////////// CAN TALONS BELOW HERE//////////////
    ////////////////////////////////////////////////

    // Four wheels
    public static final int FRONT_LEFT_MOTOR = 1;
    public static final int FRONT_RIGHT_MOTOR = 2;
    public static final int REAR_LEFT_MOTOR = 3;
    public static final int REAR_RIGHT_MOTOR = 4;
    public static final int LEFT_MOTOR = 5;
    public static final int RIGHT_MOTOR = 6;

    ////////////////////////////////////////////////
    /////////////// DIO's BELOW HERE////////////////
    ////////////////////////////////////////////////

    // two input ports for each encoder
    public static final int[] RIGHT_ENCODER = { 4, 5 };
    public static final int[] LEFT_ENCODER = { 0, 1 };
    // Touchless Encoder (the second channel is irrelevant)
    public static final int[] TL_ENCODER = { 8, 9 };

    ////////////////////////////////////////////////
    /////////////// PWM's BELOW HERE////////////////
    ////////////////////////////////////////////////

    // collector
    public static final int COLLECTOR_MOTOR = 0;

    // shooter
    public static final int SHOOTER_MOTOR = 1;

    // feeder
    public static final int INDEXING_MOTOR = 2;

    // winch
    public static final int WINCH_MOTOR = 3;

    ////////////////////////////////////////////////
    /////////////// PCM's BELOW HERE////////////////
    ////////////////////////////////////////////////
    public static int gateDrop = 0;
    public static int gateRaise = 1;
    public static int shifterForward = 3;
    public static int shifterReverse = 4;
    public static int gearForward = 6;
    public static int gearReverse = 7;
    
    ////////////////////////////////////////////////
    ////////////// Relays BELOW HERE////////////////
    ////////////////////////////////////////////////
    
    // agitator
    public static final int SPIKE = 0;

    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
