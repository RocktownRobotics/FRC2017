package org.usfirst.frc.team3274.robot.visionprocessing;

import java.awt.Color;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.opencv.imgcodecs.Imgcodecs;

public class CameraProcessor extends IterativeRobot
{
   /*  camera input 
    private Mat source = new Mat();
     camera output 
    private Mat output = new Mat();*/

    private CvSource outputStream;
    private CvSink cvSink;

    private UsbCamera camera;

    /* size of camera picture */
    private int frameWidth = 640;
    private int frameHeight = 480;

    /* width */
    int xVar = 50;
    /* height */
    int yVar = 20;

    int startX = 320 - xVar;
    int startY = 240 - yVar;
    int endX = 320 + xVar;
    int endY = 240 + yVar;

    Point point1 = new Point(startX, startY);
    Point point2 = new Point(endX, startY);
    Point point3 = new Point(endX, endY);
    Point point4 = new Point(startX, endY);

    /* green */
    Scalar boxColor = new Scalar(0, 0, 0);
    //Color newColor = new Color(0,0,0);
    int thickness = 5;

    public void init()
    {
        startImageCapture();
    }

  /*  public void drawRectangle()
    {
        //System.out.println("draw rect");
         draw rectangle on output image 
        Imgproc.line(output, point1, point2, boxColor, thickness);
        Imgproc.line(output, point2, point3, boxColor, thickness);
        Imgproc.line(output, point3, point4, botxColor, thickness);
        Imgproc.line(output, point4, point1, boxColor, thickness);
        
        
        //Imgproc.rectangle(output, point1, point3, boxColor, thickness);
    }
*/
    private void startImageCapture()
    {
        new Thread(() -> {
            /* start recording */
            camera = CameraServer.getInstance().startAutomaticCapture();

            /* set resolution to standard definition */
            camera.setResolution(frameWidth, frameHeight);

            /* camera input */
            Mat source = new Mat();
            /* camera output */
            Mat output = new Mat();
            
            /* vision processing stuff */
            cvSink = CameraServer.getInstance().getVideo();
            /* putting the camera output into memory to analyze */
            outputStream = CameraServer.getInstance().putVideo("Blur",
                    frameWidth, frameHeight);

            // get frames and put in output stream
            while (!Thread.interrupted())
            {
                /* get the current picture, write it to source */
                cvSink.grabFrame(source);
                /* copy source image to output image */
                // drawRectangle();
                // Imgcodecs.imwrite("test2.jpg", output);

                Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2RGB);

                /* draw rectangle on output image */
                Imgproc.line(output, point1, point2, boxColor, thickness);
                Imgproc.line(output, point2, point3, boxColor, thickness);
                Imgproc.line(output, point3, point4, boxColor, thickness);
                Imgproc.line(output, point4, point1, boxColor, thickness);
                
                /* send to smart dashboard */
                outputStream.putFrame(output);
            }
        }).start();
    }
}