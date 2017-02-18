package org.usfirst.frc.team3274.robot.commands;

import org.usfirst.frc.team3274.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command is for testing a motor by spinning it.
 * 
 * @author Dell-Laptop-FLL
 *
 */
public class SpinMotorTest extends Command
{
    public SpinMotorTest()
    {
        requires(Robot.collector);
    }
    
    @Override
    protected void execute() {
        Robot.collector.collect();
    }

    @Override
    protected boolean isFinished() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected void end() {
        Robot.collector.stop();
    }

}
