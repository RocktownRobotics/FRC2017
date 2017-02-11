package org.usfirst.frc.team3274.robot.subsystems;

import org.usfirst.frc.team3274.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Collector extends Subsystem {
    // Set up Talons
    SpeedController _collector = new Talon(RobotMap.COLLECTOR_MOTOR);
    
    private double collectSpeed = .25;

    public Collector() {
        LiveWindow.addActuator("Collector", "Collector", (Talon) _collector);
    }

    // Starts the collecting system
    public void collect() {
        _collector.set(collectSpeed);
    }

    @Override
    protected void initDefaultCommand() {
        // TODO Auto-generated method stub
    }

    public void stop() {
        _collector.set(0);
    }
}
