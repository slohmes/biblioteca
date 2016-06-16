package com.thoughtworks.bilbioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainMenuTest {

    private PrintStream printStream;
    private MainMenu mainMenu;
    private BufferedReader bufferReader;
    private Library library;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        bufferReader = mock(BufferedReader.class);
        library = mock(Library.class);
        mainMenu = new MainMenu(printStream, bufferReader, library);
    }
    @Test
    public void shouldDisplayMenuOptionsWhenShowMainMenuIsCalled() {
        mainMenu.showMainMenu();
        verify(printStream).println("1. List Books");
    }


    @Test
    public void shouldCallSelectMenuItemOneWhenUserEnterOne() throws IOException {
        when(bufferReader.readLine()).thenReturn("1");
        mainMenu.figureOutWhatMenuItemToSelect();
        verify(library).listBooksWithDetails();
    }


}