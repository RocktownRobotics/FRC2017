package org.usfirst.frc.team3274.robot.commands;

import javax.swing.CellEditor;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * NEEDS TESTING: ROUGHLY CODED
 * Is designed to have the robot go forward just enough to have the gear get
 * onto the gear peg. NOTE:The right encoder isn't working as of writing this
 * 
 * @author Dell-Laptop-FLL
 *
 */
public class AutoGear extends CommandGroup
{
    final double P = 85; // NEEDS TO BE MEASURED ON FIELD AND CHANGED
    final double G = 93.25;
    final double K = 80.07;
    final double J = K / 2;
    final double H = J / 2;
    final double D = H * Math.cos(30);
    final double M = (K - J);
    final double N = H + M;
    final double F = G + D;
    final double R = P - N;
    final double C = R * Math.tan(30);
    final double A = F - C; // FORWARD DISTANCE
    final double B = 2 * C; // DISTANCE AFTER TURNING
    final double ROBOT_LENGTH = 36;

    public static enum GearLocation {
        LEFT, RIGHT, CENTER
    }

    /**
     * Start autonomous gear placing and move the gear for the specific location
     * 
     * @param loc
     */
    public AutoGear(GearLocation loc)
    {        
        //addSequential(new ShiftDownForTime());

        switch (loc)
        {
            case CENTER:
                this.placeGearCenter();
                break;
            case RIGHT:
                this.placeGearRight();
                break;
            case LEFT:
                this.placeGearLeft();
                break;
        }
    }

    /**
     * Place the gear in the center hook in autonomous mode.
     * 
     * Assumes a specific starting position.
     */
    private void placeGearCenter()
    {
        /*
         * Use commands with addSequential:
         * 
         * DriveForward(distance)
         * TurnRobot(+- degrees)
         * 
         * KickGearForward
         * KickGearBackward
         */
        addSequential(new DriveForward(toFeet(G - ROBOT_LENGTH - 2)));
        
    }

    /**
     * Place the gear in the left hook in autonomous mode.
     * 
     * Assumes a specific starting position.
     */
    private void placeGearLeft()
    {
        /*
         * Use commands with addSequential:
         * 
         * DriveForward(distance)
         * TurnRobot(+- degrees)
         * 
         * KickGearForward
         * KickGearBackward
         */
        addSequential(new DriveForward(toFeet(A)));
        //addSequential(new TurnRobot(toFeet()));
        addSequential(new DriveForward(toFeet((B - ROBOT_LENGTH))));
    }

    /**
     * Place the gear in the right hook in autonomous mode.
     * 
     * Assumes a specific starting position.
     */
    private void placeGearRight()
    {
        /*
         * Use commands with addSequential:
         * 
         * DriveForward(distance)
         * TurnRobot(+- degrees)
         * 
         * KickGearForward
         * KickGearBackward
         */
        addSequential(new DriveForward(toFeet(A)));
        addSequential(new TurnRobot(toFeet(-60)));
        addSequential(new DriveForward(toFeet(B - ROBOT_LENGTH)));
    }
    
    private double toFeet(double inches)
    {
        return inches / 12;
    }
}
