package com.thoughtworks.bilbioteca;

import java.io.PrintStream;

public class Application {
    private PrintStream printStream;
    private MainMenu mainMenu;

    public Application(PrintStream printStream, MainMenu mainMenu){
        this.printStream = printStream;
        this.mainMenu = mainMenu;
    }
    public void start() {
        printStream.println("Welcome");
        mainMenu.showMainMenu();
        mainMenu.figureOutWhatMenuItemToSelect();
        //printStream.println("Quitting Application");
    }
}
