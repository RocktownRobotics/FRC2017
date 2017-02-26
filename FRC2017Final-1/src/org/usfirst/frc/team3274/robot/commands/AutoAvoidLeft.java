package org.usfirst.frc.team3274.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Avoids airship to pass the line on the left when in driverstation 2
 * @author Dell-Laptop-FLL
 *
 */
public class AutoAvoidLeft extends CommandGroup
{
    /**
     * Add commands to be executed in order or simultaneously here.
     */
    public AutoAvoidLeft()
    {
        addSequential(new DriveForward(2));
        addSequential(new TurnRobot(-90));
        addSequential(new DriveForward(6));
        addSequential(new TurnRobot(90));
        addSequential(new DriveForward(8));
    }
}
