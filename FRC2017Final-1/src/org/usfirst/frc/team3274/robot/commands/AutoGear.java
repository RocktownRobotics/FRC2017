package org.usfirst.frc.team3274.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * NEEDS TESTING: ROUGHLY CODED
 * Is designed to have the robot go forward just enough to have the gear get
 * onto the gear peg. NOTE:The right encoder isn't working as of writing this
 * 
 * @author Dell-Laptop-FLL
 *
 */
public class AutoGear extends CommandGroup
{
    public AutoGear()
    {
        addSequential(new DriveForward(3.54));
    }
}
