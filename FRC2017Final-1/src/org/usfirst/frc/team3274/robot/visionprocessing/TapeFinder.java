package org.usfirst.frc.team3274.robot.visionprocessing;

import org.opencv.core.Mat;

/**
 * Uses image-processing techniques to find a box of reflective tape in an
 * image.
 * 
 * @author Dell-Laptop-FLL
 *
 */
public class TapeFinder
{
    
    public static final Mat getTapeMaskMatrix() {
        
        Mat mask;
        
        mask = new Mat();
        
        
        
        return mask;
    }

    /**
     * Applyies the given mask to the given image and returns the filtered
     * result.
     * 
     * @param orig image to apply mask to
     * @param mask mask to apply to image
     * @return the original image after the mask has been applied to it
     */
    public Mat applyMask(Mat orig, Mat mask)
    {
        Mat newMat = new Mat();

        orig.copyTo(orig, mask);

        return newMat;
    }
}
