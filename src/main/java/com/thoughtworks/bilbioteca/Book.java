package com.thoughtworks.bilbioteca;

import java.io.PrintStream;

public class Book {
    private final String title;
    private String author;
    private int yearPublished;
    private PrintStream printStream;

    public Book(String title, String author, int yearPublished, PrintStream printStream) {

        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.printStream = printStream;
    }

    public void printBookDetails() {
        printStream.println(title + "\t" + author + "\t" + yearPublished);
    }
}
