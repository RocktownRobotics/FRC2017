package org.usfirst.frc.team3274.robot.subsystems;

import org.usfirst.frc.team3274.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Agitator extends Subsystem
{
    Relay agitator = new Relay(RobotMap.SPIKE);

    public Agitator()
    {
        LiveWindow.addActuator("Agitator", "Agitator", agitator);
    }
    
    public Relay.Value getDirection()
    {
        return agitator.get();
    }

    @Override
    protected void initDefaultCommand()
    {
        // TODO Auto-generated method stub

    }

    public void forward()
    {
        agitator.set(Relay.Value.kOn);
        agitator.set(Relay.Value.kForward);
    }

    public void reverse()
    {
        agitator.set(Relay.Value.kOn);
        agitator.set(Relay.Value.kReverse);

    }

    public void stop()
    {
        agitator.set(Relay.Value.kOff);
    }
    
    public boolean getIsRunning()
    {
        return agitator.get() != Relay.Value.kOff;
    }
}
