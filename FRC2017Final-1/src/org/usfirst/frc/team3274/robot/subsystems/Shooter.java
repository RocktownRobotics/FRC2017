package org.usfirst.frc.team3274.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Shooter extends Subsystem {
    // Set up Talons
    SpeedController _shooterWheel = new Talon(0); // Shooter wheel
    SpeedController _feeder = new Talon(1); // Feeds the balls into the shooter
                                            // wheel

    // Time variables to determine if the feeder can start
    private boolean feederReady;
    private double shooterStart;
    private double shooterCheckTime;
    private double timeToFeed = 1;

    // Sets the speed for the motors
    private double shootSpeed = 1;
    private double feedSpeed = .1;

    public Shooter() {
        LiveWindow.addActuator("Shooter", "Shooter Wheel",
                (Talon) _shooterWheel);
        LiveWindow.addActuator("Shooter", "Feeder", (Talon) _feeder);
    }

    // Starts the shooter wheel
    public void startShooterWheel() {
        shooterStart = Timer.getMatchTime();
        _shooterWheel.set(shootSpeed);
    }

    // Checks to see if the shooter has been running long enough for the feeder
    // to run
    public boolean isFeederReady() {
        feederReady = false;
        shooterCheckTime = Timer.getMatchTime();
        if ((shooterCheckTime - shooterStart) >= timeToFeed) {
            feederReady = true;
        }
        return feederReady;
    }

    @Override
    protected void initDefaultCommand() {
        // TODO Auto-generated method stub
    }

    // Starts the feeder
    public void startFeeder() {
        _feeder.set(feedSpeed);
    }

    // Stops BOTH of the shooter motors
    public void stop() {
        _shooterWheel.set(0);
        _feeder.set(0);
    }

    // Stops ONLY the feeder motor
    public void stopFeeder() {
        _feeder.set(0);
    }
}
