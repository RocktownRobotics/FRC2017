package org.usfirst.frc.team3274.robot.visionprocessing;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CameraProcessor extends IterativeRobot
{
    public void init()
    {
        startImageCapture();
    }

    private void startImageCapture()
    {
        new Thread(() -> {
            UsbCamera camera = CameraServer.getInstance()
                    .startAutomaticCapture();
            camera.setResolution(640, 480);

            CvSink cvSink = CameraServer.getInstance().getVideo();
            CvSource outputStream = CameraServer.getInstance().putVideo("Blur",
                    640, 480);

            // get matrices
            Mat source = new Mat();
            Mat output = new Mat();

            // get frames and put in output stream
            while (!Thread.interrupted())
            {
                cvSink.grabFrame(source);
                Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2RGB);
                outputStream.putFrame(output);
            }
        }).start();
    }
    
    
}