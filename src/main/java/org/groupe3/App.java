package org.groupe3;

import java.io.IOException;

public class App {
    static DilateFilter dilateFilter = new DilateFilter();
    static BlurFilter blurFilter = new BlurFilter();
    static GrayscaleFilter grayscaleFilter = new GrayscaleFilter();
    static FolderFileList folderFileList = new FolderFileList();

    public static void main(String[] args) throws FilterException, IOException {
        folderFileList.Test();
    }
}
