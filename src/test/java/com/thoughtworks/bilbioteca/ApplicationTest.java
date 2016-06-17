package com.thoughtworks.bilbioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class ApplicationTest {
    private PrintStream printStream;
    private Application application;
    private MainMenu mainMenu;
    private Map<String, Command> menuCommands;
    private ListBooksCommand listBooksCommand;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        mainMenu = mock(MainMenu.class);

        menuCommands = new HashMap<>();
        listBooksCommand = mock(ListBooksCommand.class);
        menuCommands.put("1", listBooksCommand);

        application = new Application(printStream, mainMenu, menuCommands);
    }


    @Test
    public void shouldWelcomeUserWhenStarting()  {
        when(mainMenu.getUserInput()).thenReturn("2");
        application.start();
        verify(printStream).println(contains("Welcome"));
    }


    @Test
    public void shouldDisplayMainMenuWhenStart() {
        when(mainMenu.getUserInput()).thenReturn("2");
        application.start();
        verify(mainMenu).showMainMenu();
    }

    @Test
    public void shouldAskForUserInputWhenProgramStarts()  {
        when(mainMenu.getUserInput()).thenReturn("2");
        application.start();
        verify(mainMenu).getUserInput();
    }

    @Test
    public void shouldCallSelectMenuItemOneWhenUserEnterOne() throws IOException {
        when(mainMenu.getUserInput()).thenReturn("1", "2");
        application.start();
        verify(menuCommands.get("1")).executeSelection();
    }

    @Test
    public void shouldPromptForValidInputWhenUserEntersAnInvalidInteger() throws IOException {
        when(mainMenu.getUserInput()).thenReturn("0", "2");
        application.start();
        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldPromptForValidInputWhenUserEntersANoninteger() throws IOException {
        when(mainMenu.getUserInput()).thenReturn("BAD INPUT", "2");
        application.start();
        verify(printStream).println("Select a valid option!");

    }

    @Test
    public void shouldQuitWhenUserSelectsQuit() throws IOException {
        when(mainMenu.getUserInput()).thenReturn("2");

        application.start();

        verifyZeroInteractions(menuCommands.get("1"));
    }
}