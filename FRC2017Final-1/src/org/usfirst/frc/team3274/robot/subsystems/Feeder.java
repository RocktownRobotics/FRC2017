package org.usfirst.frc.team3274.robot.subsystems;

import org.usfirst.frc.team3274.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The "Indexer", or feeder. It feeds the balls into the shooter.
 * 
 * @author Dell-Laptop-FLL
 */
public class Feeder extends Subsystem
{
    SpeedController _feeder = new Talon(RobotMap.FEEDER_MOTOR); // Feeds the
                                                                // balls into
                                                                // the shooter
                                                                // wheel
    // Time variables to determine if the feeder can start
    private boolean feederReady;
    private double shooterCheckTime;
    private double timeToFeed = 1;
    private double feedSpeed = .1;

    public Feeder()
    {
        LiveWindow.addActuator("Shooter", "Feeder", (Talon) _feeder);
    }

    public boolean isFeederReady()
    {
        feederReady = false;
        shooterCheckTime = Timer.getMatchTime();
        if ((shooterCheckTime - Shooter.shooterStart) >= timeToFeed)
        {
            feederReady = true;
        }
        return feederReady;
    }
    
    // Starts the feeder
    public void startFeeder()
    {
        _feeder.set(feedSpeed);
    }
    
    // Stops the feeder
    public void stopFeeder()
    {
        _feeder.set(0);
    }

    @Override
    protected void initDefaultCommand()
    {
        // TODO Auto-generated method stub
    }

}
