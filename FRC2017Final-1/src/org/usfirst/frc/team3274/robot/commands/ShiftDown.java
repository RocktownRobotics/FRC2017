package org.usfirst.frc.team3274.robot.commands;

import org.usfirst.frc.team3274.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShiftDown extends Command
{
    public ShiftDown()
    {
        requires(Robot.drivepneumatics);
    }

    @Override
    protected void initialize() {
        Robot.drivepneumatics.StartLowGear();
    }
    
    @Override
    protected boolean isFinished()
    {
        
        return true;
    }
    
    @Override
    protected void end() {
        Robot.drivepneumatics.stop();
    }

}
