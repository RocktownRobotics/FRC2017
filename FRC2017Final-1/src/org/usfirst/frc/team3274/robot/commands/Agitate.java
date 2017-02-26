package org.usfirst.frc.team3274.robot.commands;

import org.usfirst.frc.team3274.robot.Robot;
import org.usfirst.frc.team3274.robot.subsystems.Agitator;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Agitate extends Command
{
    public static final double FORWARD_TURN_TIME = 2;
    public static final double REVERSE_TURN_TIME = 1;
    
    double startTime = Timer.getMatchTime();
    
    public Agitate()
    {
        requires(Robot.agitator);
    }
    
    @Override
    protected void initialize()
    {
        Robot.agitator.forward();
    }
    
    private void switchDirection()
    {
        if (Robot.agitator.getDirection() == Relay.Value.kForward && Timer.getMatchTime() - startTime >= FORWARD_TURN_TIME)
        {
            Robot.agitator.reverse();
            startTime = Timer.getMatchTime() + 0.01;
        }
        else if (Robot.agitator.getDirection() == Relay.Value.kReverse && Timer.getMatchTime() - startTime >= REVERSE_TURN_TIME)
        {
            Robot.agitator.forward();
            startTime = Timer.getMatchTime() + 0.01;
        }
    }

    @Override
    protected void execute()
    {
        switchDirection();
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
