package org.usfirst.frc.team3274.robot.commands;

import org.usfirst.frc.team3274.robot.Robot;
import org.usfirst.frc.team3274.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class RunSniperMode extends Command
{

    public RunSniperMode()
    {
        // this does not require a subsystem
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }

    @Override
    protected void initialize()
    {
        Robot.drivetrain.setSniperMode(DriveTrain.DEFAULT_SNIPER_MODE_MULTIPLIER);
    }

    @Override
    protected void end()
    {
        Robot.drivetrain.setSniperMode(1);
    }
}
