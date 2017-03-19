package org.usfirst.frc.team3274.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team3274.robot.commands.Agitate;
import org.usfirst.frc.team3274.robot.commands.AgitateReverse;
import org.usfirst.frc.team3274.robot.commands.Collect;
import org.usfirst.frc.team3274.robot.commands.CollectReverse;
import org.usfirst.frc.team3274.robot.commands.LiftRobot;
import org.usfirst.frc.team3274.robot.commands.LowerRobot;
import org.usfirst.frc.team3274.robot.commands.PreShoot;
import org.usfirst.frc.team3274.robot.commands.RunIndexer;
import org.usfirst.frc.team3274.robot.commands.RunSniperMode;
import org.usfirst.frc.team3274.robot.commands.ShiftDown;
import org.usfirst.frc.team3274.robot.commands.ShiftUp;
import org.usfirst.frc.team3274.robot.subsystems.AgitateFoward;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{
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

    /** +- 0, dead zone for joystick input **/
    public static final double DEAD_ZONE = 0.1;

    /** The first joystick. Has to be an xbox controller. **/
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
    JoystickButton start = new JoystickButton(joyStick, 7);
    JoystickButton back = new JoystickButton(joyStick, 8);

// /** The second joystick. Has to be an xbox controller. **/
// Joystick joyStick2 = new Joystick(1); // set to ID 1
// JoystickButton a2 = new JoystickButton(joyStick, 1);
// JoystickButton b2 = new JoystickButton(joyStick, 2);
// JoystickButton x2 = new JoystickButton(joyStick, 3);
// JoystickButton y2 = new JoystickButton(joyStick, 4);
// JoystickButton lBumper2 = new JoystickButton(joyStick, 5);
// JoystickButton rBumper2 = new JoystickButton(joyStick, 6);
// JoystickButton up2 = new JoystickButton(joyStick, 13);
// JoystickButton down2 = new JoystickButton(joyStick, 14);
// JoystickButton left2 = new JoystickButton(joyStick, 15);
// JoystickButton right2 = new JoystickButton(joyStick, 16);
// JoystickButton start2 = new JoystickButton(joyStick, 7);
// JoystickButton back2 = new JoystickButton(joyStick, 8);

    /** Has to be a flight stick controller. **/
    Joystick joyStick2 = new Joystick(1); // set to ID 2...?
    JoystickButton trigger = new JoystickButton(joyStick2, 1);
    JoystickButton button2 = new JoystickButton(joyStick2, 2);
    JoystickButton button3 = new JoystickButton(joyStick2, 3);
    JoystickButton button4 = new JoystickButton(joyStick2, 4);
    JoystickButton button5 = new JoystickButton(joyStick2, 5);
    JoystickButton button6 = new JoystickButton(joyStick2, 6);
    JoystickButton button8 = new JoystickButton(joyStick2, 8);
    JoystickButton button9 = new JoystickButton(joyStick2, 9);
// JoystickButton button11 = new JoystickButton(joyStick2, 11);
// JoystickButton button12= new JoystickButton(joyStick2, 12);

    /** Has to be a flight sick controller. **/
    Joystick joyStick3 = new Joystick(2);

    // Commands
    public OI()
    {
        initDoubleJoystickSetup();
    }

    /**
     * For two controllers, one is an xbox controller and the other is a flight
     * stick.
     */
    private void initDoubleJoystickSetup()
    {
        if (Robot.winch.isWinchRunning() == false)

        {
            button3.whileHeld(new RunIndexer()); // change to button 4
            button6.toggleWhenPressed(new RunIndexer());
            button2.toggleWhenPressed(new Agitate());
// button11.toggleWhenPressed(new AgitateReverse());
// button12.toggleWhenPressed(new AgitateFoward());
            x.toggleWhenPressed(new Collect());
            b.toggleWhenPressed(new CollectReverse());
            trigger.toggleWhenPressed(new PreShoot());
            a.toggleWhenPressed(new RunSniperMode());
        }

        // shifting gears
        lBumper.whileHeld(new ShiftDown());
        rBumper.whileHeld(new ShiftUp());

        // running winch
        button9.whileHeld(new LiftRobot());
        button8.whileHeld(new LowerRobot());
    }

// private void initDoubleXboxSetup()S// {
// if (Robot.winch.isWinchRunning() == false)
// {
// a.whileHeld(new RunIndexer());
// y.toggleWhenPressed(new RunIndexer());
// button2.toggleWhenPressed(new Agitate());
// x.toggleWhenPressed(new Collect());
// b.toggleWhenPressed(new CollectReverse());
// trigger.toggleWhenPressed(new PreShoot());
// a.toggleWhenPressed(new RunSniperMode());
// }
//
// // shifting gears
// lBumper.whileHeld(new ShiftDown());
// rBumper.whileHeld(new ShiftUp());
//
// // running winch
// button9.whileHeld(new LiftRobot());
// button8.whileHeld(new LowerRobot());
// }

    /**
     * OI setup for a single xbox controller.
     */
    private void initSingleJoystickSetup()
    {
        if (Robot.winch.isWinchRunning() == false)
        {
            a.toggleWhenPressed(new PreShoot());
            rBumper.whileHeld(new RunIndexer());
            x.toggleWhenPressed(new Collect());
            b.whileHeld(new ShiftUp());
        }
        y.whileHeld(new LiftRobot());
    }

    /**
     * Causes the joystick to rumble.
     */
    public void rumbleJoyStick(boolean rumble)
    {
        if (rumble)
        {
            this.joyStick.setRumble(GenericHID.RumbleType.kLeftRumble, 1);
        } else
        {
            this.joyStick.setRumble(GenericHID.RumbleType.kLeftRumble, 0);
        }
    }

    /**
     * Joystick 1 has to be an xbox controller.
     * 
     * @return
     */
    public Joystick getJoystick()
    {
        return this.joyStick;
    }

    /**
     * Joystick 2 has to be a flightstick.
     * 
     * @return
     */
    public Joystick getJoystick2()
    {
        return this.joyStick2;
    }

    /**
     * Joystick 3 has to be a flightstick.
     * 
     * @return
     */
    public Joystick getJoystick3()
    {
        return this.joyStick3;
    }
}
