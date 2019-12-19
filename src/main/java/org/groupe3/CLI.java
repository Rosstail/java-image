package org.groupe3;

import org.apache.commons.cli.*;

import java.io.IOException;

/**
 * Class that take arguments
 */
public class CLI {
    String in;
    String out;
    String filter;
    FolderFileList folderFileList = new FolderFileList();

    /**
     * Method that take arguments
     * @param args
     * @throws ParseException
     * @throws IOException
     * @throws FilterException
     */
    public void CLI(String[] args) throws ParseException, IOException, FilterException {
        Options options = new Options();
        options.addOption("i", "input-dir", true, "input dir containing images");
        options.addOption("o", "output-dir", true, "output dir containing images with filter");
        options.addOption("f", "filter", true, "select filter to apply");
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);
        if (cmd.hasOption("i")){
            String inputDirArg = cmd.getOptionValue("i");
            System.out.println("input-dir = "+inputDirArg);
            in = inputDirArg;
        }
        if (cmd.hasOption("o")) {
            String outputDirArg = cmd.getOptionValue("o");
            System.out.println("output-dir = "+outputDirArg);
            out = outputDirArg;
        }
        if (cmd.hasOption("f")){
            String inputfilter = cmd.getOptionValue("f");
            System.out.println("filter = "+inputfilter);
            filter = inputfilter;
        }
        System.out.println("");
        folderFileList.Test(in, out, filter);
    }
}
