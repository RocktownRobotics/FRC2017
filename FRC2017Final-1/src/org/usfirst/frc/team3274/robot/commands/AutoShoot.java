package org.usfirst.frc.team3274.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoShoot extends CommandGroup
{
    public AutoShoot()
    {
        addParallel(new PreShoot());
        addParallel(new Agitate());
        for(int i = 0; i < 14; i++)
        {
            addSequential(new ShootOneBall(.5));
            Timer.delay(0.5);
        }
    }
}
