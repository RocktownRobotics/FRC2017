package org.usfirst.frc.team3274.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team3274.robot.commands.Compress;

import edu.wpi.first.wpilibj.Compressor;

public class RobotCompressor extends Subsystem
{
    Compressor compressor = new Compressor();

    public RobotCompressor()
    {
        LiveWindow.addActuator("Compressor", "Compressor", compressor);
    }

    @Override
    protected void initDefaultCommand()
    {
        setDefaultCommand(new Compress());
    }

    public void start()
    {
        compressor.start();
    }

    public void stop()
    {
        compressor.stop();
    }
}
