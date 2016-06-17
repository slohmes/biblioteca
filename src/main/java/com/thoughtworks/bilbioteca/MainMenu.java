package com.thoughtworks.bilbioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class MainMenu {

    private PrintStream printStream;
    private BufferedReader bufferReader;

    public MainMenu(PrintStream printStream, BufferedReader bufferReader){
        this.printStream = printStream;
        this.bufferReader = bufferReader;
    }

    public void showMainMenu() {
        printStream.println("1. List Books");
        printStream.println("\nPlease enter the number for the corresponding option you want:");
    }

    public String getUserInput() {
        try {
            return bufferReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}