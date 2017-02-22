package org.usfirst.frc.team3274.robot.commands;

import org.usfirst.frc.team3274.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShootWithSpeedDial extends Command
{
    public ShootWithSpeedDial()
    {
        requires(Robot.shooter);
    }

    @Override
    protected void execute()
    {
        Robot.shooter.speedShoot(Robot.oi.getJoystick2());
    }

    @Override
    protected boolean isFinished()
    {
        // TODO Auto-generated method stub
        return false;
    }
}
