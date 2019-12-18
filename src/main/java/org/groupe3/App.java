package org.groupe3;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        DilateFilter dilateFilter = new DilateFilter();
        BlurFilter blurFilter = new BlurFilter();
        GrayscaleFilter grayscaleFilter = new GrayscaleFilter();
        dilateFilter.FileToDilate();
        blurFilter.FileToBlur();
        grayscaleFilter.FileToGrayscale();
        FolderFileList.Test();
    }
}
