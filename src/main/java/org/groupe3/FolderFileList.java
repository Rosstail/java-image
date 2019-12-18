package org.groupe3;


import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class FolderFileList {

    public static void Test() throws IOException {

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
            }
            System.out.println(file.getCanonicalPath());
        }

    }

}
