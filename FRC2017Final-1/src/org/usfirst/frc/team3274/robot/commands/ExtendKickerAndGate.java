package org.usfirst.frc.team3274.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ExtendKickerAndGate extends CommandGroup
{
    public ExtendKickerAndGate()
    {
        addSequential(new LowerGearGate());
        addSequential(new KickGearForward());
    }
}
