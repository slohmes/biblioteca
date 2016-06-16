package com.thoughtworks.bilbioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookTest {

    private PrintStream printStream;
    private Book fellowshipOfTheRings;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        fellowshipOfTheRings = new Book("Fellowship of the Rings", "Tolkien", 1927, printStream);
    }


    @Test
    public void shouldPrintBookDetailsWhenCalled() {
        fellowshipOfTheRings.printBookDetails();
        verify(printStream).println("Fellowship of the Rings\t"+ "Tolkien\t" + 1927);
    }

}