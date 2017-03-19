package org.usfirst.frc.team3274.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RetractKickerAndGate extends CommandGroup
{
    public RetractKickerAndGate()
    {
        addSequential(new KickGearBackward());
        addSequential(new RaiseGearGate());
    }
}
