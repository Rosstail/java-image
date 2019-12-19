package org.groupe3;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;

import java.io.File;

import static org.bytedeco.opencv.global.opencv_imgproc.*;

public class BlurFilter {

    public void FileToBlur(int i, String dir) throws FilterException {
        File f = new File(dir);
        Mat image = opencv_imgcodecs.imread(f.getAbsolutePath());
        image = filterBlur(image);

        File outputDir = new File("imgs_result");
        File outputFile = new File(outputDir, "blur-result"+i+".jpg");
        opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);
    }

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
