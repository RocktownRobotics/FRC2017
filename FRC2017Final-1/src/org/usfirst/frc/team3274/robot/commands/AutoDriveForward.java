package org.usfirst.frc.team3274.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * A group of to be executed during autonomous.
 * 
 * @author Anthony 'AJ' Snarr
 * @author <insert name here>
 *
 */
public class AutoDriveForward extends CommandGroup
{
    /**
     * Add commands to be executed in order or simultaneously here.
     */
    public AutoDriveForward()
    {
        addSequential(new DriveForward(6.5));
    }
}
