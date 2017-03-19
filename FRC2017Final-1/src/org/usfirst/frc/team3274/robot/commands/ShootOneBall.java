package org.usfirst.frc.team3274.robot.commands;

import org.usfirst.frc.team3274.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class ShootOneBall extends Command
{
    double interval = 0;
    double startTime;
    public ShootOneBall(double seconds)
    {
        requires(Robot.indexer);
        interval = seconds;
        startTime = Timer.getMatchTime();
    }
    
    @Override
    protected void initialize()
    {
        Robot.indexer.startFeeder();
    }
    
    @Override
    protected void execute()
    {
        
    }
    
    @Override
    protected boolean isFinished()
    {
        return (Timer.getMatchTime() - startTime >= interval);
    }
    
    @Override
    protected void end()
    {
        Robot.indexer.stopFeeder();
    }
    
}
