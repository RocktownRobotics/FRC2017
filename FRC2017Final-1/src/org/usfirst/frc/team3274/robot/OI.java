package org.usfirst.frc.team3274.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team3274.robot.commands.Collect;
import org.usfirst.frc.team3274.robot.commands.DriveForward;
import org.usfirst.frc.team3274.robot.commands.ExampleCommand;
import org.usfirst.frc.team3274.robot.commands.FeedShooter;
import org.usfirst.frc.team3274.robot.commands.LiftRobot;
import org.usfirst.frc.team3274.robot.commands.PreShoot;
import org.usfirst.frc.team3274.robot.subsystems.Winch;
import edu.wpi.first.wpilibj.Timer;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    /*
     * ----- button map ----- here are the button codes for the xbox controller
     * a - 0 b - 1 x - 2 y - 3 left bumper - 4 right bumper - 5 left trigger - 6
     * right trigger - 7 select / back - 8 start - 9 left analogue stick press -
     * 10 right analogue stick press - 11 dpad up - 12 dpad down - 13 dpad left
     * - 14 dpad right - 15
     */

    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a
    //// joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    /* Nathan make some buttons */
    Joystick joyStick = new Joystick(0); // set to ID 1
    JoystickButton a = new JoystickButton(joyStick, 1);
    JoystickButton b = new JoystickButton(joyStick, 2);
    JoystickButton x = new JoystickButton(joyStick, 3);
    JoystickButton y = new JoystickButton(joyStick, 4);
    JoystickButton lBumper = new JoystickButton(joyStick, 5);
    JoystickButton rBumper = new JoystickButton(joyStick, 6);
    JoystickButton up = new JoystickButton(joyStick, 13);
    JoystickButton down = new JoystickButton(joyStick, 14);
    JoystickButton left = new JoystickButton(joyStick, 15);
    JoystickButton right = new JoystickButton(joyStick, 16);

    // Commands
    public OI() {
        
        if (Robot.winch.isWinchRunning() == false) {
            a.toggleWhenPressed(new PreShoot());
            b.whileHeld(new FeedShooter());
            x.toggleWhenPressed(new Collect());
        }
        y.whileHeld(new LiftRobot());
    }

    // In DriverStation
    public Joystick getJoystick() {
        return this.joyStick;
    }
}
