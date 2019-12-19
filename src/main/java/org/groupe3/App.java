package org.groupe3;

import java.io.IOException;

public class App {
    static FolderFileList folderFileList = new FolderFileList();
    static String filter;

    public static void main(String[] args) throws FilterException, IOException {
        filter = "blur";
        folderFileList.Test(filter);
        folderFileList.dumpLog();
    }
}
