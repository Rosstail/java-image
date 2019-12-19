package org.groupe3;

import org.apache.commons.cli.ParseException;

import java.io.IOException;

public class App {
    static CLI cli = new CLI();

    public static void main(String[] args) throws FilterException, IOException, ParseException {
        cli.CLI(args);
    }
}
