package org.usfirst.frc.team3274.robot.subsystems;

import org.usfirst.frc.team3274.robot.RobotMap;
import org.usfirst.frc.team3274.robot.commands.ShootWithSpeedDial;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends Subsystem
{
    public static final double SHOOTER_WHEEL_POWER = .47;
    public static final double MAX_SHOOT_RPM = 2650;

    // Set up Encoder
    private Encoder tLEncoder = new Encoder(RobotMap.TL_ENCODER[0],
            RobotMap.TL_ENCODER[1], true, EncodingType.k1X);
    


    // Set up Talons
    SpeedController _shooterWheel = new Talon(RobotMap.SHOOTER_MOTOR); // Shooter
                                                                       // wheel
    public static double shooterStart;

    public Shooter()
    {
        LiveWindow.addActuator("Shooter", "Shooter Wheel",
                (Talon) _shooterWheel);
    }

    @Override
    protected void initDefaultCommand()
    {
        setDefaultCommand(new ShootWithSpeedDial());
    }

    // Starts the shooter wheel
    public void startShooterWheel()
    {
        shooterStart = Timer.getMatchTime();
        _shooterWheel.set(SHOOTER_WHEEL_POWER);
    }

    // Stops the shooter wheel
    public void stop()
    {
        _shooterWheel.set(0);
    }

//    public double getRPM()
//    {
//        return this.tLEncoder.getRate() * 60;
//    }

    /**
     * 
     * @param joy a joystick with a single z axis wheel
     */
    public void speedShoot(Joystick joy)
    {
        this.speedShoot(joy.getRawAxis(2));
    }

    /**
     * Use the dial on the second controller (joystick) to control the speed of
     * the shooter
     * 
     * @param dial
     *            the dial on the seperate Joystick
     */
    public void speedShoot(double dial)
    {
        // The intervals at which it will "lock" the values of the dial (in the
        // code)
        final double[] LOCK_INTEVALS = { 0, .2, .4, .6, .8, 1 };

        double rawPower = (dial + 1) / 2; // changes range from -1 to 1, to 0 to
                                          // -1

        rawPower = 1 - rawPower;
        double discretePower = 0;
//        double wantRPM = 0;

        for (int i = 1; i < LOCK_INTEVALS.length; i++)
        {
            if (rawPower < LOCK_INTEVALS[i] && rawPower >= LOCK_INTEVALS[i - 1])
            {
//                wantRPM = MAX_SHOOT_RPM * LOCK_INTEVALS[i - 1];
                discretePower = LOCK_INTEVALS[i - 1];
                break;
            }
        }
//        adjustShooterWithEncoder(discretePower, wantRPM);
        
        this._shooterWheel.set(discretePower);
        SmartDashboard.putNumber("Shooter Wheel speed :", discretePower);
    }

    /**
     * Read the touchless encoder RPM, and adjust the speed according the the
     * speedShoot method
     * 
     * @return
     */
//    private void adjustShooterWithEncoder(double discretePower, double wantRPM)
//    {
//        double nowRPM = this.getRPM();
//        double ratioRPM = wantRPM / nowRPM;
//        double changePower = discretePower * ratioRPM;
//        changePower = trim(changePower, 0, 1);
//        this._shooterWheel.set(changePower);
        //SmartDashboard.putNumber("Shooter Wheel speed :", discretePower);
//    }

    private double trim(double n, double min, double max)
    {
        double t = n;
        if (n < min)
        {
            t = min + 0.0001;
        } else if (n > max)
        {
            t = max - 0.0001;
        }
        return t;
    }
}
