package org.usfirst.frc.team3274.robot.commands;

import org.usfirst.frc.team3274.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class LowerGearGate extends Command
{
    /** In seconds **/
    public static final double WAIT_TIME = .5;

    private double timeToReach;
    
    public LowerGearGate()
    {
        requires(Robot.gearGate);
    }

    @Override
    protected void initialize()
    {
        this.timeToReach = Timer.getMatchTime() + WAIT_TIME;
        
        if (Robot.gearGate.getGateIsDown() == false)
        {
            Robot.gearGate.dropGate();
        }
    }
    
    @Override
    protected boolean isFinished()
    {
        return Timer.getMatchTime() >= this.timeToReach;
    }
}
