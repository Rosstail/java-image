package org.groupe3;


import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class FolderFileList {
    static BlurFilter blurFilter = new BlurFilter();
    static DilateFilter dilateFilter = new DilateFilter();
    static GrayscaleFilter grayscaleFilter = new GrayscaleFilter();
    private static int i;

    public static void Test() throws IOException, FilterException {

        File f = new File("imgs");

        FilenameFilter textFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".jpg");
            }
        };

        File[] files = f.listFiles(textFilter);
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("directory:");
            } else {
                System.out.println("     file:");
                String dir = file.getPath();
                blurFilter.FileToBlur(i, dir);
                dilateFilter.FileToDilate(i, dir);
                grayscaleFilter.FileToGrayscale(i, dir);
            }
            System.out.println(file.getCanonicalPath());
            i++;
        }
    }
}
