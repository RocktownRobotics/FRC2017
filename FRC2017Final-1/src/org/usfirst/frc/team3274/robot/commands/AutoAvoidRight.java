package org.usfirst.frc.team3274.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoAvoidRight extends CommandGroup
{
    public AutoAvoidRight()
    {
        addSequential(new DriveForward(2));
        addSequential(new TurnRobot(90));
        addSequential(new DriveForward(6));
        addSequential(new TurnRobot(-90));
        addSequential(new DriveForward(8));
    }
}
