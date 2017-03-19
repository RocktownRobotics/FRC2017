package org.usfirst.frc.team3274.robot.commands;

import org.usfirst.frc.team3274.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Used to make the robot drive forward a certain distance in autonomous.
 * 
 * @author Dell-Laptop-FLL
 *
 */
public class DriveForward extends Command
{

    /* Distance driven is stored in encoders in drive train. */

    private double driveForwardSpeed;

    // in feet
    private double goalDistance;

    /**
     * Has the robot drive forward dist distance
     * 
     * @param dist - distance in feet
     */
    public DriveForward(double dist)
    {
        this(dist, .50);
    }

    /**
     * 
     * @param dist - in feet.
     * @param maxSpeed
     */
    public DriveForward(double dist, double maxSpeed)
    {
        requires(Robot.drivetrain);
        this.goalDistance = dist;
        this.driveForwardSpeed = maxSpeed;
    }

    /**
     * Called just before this Command runs the first time.
     */
    @Override
    protected void initialize()
    {
        // set the distance driven for each encoder back to 0
        Robot.drivetrain.resetEncoders();
    }

    /**
     * Called repeatedly when this Command is scheduled to run.
     */
    @Override
    protected void execute()
    {
        Robot.drivetrain.tankDrive(driveForwardSpeed, driveForwardSpeed);
        // distance driven is handled by the encoders in the drive train
    }

    /**
     * Make this return true when this Command no longer needs to run execute().
     */
    @Override
    protected boolean isFinished()
    {
        if (Robot.drivetrain.getDistanceDriven() >= goalDistance)
        {
            SmartDashboard.putNumber("Distancestuffs", 42);
            return true;
        }
        SmartDashboard.putNumber("Distancestuffs", 1);
        return false;
    }

    /**
     * Called once after isFinished returns true.
     */
    @Override
    protected void end()
    {
        Robot.drivetrain.stop();
    }

    /**
     * Called when another command which requires one or more of the
     * same(non-Javadoc)
     * 
     * {@see edu.wpi.first.wpilibj.command.Command#interrupted()}
     * 
     * subsystems is scheduled to run.
     */
    @Override
    protected void interrupted()
    {
    }
}
