package org.usfirst.frc.team3274.robot.commands;

import org.usfirst.frc.team3274.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Used to make the robot turn left or right a certain amount of degrees
 * 
 * @author Dell-Laptop-FLL
 *
 */
public class TurnRobot extends Command
{
    /** In inches **/
    public static final double TURN_RADIUS = 13.75;

    /** Between 0 and 1 **/
    public static final double TURN_SPEED = .1;

    double degrees;

    // circumference derived from turn radius
    double goalTurnDistance;

    /**
     * Degrees is the amount of degrees for the robot to turn.
     * 
     * @param degrees - the number of degrees to turn
     */
    public TurnRobot(double degrees)
    {
        requires(Robot.drivetrain);

        this.degrees = degrees;

        // force to be between -180 and 180
        this.degrees %= 360;
        if (this.degrees < -180)
        {
            this.degrees += 360;
        } else if (this.degrees > 180)
        {
            this.degrees -= 360;
        }

        // get goal turn distance
        this.goalTurnDistance = (this.getCircumference() / this.degrees);
    }

    /**
     * Called just before this Command runs the first time.
     */
    @Override
    protected void initialize()
    {
        Robot.drivetrain.resetEncoders();
    }

    /**
     * Called repeatedly when this Command is scheduled to run.
     */
    @Override
    protected void execute()
    {
        Robot.drivetrain.carDrive(0, Math.copySign(TURN_SPEED, this.degrees));
    }

    @Override
    protected boolean isFinished()
    {
        // return Robot.drivetrain.getLeftDistance() >= this.goalTurnDistance;
        // || Robot.drivetrain.getRightDistance() >= this.goalTurnDistance;

        return this.goalTurnDistance >= 0
                && Robot.drivetrain.getRightDistance() >= this.goalTurnDistance
                || this.goalTurnDistance < 0 && Robot.drivetrain
                        .getRightDistance() <= this.goalTurnDistance;
    }

    /**
     * Called once after isFinished returns true.
     */
    @Override
    protected void end()
    {
        Robot.drivetrain.carDrive(0, 0);
    }

    private double getCircumference()
    {
        return 2 * TURN_RADIUS * Math.PI;
    }
}
