package org.usfirst.frc.team3274.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.SpeedController;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.

    // Four wheels
    public static final int FRONT_LEFT_MOTOR = 1;
    public static final int FRONT_RIGHT_MOTOR = 2;
    public static final int REAR_LEFT_MOTOR = 3;
    public static final int REAR_RIGHT_MOTOR = 4;
    public static final int LEFT_MOTOR = 5;
    public static final int RIGHT_MOTOR = 6;

    // two input ports for each encoder
    public static final int[] RIGHT_ENCODER = { 7, 8 };
    public static final int[] LEFT_ENCODER = { 9, 10 };

    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
