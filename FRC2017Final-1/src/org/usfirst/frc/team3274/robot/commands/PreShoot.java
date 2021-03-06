package org.usfirst.frc.team3274.robot.commands;

import org.usfirst.frc.team3274.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class PreShoot extends Command
{
    public PreShoot()
    {
        requires(Robot.shooter);
    }

    @Override
    protected void initialize()
    {
        Robot.shooter.startShooterWheel();
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
        Robot.shooter.stop();
    }
}
