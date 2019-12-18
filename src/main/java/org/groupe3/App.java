package org.groupe3;

public class App {
    public static void main(String[] args) {
        DilateFilter dilateFilter = new DilateFilter();
        BlurFilter blurFilter = new BlurFilter();
        GrayscaleFilter grayscaleFilter = new GrayscaleFilter();
        dilateFilter.FileToDilate();
        blurFilter.FileToBlur();
        grayscaleFilter.FileToGrayscale();
    }
}
