package org.usfirst.frc.team3274.robot.subsystems;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import com.ctre.CANTalon.TalonControlMode;
import com.ctre.CANTalon;

import org.usfirst.frc.team3274.robot.Robot;
import org.usfirst.frc.team3274.robot.RobotMap;
import org.usfirst.frc.team3274.robot.commands.DriveWithJoystick;

/**
 * The DriveTrain subsystem controls the robot's chassis and reads in
 * information about it's speed and position.
 */
public class DriveTrain extends Subsystem
{

    public static final int ENCODER_PULSES_PER_REVOLUTION = 256;

    /** In inches **/
    public static final double WHEEL_DIAMETER = 4.0;

    // Four wheels
    SpeedController _frontLeftMotor = new CANTalon(RobotMap.FRONT_LEFT_MOTOR);
    SpeedController _frontRightMotor = new CANTalon(RobotMap.FRONT_RIGHT_MOTOR);
    SpeedController _rearLeftMotor = new CANTalon(RobotMap.REAR_LEFT_MOTOR);
    SpeedController _rearRightMotor = new CANTalon(RobotMap.REAR_RIGHT_MOTOR);
    SpeedController _leftSlave = new CANTalon(RobotMap.LEFT_MOTOR);
    SpeedController _rightSlave = new CANTalon(RobotMap.RIGHT_MOTOR);

    private RobotDrive drive;
    private Encoder rightEncoder = RobotMap.rightEncoder; // new
                                                          // Encoder(RobotMap.RIGHT_ENCODER[0],
    // RobotMap.RIGHT_ENCODER[1], true, EncodingType.k4X);
    private Encoder leftEncoder = RobotMap.leftEncoder; // new
                                                        // Encoder(RobotMap.LEFT_ENCODER[0],
    // RobotMap.LEFT_ENCODER[1], true, EncodingType.k4X);

    public DriveTrain()
    {
        // make these two motors mirror other motors
        ((CANTalon) _leftSlave).changeControlMode(TalonControlMode.Follower);
        _leftSlave.set(RobotMap.FRONT_LEFT_MOTOR);
        ((CANTalon) _rightSlave).changeControlMode(TalonControlMode.Follower);
        _rightSlave.set(RobotMap.FRONT_RIGHT_MOTOR);
        /*
         * About 'Casting' variables In the code above, we have defined the
         * wheels as SpeedControllers, a Java Interface and not a Class. For
         * some reason the methods below expects Motors. Via the magic of
         * polymorphism we can change the SpeedControllers into CANTalons.
         */
        // Configure drive motors
        LiveWindow.addActuator("DriveTrain", "Front Left CIM",
                (CANTalon) _frontLeftMotor);
        LiveWindow.addActuator("DriveTrain", "Front Right CIM",
                (CANTalon) _frontRightMotor);
        LiveWindow.addActuator("DriveTrain", "Back Left CIM",
                (CANTalon) _rearLeftMotor);
        LiveWindow.addActuator("DriveTrain", "Back Right CIM",
                (CANTalon) _rearRightMotor);

        // Configure the RobotDrive.
        drive = new RobotDrive((CANTalon) _frontLeftMotor,
                (CANTalon) _rearLeftMotor, (CANTalon) _frontRightMotor,
                (CANTalon) _rearRightMotor);

        drive.setSafetyEnabled(true);

        // Configure encoders
        rightEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
        leftEncoder.setPIDSourceType(PIDSourceType.kDisplacement);

        if (Robot.isReal())
        { // Converts to feet

            double distancePerPulse; // in feet
            distancePerPulse = (WHEEL_DIAMETER/* in */ * Math.PI)
                    / (ENCODER_PULSES_PER_REVOLUTION * 12.0/* in/ft */);

            rightEncoder.setDistancePerPulse(distancePerPulse);
            leftEncoder.setDistancePerPulse(distancePerPulse);
        } else
        { // Convert to feet 4in diameter wheels with 256 tick simulated
          // encoders
            rightEncoder.setDistancePerPulse((WHEEL_DIAMETER/* in */ * Math.PI)
                    / (ENCODER_PULSES_PER_REVOLUTION * 12.0/* in/ft */)); // 4.0
                                                                          // is
                                                                          // diameter,
                                                                          // which
                                                                          // is
                                                                          // 2r
            leftEncoder.setDistancePerPulse((WHEEL_DIAMETER/* in */ * Math.PI)
                    / (ENCODER_PULSES_PER_REVOLUTION * 12.0/* in/ft */));
        }

        LiveWindow.addSensor("DriveTrain", "Right Encoder", rightEncoder);
        LiveWindow.addSensor("DriveTrain", "Left Encoder", leftEncoder);
    }

