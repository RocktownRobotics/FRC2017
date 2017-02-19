package org.usfirst.frc.team3274.robot.subsystems;

import org.usfirst.frc.team3274.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Winch extends Subsystem
{
    // Sets up the Talon
    SpeedController _winch = new Talon(RobotMap.WINCH_MOTOR);

    // Sets the speed for the winch
    private double liftSpeed = .999;
    private double reverseSpeed = -.999;
    private boolean isWinchRunning = false;

    public Winch()
    {
        LiveWindow.addActuator("Winch", "Lifter", (Talon) _winch);
    }

    @Override
    protected void initDefaultCommand()
    {
        // TODO Auto-generated method stub
    }

    /**
     * Starts the winch
     */
    public void start()
    {
        _winch.set(liftSpeed);
        isWinchRunning = true;
    }

    /**
     * Runs the winch in reverse
     */
    public void reverse()
    {
        _winch.set(reverseSpeed);
        isWinchRunning = true;
    }

    /**
     * Stops the winch
     */
    public void stop()
    {
        _winch.set(0);
        isWinchRunning = false;
    }

    /**
     * Returns if the winch is running
     */
    public boolean isWinchRunning()
    {
        return isWinchRunning;
    }
}
