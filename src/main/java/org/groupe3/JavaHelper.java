package org.groupe3;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;
import org.opencv.core.CvType;
import org.opencv.imgproc.Imgproc;

import java.io.File;

import static org.bytedeco.opencv.global.opencv_imgproc.*;

public class JavaHelper {

    public void exempleBlurFile() {
        File f = new File("/Users/escias/Desktop/java-image/imgs");
        Mat image = opencv_imgcodecs.imread(f.getAbsolutePath());
        image = filterBlur(image);

        File outputDir = new File("/Users/escias/Desktop/java-image/imgresult");
        File outputFile = new File(outputDir, "resultBlur.jpg");
        opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);
    }

    public Mat filterBlur(Mat image) {
        int size = 3;
        Mat result = image.clone();
        GaussianBlur(image, result, new Size(size, size), 0);
        return result;
    }

    public void filDilate() {
        File f = new File("/Users/escias/Desktop/java-image/imgs");
        Mat image = opencv_imgcodecs.imread(f.getAbsolutePath());
        image = filterDilate(image);

        File outputDir = new File("/Users/escias/Desktop/java-image/imgresult");
        File outputFile = new File(outputDir, "resultDilate.jpg");
        opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);
    }

    public Mat filterDilate(Mat image) {
        int size = 8;
        Mat result = image.clone();
        Mat element = getStructuringElement(Imgproc.MORPH_RECT, new Size(2 * size + 1, 2 * size + 1));
        dilate(image, result, element);
        return result;
    }

    public void filGrayScale() {
        File f = new File("/Users/escias/Desktop/java-image/imgs");
        Mat image = opencv_imgcodecs.imread(f.getAbsolutePath());
        image = filterGrayscale(image);

        File outputDir = new File("/Users/escias/Desktop/java-image/imgresult");
        File outputFile = new File(outputDir, "resultGrayscale.jpg");
        opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);
    }

    public Mat filterGrayscale(Mat image) {
        Mat result = new Mat(image.rows(), image.cols(), CvType.CV_8UC3);
        cvtColor(image, result, Imgproc.COLOR_RGB2GRAY);
        return result;
    }
}