    /**
     * When other commands aren't using the drivetrain, allow tank drive with
     * the joystick.
     */
    @Override
    public void initDefaultCommand()
    {
        setDefaultCommand(new DriveWithJoystick());
    }

    /**
     * Resets encoders to start tracking distance driven from a certain point.
     */
    public void resetEncoders()
    {
        rightEncoder.reset();
        leftEncoder.reset();
    }

    /**
     * Gets the average distance driven each encoder has registered in feet
     * since the last time the encoders were reset.
     * 
     * @return average distance driven in feet
     */
    public double getDistanceDriven()
    {
        double dist;
        
        dist = (rightEncoder.getDistance() + leftEncoder.getDistance()) / 2;
        
        return dist;
    }

    /**
     * Drive the wheels on one side forward with one stick and the wheels on
     * another side forward with another stick.
     * 
     * @param joy
     *            PS3 style joystick to use as the input for tank drive.
     */
    public void tankDrive(Joystick joy)
    {
        this.tankDrive(joy.getRawAxis(1), joy.getRawAxis(5));
    }

    /**
     * Drive by giving left and right side values
     * 
     * @param leftAxis
     *            Left sides value
     * @param rightAxis
     *            Right sides value
     */
    /*
     * Nathan, if you are anything like me, you may be saying to yourself 'But
     * this method has the same name as the one above it! Why and how does this
     * work!? This makes me scared and unsure about the future!'. Well fear not
     * because there is a simple explanation. Java allows us to 'overload'
     * methods, that is define the same method multiple times, but with
     * different numbers of parameters. This is useful if we want a version of
     * the method to do a default and a version that we can supply values to.
     */

    // Checks to see if a number (variable) is in a certain range (rangeFrom)
    // from a certain point (point)
    public boolean inRange(double variable, double point, double rangeFrom)
    {
        boolean result = false;
        if (variable < (point + rangeFrom) && variable > (point - rangeFrom))
        {
            result = true;
        }
        return result;
    }

    /**
     * Drive the wheels on one side forward with one stick and the wheels on
     * another side forward with another stick.
     * 
     * @param leftAxis
     *            left stick y-axis
     * @param rightAxis
     *            right stick y-axis
     */
    public void tankDrive(double leftAxis, double rightAxis)
    {
        double lJoyStickVal = 0.0;
        double rJoyStickVal = 0.0;

        // Setting up Deadzones
        if ((leftAxis < 0.5) && (leftAxis > -0.5))
        {
            lJoyStickVal = 0.0;
        } else
        {
            lJoyStickVal = leftAxis;
        }

        if ((rightAxis < 0.5) && (rightAxis > -0.5))
        {
            rJoyStickVal = 0.0;
        } else
        {
            rJoyStickVal = rightAxis;
        }

        double[] correctedPow = getSpeedCorrection(-lJoyStickVal,
                -rJoyStickVal);

        drive.tankDrive(correctedPow[0], correctedPow[1]);
        Timer.delay(0.005); // wait for a motor update time

    }

    /**
     * Use y-axis on left stick for power and x-axis on right stick for turning.
     * 
     * @param joy
     *            joystick
     */
    public void carDrive(Joystick joy)
    {
        this.carDrive(joy.getRawAxis(1), joy.getRawAxis(4));
    }

