package org.usfirst.frc.team3274.robot.subsystems;

import org.usfirst.frc.team3274.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearGate extends Subsystem
{
    boolean gateDown;
    
    DoubleSolenoid gate = new DoubleSolenoid(RobotMap.gateDrop,
            RobotMap.gateRaise);
    
    public GearGate()
    {
        this.gateDown = false;
    }

    @Override
    protected void initDefaultCommand()
    {
        // TODO Auto-generated method stub
    }

    public void dropGate()
    {
        gate.set(DoubleSolenoid.Value.kForward);
        this.gateDown = true;
    }

    public void raiseGate()
    {
        gate.set(DoubleSolenoid.Value.kReverse);
        this.gateDown = false;
    }

    public void stop()
    {
        gate.set(DoubleSolenoid.Value.kOff);
    }
    
    /**
     * Find whether or not the gate is down.
     * 
     * @return true if gate is done
     */
    public boolean getGateIsDown()
    {
        return this.gateDown;
    }
}
