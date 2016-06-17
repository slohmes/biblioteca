package com.thoughtworks.bilbioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static java.lang.Integer.parseInt;

public class MainMenu {

    private PrintStream printStream;
    private BufferedReader bufferReader;
    private Library library;

    public MainMenu(PrintStream printStream, BufferedReader bufferReader, Library library){
        this.printStream = printStream;
        this.bufferReader = bufferReader;
        this.library = library;
    }
    public void showMainMenu() {
        printStream.println("1. List Books");
        printStream.println("\nPlease enter the number for the corresponding option you want:");
    }

//    public void selectMenuItemOne(){
//        library.listBooksWithDetails();
//    }

    public void figureOutWhatMenuItemToSelect() {
        String  userInput = readLine();

        while (!userInput.equals("1")) {
            printStream.println("Select a valid option!");
            userInput = readLine();

        }
        library.listBooksWithDetails();

    }

    private String readLine() {
        try {
            return bufferReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void start(){
        showMainMenu();
        figureOutWhatMenuItemToSelect();
    }
}
