package org.usfirst.frc.team3274.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous2 extends CommandGroup
{
    /**
     * Add commands to be executed in order or simultaneously here.
     */
    public Autonomous2()
    {
        // example: addSequential(new Command());
        addSequential(new DriveForward(10));
    }
}
