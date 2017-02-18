package org.usfirst.frc.team3274.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3274.robot.commands.Autonomous2;
import org.usfirst.frc.team3274.robot.commands.DriveForward;
import org.usfirst.frc.team3274.robot.commands.FeedShooter;
import org.usfirst.frc.team3274.robot.commands.PreShoot;
import org.usfirst.frc.team3274.robot.commands.RunAutonomous;
import org.usfirst.frc.team3274.robot.commands.RunTeleop;
import org.usfirst.frc.team3274.robot.subsystems.Collector;
import org.usfirst.frc.team3274.robot.subsystems.DrivePnumatics;
import org.usfirst.frc.team3274.robot.subsystems.DriveTrain;
import org.usfirst.frc.team3274.robot.subsystems.Feeder;
import org.usfirst.frc.team3274.robot.subsystems.RobotCompressor;
import org.usfirst.frc.team3274.robot.subsystems.Shooter;
import org.usfirst.frc.team3274.robot.subsystems.Winch;
import org.usfirst.frc.team3274.robot.visionprocessing.CameraProcessor;

/**
 * This is the main class for running the FRC2017Final code.
 *
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
/* Nathan ....... this is a robot */

/*
 * ----- Some notes on GIT ----- git makes a copy of the whole filesystem
 * whenever you clone a repo. This means you 'checkout' everything. Once you
 * have done some work and you are ready to save your changes to git, use the
 * 'commit' command. This saves the changeset to your local git repo. The
 * 'staging' file will be updated with the list of changes that you have made.
 * At this step you must use the 'pull' command to see if others may have pushed
 * changes to the code to the server. If there are conflicts between the files
 * on the server and the files on your computer you must 'merge' them. To tell
 * the git server about your changes so that other users and computers can
 * access them, use the 'push' command. This takes any changes stored in the
 * staging file and tells the server about them. More info is available at
 * https://git-scm.com/book/en/v2/Getting-Started-About-Version-Control
 */
public class Robot extends IterativeRobot
{
    Command autonomousCommand;
    Command teleopCommand;
    /* our joystick */
    public static OI oi;

    /*
     * 'public static' means that this variable can be accessed on the class
     * without creating an instance. IE this can be accessed by 'Robot.isTeLeop'
     * instead of having to do: Robot r = new Robot(); r.isTeLeop;
     * 
     * More info at
     * https://www.caveofprogramming.com/java/java-for-beginners-static-
     * variables-what-are-they.html
     */

    // Initialize the subsystems
    public static final DriveTrain drivetrain = new DriveTrain();
    public static final Shooter shooter = new Shooter();
    public static final Feeder feeder = new Feeder();
    public static final Collector collector = new Collector();
    public static final Winch winch = new Winch();
    //public static final DrivePnumatics drivepnumatics = new DrivePnumatics();
    //public static final RobotCompressor robotCompressor = new RobotCompressor();

    
    public static final CameraProcessor cam = new CameraProcessor();
    
    
    // make eclipse ignore the "raw type" warning
    @SuppressWarnings("rawtypes")
    public SendableChooser autoChooser;

    // This function is run when the robot is first started up and should be
    // used for any initialization code.
    @SuppressWarnings({ "unchecked", "rawtypes" }) // make eclipse ignore the
                                                   // "raw type" warning
    
    @Override
    public void robotInit()
    {
        
        cam.init(); // start processing of camera input
        
        SmartDashboard.putData(drivetrain);

        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // instantiate the command used for the autonomous period
        autoChooser = new SendableChooser();
        autoChooser.addDefault("Default Autonomous Control",
                new RunAutonomous());

        autoChooser.addObject("Autonomous Control 2", new Autonomous2());

// autoChooser.addObject("Drive Forward", new DriveForward(10));// NEED TO
// // TEST AND
// // CHANGE?
// autoChooser.addObject("PreShoot", new PreShoot());
// autoChooser.addObject("FeedShooter", new FeedShooter());
        SmartDashboard.putData("Auto Mode", autoChooser);
    }

    /*
     * Code that runs when autonomous mode is started
     * 
     * @see edu.wpi.first.wpilibj.IterativeRobot#autonomousInit()
     */
    @Override
    public void autonomousInit()
    {
        autonomousCommand = (Command) autoChooser.getSelected();
        autonomousCommand.start();
    }

    // This function is called periodically during autonomous
    @Override
    public void autonomousPeriodic()
    {
        Scheduler.getInstance().run();
        log();
    }

    /*
     * Code that runs when tele op mode is started
     * 
     * @see edu.wpi.first.wpilibj.IterativeRobot#teleopInit()
     */
    @SuppressWarnings("unchecked") // make eclipse ignore the "raw type" warning
    @Override
    public void teleopInit()
    {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null)
        {
            autonomousCommand.cancel();
        }

        // instantiate commands for teleop driving
        autoChooser.addDefault("Teleop Commands", new RunTeleop());
    }

    // This function is called periodically during operator control
    @Override
    public void teleopPeriodic()
    {

        /*
         * Note that the DriveWithJoyStick command is activated automatically in
         * DriveTrain.initDefaultCommand()
         */

        Scheduler.getInstance().run();
        log();
    }

    // This function called periodically during test mode
    @Override
    public void testPeriodic()
    {
        LiveWindow.run();
    }

    @Override
    public void disabledInit()
    {

    }

    // This function is called periodically while disabled
    @Override
    public void disabledPeriodic()
    {
        log();
    }

    /**
     * Log interesting values to the SmartDashboard.
     */
    private void log()
    {
// Robot.pneumatics.writePressure();
// SmartDashboard.putNumber("Pivot Pot Value", Robot.pivot.getAngle());
// SmartDashboard.putNumber("Left Distance",
// drivetrain.getLeftEncoder().getDistance());
// SmartDashboard.putNumber("Right Distance",
// drivetrain.getRightEncoder().getDistance());
    }
}
