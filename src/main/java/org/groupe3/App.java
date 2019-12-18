package org.groupe3;

public class App {
    static DilateFilter dilateFilter = new DilateFilter();
    static BlurFilter blurFilter = new BlurFilter();
    static GrayscaleFilter grayscaleFilter = new GrayscaleFilter();

    public static void main(String[] args) throws FilterException {
        dilateFilter.FileToDilate();
        blurFilter.FileToBlur();
        grayscaleFilter.FileToGrayscale();
    }
}
