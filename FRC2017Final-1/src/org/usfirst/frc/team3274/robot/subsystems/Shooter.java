package org.usfirst.frc.team3274.robot.subsystems;

import org.usfirst.frc.team3274.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

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
        // TODO Auto-generated method stub
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
}
