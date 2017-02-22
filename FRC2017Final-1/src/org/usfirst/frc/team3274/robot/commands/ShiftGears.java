package org.usfirst.frc.team3274.robot.commands;

import org.usfirst.frc.team3274.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShiftGears extends Command
{
    public ShiftGears()
    {
        requires(Robot.drivepneumatics);
    }

    @Override
    protected void initialize() {
        Robot.drivepneumatics.ShiftGears();
    }
    
    @Override
    protected void execute()
    {
        
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }

    @Override
    protected void end()
    {
        Robot.drivepneumatics.stop();
    }
}
