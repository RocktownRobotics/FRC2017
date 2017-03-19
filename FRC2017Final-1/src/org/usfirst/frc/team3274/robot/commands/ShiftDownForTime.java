package org.usfirst.frc.team3274.robot.commands;

import org.usfirst.frc.team3274.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class ShiftDownForTime extends Command
{
    /** In seconds **/
    public static final double WAIT_TIME = .8;

    private double timeToReach;

    public ShiftDownForTime()
    {
        requires(Robot.drivepneumatics);
    }

    @Override
    protected void initialize()
    {
        this.timeToReach = Timer.getMatchTime() + WAIT_TIME;

        Robot.drivepneumatics.StartLowGear();
    }

    @Override
    protected boolean isFinished()
    {
        if (Timer.getMatchTime() >= this.timeToReach)
        {
            return true;
        }
        return false;
    }

    @Override
    protected void end()
    {
        Robot.drivepneumatics.stop();
    }

}
