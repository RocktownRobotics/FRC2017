package org.usfirst.frc.team3274.robot.commands;

import org.usfirst.frc.team3274.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AgitateReverse extends Command
{
    public AgitateReverse()
    {
        requires(Robot.agitator);
    }
    
    @Override
    protected void initialize()
    {
        Robot.agitator.forward();
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
        Robot.agitator.stop();
    }
}
