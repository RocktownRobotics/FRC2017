package org.usfirst.frc.team3274.robot.subsystems;

import org.usfirst.frc.team3274.robot.RobotMap;
import org.usfirst.frc.team3274.robot.commands.ShootWithSpeedDial;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends Subsystem
{
    public static final double SHOOTER_WHEEL_POWER = .55;

    // Set up Talons
    SpeedController _shooterWheel = new Talon(RobotMap.SHOOTER_MOTOR); // Shooter
                                                                       // wheel

    public static double shooterStart;

    public Shooter()
    {
        LiveWindow.addActuator("Shooter", "Shooter Wheel",
                (Talon) _shooterWheel);
    }

    // Checks to see if the shooter has been running long enough for the feeder
    // to run

    @Override
    protected void initDefaultCommand()
    {
        setDefaultCommand(new ShootWithSpeedDial());
    }

    // Starts the shooter wheel
    public void startShooterWheel()
    {
        shooterStart = Timer.getMatchTime();
        _shooterWheel.set(SHOOTER_WHEEL_POWER);
    }

    // Stops the shooter wheel
    public void stop()
    {
        _shooterWheel.set(0);
    }

    /**
     * 
     * @param joy a joystick with a single z axis wheel
     */
    public void speedShoot(Joystick joy)
    {
        this.speedShoot(joy.getRawAxis(2));
    }

    /**
     * Use the dial on the second controller (joystick) to control the speed of
     * the shooter
     * 
     * @param dial
     *            the dial on the seperate Joystick
     */
    public void speedShoot(double dial)
    {
        // The intervals at which it will "lock" the values of the dial (in the
        // code)
        final double[] LOCK_INTEVALS = { 0, .2, .4, .6, .8, 1 };

        double rawPower = (dial + 1) / 2; // changes range from -1 to 1, to 0 to
                                          // -1
        
        rawPower = 1 - rawPower;

        double discretePower = 0;

        if (rawPower < .2)
        {

        }

        this._shooterWheel.set(rawPower);
    }

}
