package com.thoughtworks.bilbioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        PrintStream printStream = System.out;
        Book theHobbit = new Book("The Hobbit", "Tolkien" , 1930, printStream);
        Book theDay = new Book("The Day", "Joe", 2016 , printStream);
        Collection<Book> books = new ArrayList<>();

        books.add(theHobbit);
        books.add(theDay);
        Library library = new Library(books);
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Command> menuCommands = new HashMap<>();
        menuCommands.put("1", new ListBooksCommand(library));


        MainMenu mainMenu = new MainMenu(printStream, bufferReader, library, menuCommands);
        new Application(printStream, mainMenu).start();
    }
}
