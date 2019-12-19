package org.groupe3;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;
import org.opencv.imgproc.Imgproc;
import java.io.File;
import static org.bytedeco.opencv.global.opencv_imgproc.*;

public class DilateFilter{
    FilterLog filterlog = new FilterLog();

    public void FileToDilate(int i, String dir) {
        File f = new File(dir);
        Mat image = opencv_imgcodecs.imread(f.getAbsolutePath());
        image = filterDilate(image);

        File outputDir = new File("imgs_result");
        File outputFile = new File(outputDir, "dilate-result"+i+".jpg");
        opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);
        //filterlog.logToFile("Dilate filter apply on "+ dir);
    }

    public Mat filterDilate(Mat image) {
        int size = 20;
        Mat result = image.clone();
        Mat element = getStructuringElement(Imgproc.MORPH_RECT, new Size(2 * size + 1, 2 * size + 1));
        dilate(image, result, element);
        return result;
    }
}