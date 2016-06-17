package com.thoughtworks.bilbioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class MainMenuTest {

    private PrintStream printStream;
    private MainMenu mainMenu;
    private BufferedReader bufferReader;
    private Library library;
    private Map<String, Command> menuCommands = new HashMap<>();

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        bufferReader = mock(BufferedReader.class);
        library = mock(Library.class);
        mainMenu = new MainMenu(printStream, bufferReader, library, menuCommands);
    }
    @Test
    public void shouldDisplayMenuOptionsWhenShowMainMenuIsCalled() {
        mainMenu.showMainMenu();
        verify(printStream).println("1. List Books");
    }

    @Test
    public void shouldCallSelectMenuItemOneWhenUserEnterOne() throws IOException {
        when(bufferReader.readLine()).thenReturn("1", "2");
        mainMenu.figureOutWhatMenuItemToSelect();
        verify(menuCommands).get("1").executeSelection();
    }

    @Test
    public void shouldPromptForValidInputWhenUserEntersAnInvalidInteger() throws IOException {
        when(bufferReader.readLine()).thenReturn("0", "2");
        mainMenu.figureOutWhatMenuItemToSelect();
        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldPromptForValidInputWhenUserEntersANoninteger() throws IOException {
        when(bufferReader.readLine()).thenReturn("BAD INPUT", "2");
        mainMenu.figureOutWhatMenuItemToSelect();
        verify(printStream).println("Select a valid option!");

    }
    
    @Test
    public void shouldQuitWhenUserSelectsQuit() throws IOException {
        when(bufferReader.readLine()).thenReturn("2");

        mainMenu.figureOutWhatMenuItemToSelect();

        verifyZeroInteractions(menuCommands.get("1"));
    }

}