package org.usfirst.frc.team3274.robot.commands;

import org.usfirst.frc.team3274.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Collect extends Command {
    public Collect() {
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
