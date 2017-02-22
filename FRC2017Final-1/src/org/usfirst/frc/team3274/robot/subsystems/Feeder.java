package org.usfirst.frc.team3274.robot.subsystems;

import org.usfirst.frc.team3274.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
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
    SpeedController _indexingWheel = new Talon(RobotMap.FEEDER_MOTOR); // Feeds the
                                                            // balls into
                                                                // the shooter
                                                                // wheel
    Relay agitator = new Relay(RobotMap.SPIKE);
    
    
    // Time variables to determine if the feeder can start
    private final double FEED_SPEED = -0.9999;
    
    private boolean feederReady;
    private double shooterCheckTime;
    private double timeToFeed = 1;

    public Feeder()
    {
        LiveWindow.addActuator("Shooter", "Feeder", (Talon) _indexingWheel);
        LiveWindow.addActuator("Agitator", "Agitator", agitator);
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
        _indexingWheel.set(FEED_SPEED);
        agitator.set(Relay.Value.kOn);
        agitator.set(Relay.Value.kReverse);
    }
    
    // Stops the feeder
    public void stopFeeder()
    {
        _indexingWheel.set(0);
        agitator.set(Relay.Value.kOff);
        
    }

    @Override
    protected void initDefaultCommand()
    {
        // TODO Auto-generated method stub
    }

}
