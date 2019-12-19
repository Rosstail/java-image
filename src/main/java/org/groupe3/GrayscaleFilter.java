package org.groupe3;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;
import org.opencv.core.CvType;
import org.opencv.imgproc.Imgproc;

import java.io.File;

import static org.bytedeco.opencv.global.opencv_imgproc.cvtColor;

/**
 * Class that apply grayscale filter
 */
public class GrayscaleFilter {
    FilterLog filterlog = new FilterLog();

    /**
     * Method that select the image for apply the grayscale filter
     * @param i
     * @param dir
     * @param out
     */
    public void FileToGrayscale(int i, String dir, String out) {
        File f = new File(dir);
        Mat image = opencv_imgcodecs.imread(f.getAbsolutePath());
        image = filterGrayscale(image);

        File outputDir = new File(out);
        File outputFile = new File(outputDir, "grayscale-result"+i+".jpg");
        opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);
        filterlog.logToFile("Grayscale filter apply on "+ dir);
    }

    /**
     * Method that apply a grayscale filter
     * @param image
     * @return
     */
    public Mat filterGrayscale(Mat image) {
        Mat result = new Mat(image.rows(), image.cols(), CvType.CV_8UC3);
        cvtColor(image, result, Imgproc.COLOR_RGB2GRAY);
        return result;
    }
}
