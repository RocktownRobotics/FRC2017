package org.usfirst.frc.team3274.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ShortAuto extends CommandGroup
{
    public ShortAuto()
    {
        addSequential(new DriveForward(1.5));
    }
}
