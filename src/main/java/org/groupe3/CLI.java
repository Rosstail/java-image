package org.groupe3;

import org.apache.commons.cli.*;

import java.io.IOException;

public class CLI {
    String in;
    String out;
    String filter;
    FolderFileList folderFileList = new FolderFileList();

    public void CLI(String[] args) throws ParseException, IOException, FilterException {
        Options options = new Options();
        options.addOption("i", "input-dir", true, "input dir containing images");
        options.addOption("o", "output-dir", true, "output dir containing images with filter");
        options.addOption("f", "filterr", true, "select filter to apply");
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);
        if (cmd.hasOption("i")){
            String inputDirArg = cmd.getOptionValue("i");
            System.out.println(inputDirArg);
            in = inputDirArg;
        }
        if (cmd.hasOption("o")) {
            String outputDirArg = cmd.getOptionValue("o");
            System.out.println(outputDirArg);
            out = outputDirArg;
        }
        if (cmd.hasOption("f")){
            String inputfilter = cmd.getOptionValue("f");
            System.out.println(inputfilter);
            filter = inputfilter;
        }
        folderFileList.Test(in, out, filter);
    }
}