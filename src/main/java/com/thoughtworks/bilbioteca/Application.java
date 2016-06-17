package com.thoughtworks.bilbioteca;

import java.io.PrintStream;
import java.util.Map;

public class Application {
    private PrintStream printStream;
    private MainMenu mainMenu;
    private boolean programIsRunning;
    private Map<String, Command> menuCommands;

    public Application(PrintStream printStream, MainMenu mainMenu, Map<String, Command> menuCommands){
        this.printStream = printStream;
        this.mainMenu = mainMenu;
        this.programIsRunning = false;
        this.menuCommands = menuCommands;
    }
    public void start() {
        printStream.println("Welcome");


        mainMenu.showMainMenu();

        programIsRunning = true;


        String input = mainMenu.getUserInput();
        while (!input.equals("2")) {
            if (menuCommands.containsKey(input)) {
                menuCommands.get(input).executeSelection();
            }
            else {
                printStream.println("Select a valid option!");
            }
            input = mainMenu.getUserInput();
        }



    }
}
