package org.usfirst.frc.team3274.robot.commands;

import org.usfirst.frc.team3274.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3274.robot.OI;

public class LiftRobot extends Command
{
    public LiftRobot()
    {
        requires(Robot.winch);
    }

    @Override
    protected void initialize()
    {
        Robot.winch.start();
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
        Robot.winch.stop();
    }
}