    /**
     * Use y-axis on left stick for power and x-axis on right stick for turning.
     * 
     * @param leftAxis
     *            y-axis of left stick
     * @param rightAxis
     *            x-axis of right stick
     */
    public void carDrive(double leftAxis, double rightAxis)
    {

        final double DEAD_ZONE = 0.1; // +- 0, dead zone for joystick input

        boolean inLDeadZone = false;

        double lJoyStickVal = 0.0;
        double rJoyStickVal = 0.0;

        double leftPower;
        double rightPower;

        // Setting up Deadzones
        if ((leftAxis < DEAD_ZONE) && (leftAxis > -DEAD_ZONE))
        {
            lJoyStickVal = 0.0;
            inLDeadZone = true;
        } else
        {
            lJoyStickVal = -leftAxis;
        }

        if ((rightAxis < DEAD_ZONE) && (rightAxis > -DEAD_ZONE))
        {
            rJoyStickVal = 0.0;
        } else
        {
            rJoyStickVal = rightAxis;
        }

        // convert to left and right power with floating point errors in mind
        leftPower = lJoyStickVal;
        rightPower = lJoyStickVal;

        if (!inLDeadZone)
        {

            // turns with throttle

            if (rJoyStickVal > 0.01)
            {
                leftPower = leftPower * (1 - Math.abs(rJoyStickVal));
            } else if (rJoyStickVal < -0.01)
            {
                rightPower = rightPower * (1 - Math.abs(rJoyStickVal));
            }
        } else
        {
            // does a point turn if there is no throttle
            double pow = Math.abs(rJoyStickVal);

            if (rJoyStickVal > 0.01)
            {
                leftPower = -pow;
                rightPower = pow;
            } else if (rJoyStickVal < -0.01)
            {
                leftPower = pow;
                rightPower = -pow;
            }
        }

        double[] correctedPow = getSpeedCorrection(-leftPower, -rightPower);

        drive.tankDrive(correctedPow[0], correctedPow[1]);
        Timer.delay(0.005); // wait for a motor update time
    }

    /**
     * Stop the drivetrain from moving.
     */
    public void stop()
    {
        drive.tankDrive(0, 0);
    }

    /**
     * Calculates a correction for the speed the motors should be moving at
     * based on difference in encoder readings.
     * 
     * Makes sure that the robot is moving in the direction it should be moving
     * in, AKA perfectly straight if it should be going straight.
     * 
     * @param leftPower
     *            - un-corrected power for left wheels (between -1 and 1)
     * @param rightPower
     *            - un-corrected power for right wheels (between -1 and 1)
     * 
     * @return correction for motor power in the form { leftPower, rightPower }
     */
    public double[] getSpeedCorrection(double leftPower, double rightPower)
    {

        final double ALLOWED_MARGIN_OF_ERROR = .01; // as a percentage between 0
                                                    // and 1

        double[] corrected = { leftPower, rightPower };

        double rightEncoderRate = rightEncoder.getRate(); // feet per second
        double leftEncoderRate = leftEncoder.getRate(); // feet per second

        double leftToRightMotor; // ratio between the power in the left and
                                 // right wheels
        double leftToRightEncoder; // ratio between the rate in the left and
                                   // right encoders

        // add code for correcting power here
        leftToRightMotor = leftPower / rightPower;
        leftToRightEncoder = leftEncoderRate / rightEncoderRate;

        double diff = leftToRightEncoder - leftToRightMotor;

        if (diff > -ALLOWED_MARGIN_OF_ERROR && diff < ALLOWED_MARGIN_OF_ERROR)
        {
            if (Math.abs(leftToRightMotor) > 1)
            {
                corrected[1] = leftPower / leftToRightEncoder;
                corrected[1] = Math.copySign(corrected[1], rightPower);
            } else if (Math.abs(leftToRightMotor) < 1)
            {
                corrected[0] = rightPower * leftToRightEncoder;
                corrected[0] = Math.copySign(corrected[0], leftPower);
            }
        }

        // Make sure neither value is above 1 or below -1
        for (int i = 0; i < 2; i++)
        {
            if (corrected[i] > 1)
            {
                corrected[i] = .999;
            } else if (corrected[i] < -1)
            {
                corrected[i] = -.999;
            }
        }
        System.out.println(String.format("LeftEncoder Value = %f ",
                leftEncoder.getRate()));

        return corrected;
    }

    /**
     * @return The encoder getting the distance and speed of left side of the
     *         drivetrain.
     */
    public Encoder getLeftEncoder()
    {
        return leftEncoder;
    }

    /**
     * @return The encoder getting the distance and speed of right side of the
     *         drivetrain.
     */
    public Encoder getRightEncoder()
    {
        return rightEncoder;
    }
//
// /**
// * @return The current angle of the drivetrain.
// */
// public double getAngle() {
// return gyro.getAngle();
// }
}