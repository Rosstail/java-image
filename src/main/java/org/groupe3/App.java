package org.groupe3;

import java.io.IOException;

public class App {
    static FolderFileList folderFileList = new FolderFileList();

    public static void main(String[] args) throws FilterException, IOException {
        folderFileList.Test();
        folderFileList.dumpLog();
    }
}
