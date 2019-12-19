package org.groupe3;

import org.apache.commons.cli.ParseException;

import java.io.IOException;

/**
 * Class that is launched when we execute the code
 */
public class App {
    static CLI cli = new CLI();
    static FolderFileList folderFileList = new FolderFileList();

    /**
     * Method that is launch when we execute the code
     * @param args
     * @throws FilterException
     * @throws IOException
     * @throws ParseException
     */
    public static void main(String[] args) throws FilterException, IOException, ParseException {
        cli.CLI(args);
        folderFileList.dumpLog();
    }
}
