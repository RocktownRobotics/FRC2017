package org.usfirst.frc.team3274.robot.commands;

import org.usfirst.frc.team3274.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShiftUp extends Command
{
    public ShiftUp()
    {
        requires(Robot.drivepneumatics);
    }

    /**
     * Called just before this Command runs the first time.
     */
    @Override
    protected void initialize()
    {
        Robot.drivepneumatics.StartHighGear();
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
