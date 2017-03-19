package org.usfirst.frc.team3274.robot.commands;

import org.usfirst.frc.team3274.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class KickGearBackward extends Command
{
    /** In seconds **/
    public static final double WAIT_TIME = .5;

    private double timeToReach;

    public KickGearBackward()
    {
        requires(Robot.gearKicker);
    }

    @Override
    protected void initialize()
    {
        this.timeToReach = Timer.getMatchTime() + WAIT_TIME;

        Robot.gearKicker.gearReverse();
    }

    @Override
    protected void execute()
    {

    }

    @Override
    protected boolean isFinished()
    {
        return Timer.getMatchTime() >= this.timeToReach;
    }
}
