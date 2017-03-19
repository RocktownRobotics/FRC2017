package org.usfirst.frc.team3274.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3274.robot.OI;
import org.usfirst.frc.team3274.robot.Robot;
import org.usfirst.frc.team3274.robot.RobotMap;
import org.usfirst.frc.team3274.robot.subsystems.DriveTrain;;

/**
 * This command allows xbox joystick to drive the robot. It is always running
 * except when interrupted by another command.
 */
public class DriveWithJoystick extends Command
{
    public DriveWithJoystick()
    {
        requires(Robot.drivetrain);
    }

    /**
     * Do the driving.
     * 
     * @see edu.wpi.first.wpilibj.command.Command#execute()
     */
    @Override
    protected void execute()
    {
        Robot.drivetrain.carDrive(Robot.oi.getJoystick());
        
//        // if one of xbox controller joysticks are not in their deadzones, use
//        // that controller with car drive
//        if (Robot.drivetrain.isInDeadZone(Robot.oi.getJoystick()
//                .getRawAxis(RobotMap.XBOX_LEFT_Y_AXIS)) == false
//                || Robot.drivetrain.isInDeadZone(Robot.oi.getJoystick()
//                        .getRawAxis(RobotMap.XBOX_RIGHT_X_AXIS)) == false)
//        {
//            Robot.drivetrain.carDrive(Robot.oi.getJoystick());
//
//            Robot.drivetrain.setSniperMode(1);
//        }
//        // if flight sticks are not in thier deadzones, instead use them
//        else if (Robot.drivetrain.isInDeadZone(Robot.oi.getJoystick2()
//                .getRawAxis(RobotMap.FLIGHT_STICK_FORWARD_AXIS)) == false
//                || Robot.drivetrain
//                        .isInDeadZone(Robot.oi.getJoystick3().getRawAxis(
//                                RobotMap.FLIGHT_STICK_FORWARD_AXIS)) == false)
//        {
//            // use two flight sticks with tank drive. joystick 3 is on the left
//            // and joystick 2 is on the right
//            Robot.drivetrain.tankDrive(
//                    Robot.oi.getJoystick3()
//                            .getRawAxis(RobotMap.FLIGHT_STICK_FORWARD_AXIS),
//                    Robot.oi.getJoystick2()
//                            .getRawAxis(RobotMap.FLIGHT_STICK_FORWARD_AXIS));
//
//            Robot.drivetrain
//                    .setSniperMode(DriveTrain.DEFAULT_SNIPER_MODE_DIVIDOR);
//        }
//        // else try to use xbox controller with car drive
//        else
//        {
//            Robot.drivetrain.carDrive(Robot.oi.getJoystick());
//            Robot.drivetrain.setSniperMode(1);
//        }
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }

    @Override
    protected void end()
    {
        Robot.drivetrain.stop();
    }
}