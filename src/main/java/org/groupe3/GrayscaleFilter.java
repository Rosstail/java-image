package org.groupe3;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;
import org.opencv.core.CvType;
import org.opencv.imgproc.Imgproc;

import java.io.File;

import static org.bytedeco.opencv.global.opencv_imgproc.cvtColor;

public class GrayscaleFilter {
    FilterLog filterlog = new FilterLog();

    public void FileToGrayscale(int i, String dir) {
        File f = new File(dir);
        Mat image = opencv_imgcodecs.imread(f.getAbsolutePath());
        image = filterGrayscale(image);

        File outputDir = new File("imgs_result");
        File outputFile = new File(outputDir, "grayscale-result"+i+".jpg");
        opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);
        filterlog.logToFile("Grayscale filter apply on "+ dir);
    }

    public Mat filterGrayscale(Mat image) {
        Mat result = new Mat(image.rows(), image.cols(), CvType.CV_8UC3);
        cvtColor(image, result, Imgproc.COLOR_RGB2GRAY);
        return result;
    }
}
