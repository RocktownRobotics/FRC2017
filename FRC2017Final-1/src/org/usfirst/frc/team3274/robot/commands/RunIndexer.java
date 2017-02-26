package org.usfirst.frc.team3274.robot.commands;

import org.usfirst.frc.team3274.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RunIndexer extends Command
{
    public RunIndexer()
    {
        requires(Robot.indexer);
    }

    @Override
    protected void execute()
    {
        Robot.indexer.startFeeder();
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
        Robot.indexer.stopFeeder();
    }
}