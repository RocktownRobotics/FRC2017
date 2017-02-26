package org.usfirst.frc.team3274.robot.commands;

import org.usfirst.frc.team3274.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LowerRobot extends Command
{
    public LowerRobot()
    {
        requires(Robot.winch);
    }

    @Override
    protected void initialize()
    {
        Robot.winch.reverse();
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }

    @Override
    protected void end()
    {
        Robot.winch.stop();
    }

}
