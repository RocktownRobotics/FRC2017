package org.usfirst.frc.team3274.robot.subsystems;

import org.usfirst.frc.team3274.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearKicker extends Subsystem
{
    DoubleSolenoid kicker = new DoubleSolenoid(RobotMap.gearForward,
            RobotMap.gearReverse);

    @Override
    protected void initDefaultCommand()
    {
        // TODO Auto-generated method stub
    }

    public void gearForward()
    {
        kicker.set(DoubleSolenoid.Value.kForward);
    }

    public void gearReverse()
    {
        kicker.set(DoubleSolenoid.Value.kReverse);
    }

    public void stop()
    {
        kicker.set(DoubleSolenoid.Value.kOff);
    }
}
