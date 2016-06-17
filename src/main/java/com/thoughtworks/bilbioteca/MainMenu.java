package com.thoughtworks.bilbioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class MainMenu {

    private PrintStream printStream;
    private BufferedReader bufferReader;
    private Library library;
    private Map<String, Command> menuCommands;




    public MainMenu(PrintStream printStream, BufferedReader bufferReader, Library library, Map<String, Command> menuCommands){
        this.printStream = printStream;
        this.bufferReader = bufferReader;
        this.library = library;
        this.menuCommands = menuCommands;
    }
    public void showMainMenu() {
        printStream.println("1. List Books");
        printStream.println("\nPlease enter the number for the corresponding option you want:");
    }

    public void figureOutWhatMenuItemToSelect() {
        boolean isRunning = true;

        while (isRunning) {
            String userInput = readLine();

            //

            if(userInput.equals("1")) {
                library.listBooksWithDetails();
            }
            else if(userInput.equals("2")) {
                isRunning = false;
            } else {
                printStream.println("Select a valid option!");
            }
        }
    }

    private String readLine() {
        try {
            return bufferReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}