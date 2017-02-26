package org.usfirst.frc.team3274.robot.visionprocessing;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

/**
 * Uses image-processing techniques to find a box of reflective tape in an
 * image.
 * 
 * @author Dell-Laptop-FLL
 *
 */
public class TapeFinder
{
    public static final byte MINIMUM_LUMINOSITY = 113;

    /**
     * Converts given matrix to grayscale and then preserve all values that are
     * above a certain luminosity. Everything else is changed to black and
     * returned in a new matrix.
     * 
     * @param orig image to edit
     * @return a grayscale version of original image after values below a certain luminosity have
     *         been set to black
     */
    public Mat applyMask(Mat orig)
    {
        Mat newMat = new Mat();
        Mat grey = new Mat();

        Imgproc.cvtColor(orig, grey, Imgproc.COLOR_BGR2GRAY);

        int matSize = (int) (grey.total() * grey.channels());

        // an array is used in order to minimize the number of calls to Mat.get
        // and Mat.put; both of these methods are VERY slow
        byte[] matArray = new byte[matSize];
        
        grey.get(0, 0, matArray);
        for (int i = 0; i < matSize; i++)
        {
            if (matArray[i] < MINIMUM_LUMINOSITY)
            {
                matArray[i] = 0;
            }
        }
        newMat.put(0, 0, matArray);

        return newMat;
    }
    
    
}
