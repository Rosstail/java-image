package org.groupe3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class that modify file imagefilter.log
 */
public class FilterLog{

    /**
     * Method that modify file imagefilter.log
     * @param message
     */
    void logToFile(String message) {
        try {
            FileWriter fw = new FileWriter("imagefilter.log", true);
            fw.write(message + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Cannot open imagefilter.log. message=" + e.getMessage());
        }
    }

    /**
     *
     */
    public void dumpLog() {
        File file = new File("imagefilter.log");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that delete/reset the file
     * @throws IOException
     */
    public void FileDelete() throws IOException {
        FileWriter fw = new FileWriter("imagefilter.log", false);
    }
}
