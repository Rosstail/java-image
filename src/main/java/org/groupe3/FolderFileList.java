package org.groupe3;


import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class FolderFileList {
    static FilterLog filterlog = new FilterLog();
    static BlurFilter blurFilter = new BlurFilter();
    static DilateFilter dilateFilter = new DilateFilter();
    static GrayscaleFilter grayscaleFilter = new GrayscaleFilter();
    private static int i;
    private static String dir;

    public static void Test(String in, String out, String filter) throws IOException, FilterException {

        File f = new File("imgs");
        filterlog.FileDelete();

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
                dir = file.getPath();
                switch (filter){
                    case "blur":
                        blurFilter.FileToBlur(i, dir, out);
                        break;
                    case "dilate":
                        dilateFilter.FileToDilate(i, dir, out);
                        break;
                    case "grayscale":
                        grayscaleFilter.FileToGrayscale(i, dir, out);
                        break;
                }
            }
            System.out.println(file.getCanonicalPath());
            i++;
        }
    }

    public void dumpLog() {
        filterlog.dumpLog();
    }
}
