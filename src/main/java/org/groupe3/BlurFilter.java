package org.groupe3;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;

import java.io.File;

import static org.bytedeco.opencv.global.opencv_imgproc.*;

/**
 * Class that apply blur filter
 */
public class BlurFilter {
    FilterLog filterlog = new FilterLog();

    /**
     * Method that select the image for apply the blur filter
     * @param i
     * @param dir
     * @param out
     * @throws FilterException
     */
    public void FileToBlur(int i, String dir, String out) throws FilterException {
        File f = new File(dir);
        Mat image = opencv_imgcodecs.imread(f.getAbsolutePath());
        image = filterBlur(image);

        File outputDir = new File(out);
        File outputFile = new File(outputDir, "blur-result"+i+".jpg");
        opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);
        filterlog.logToFile("Blur filter apply on "+ dir);
    }

    /**
     * Method that apply a blur filter
     * @param image
     * @return
     * @throws FilterException
     */
    public Mat filterBlur(Mat image) throws FilterException {
        int size = 201;
        Mat result = image.clone();
        GaussianBlur(image, result, new Size(size, size), 0);
        if (size % 2 == 0){
            throw new FilterException("Cannot apply blur filter");
        }
        return result;
    }
}
