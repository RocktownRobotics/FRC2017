package org.usfirst.frc.team3274.robot.commands;

import org.usfirst.frc.team3274.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class FeedShooter extends Command
{
    public FeedShooter()
    {
        requires(Robot.feeder);
    }

    @Override
    protected void execute()
    {
        Robot.feeder.startFeeder();
    }

    @Override
    protected boolean isFinished()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected void end()
    {
        Robot.feeder.stopFeeder();
    }

}