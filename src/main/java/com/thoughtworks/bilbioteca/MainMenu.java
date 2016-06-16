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
    }

    public void selectMenuItemOne(){
        library.listBooksWithDetails();
    }

    public void figureOutWhatMenuItemToSelect() {
        printStream.println("Please enter the number for the corresponding option you want.");
        int userInput = getUserInput();
        if(userInput == 1) {
            selectMenuItemOne();
        }
    }

    private int getUserInput() {
        int userInput = parseInt(readLine());
        return userInput;
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
