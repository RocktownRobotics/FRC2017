package org.usfirst.frc.team3274.robot.commands;

import org.usfirst.frc.team3274.robot.Robot;
import org.usfirst.frc.team3274.robot.subsystems.RobotCompressor;

import edu.wpi.first.wpilibj.command.Command;

public class Compress extends Command
{

    @Override
    protected boolean isFinished()
    {
        // TODO Auto-generated method stub
        return false;
    }

//    private boolean started;
//
//    public Compress()
//    {
//        requires(Robot.robotCompressor);
//    }
//
//    @Override
//    protected void initialize()
//    {
//        started = false;
//    }
//
//    private void startCompressor()
//    {
//        Robot.robotCompressor.start();
//        started = true;
//    }
//
//    private void stopCompressor()
//    {
//        Robot.robotCompressor.stop();
//        started = false;
//    }
//
//    @Override
//    protected void execute()
//    {
//        if (Robot.winch.isWinchRunning() == false && started == false)
//        {
//            startCompressor();
//        } else if (Robot.winch.isWinchRunning() == true && started == true)
//        {
//            stopCompressor();
//        }
//    }
//
//    @Override
//    protected boolean isFinished()
//    {
//        // TODO Auto-generated method stub
//        return false;
//    }
//
//    @Override
//    protected void end()
//    {
//        Robot.robotCompressor.stop();
//    }
}
