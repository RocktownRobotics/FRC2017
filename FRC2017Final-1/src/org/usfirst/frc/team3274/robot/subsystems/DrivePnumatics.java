package org.usfirst.frc.team3274.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class DrivePnumatics extends Subsystem {
    DoubleSolenoid gearShifter;

    DoubleSolenoid.Value off = DoubleSolenoid.Value.kOff;
    // May need to switch lowGear and HighGear values (kForward/kReverse)
    DoubleSolenoid.Value lowGear = DoubleSolenoid.Value.kForward;
    DoubleSolenoid.Value highGear = DoubleSolenoid.Value.kReverse;

    public DrivePnumatics() {
        LiveWindow.addActuator("DrivePnumatics", "GearShifter", gearShifter);
    }

    public void StartLowGear() {
        gearShifter.set(lowGear);
    }

    public void StartHighGear() {
        gearShifter.set(highGear);
    }

    public void ShiftGears() {
        if (gearShifter.get() == lowGear) {
            gearShifter.set(highGear);
        } else if (gearShifter.get() == highGear) {
            gearShifter.set(lowGear);
        }
    }

    @Override
    protected void initDefaultCommand() {
        // TODO Auto-generated method stub
    }

    public void stop() {
        gearShifter.set(off);
    }
}
