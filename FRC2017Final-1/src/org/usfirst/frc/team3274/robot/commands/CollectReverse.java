package org.usfirst.frc.team3274.robot.commands;

import org.usfirst.frc.team3274.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CollectReverse extends Command
{
    public CollectReverse()
    {
        requires(Robot.collector);
    }

    @Override
    protected void execute()
    {
        Robot.collector.collectReverse();
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
        Robot.collector.stop();
    }
}
