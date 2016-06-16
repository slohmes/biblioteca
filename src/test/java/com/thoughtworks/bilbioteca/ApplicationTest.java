package com.thoughtworks.bilbioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ApplicationTest {
    private PrintStream printStream;
    private Application application;
    private MainMenu mainMenu;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        mainMenu = mock(MainMenu.class);
        application = new Application(printStream, mainMenu);
    }


    @Test
    public void shouldWelcomeUserWhenStarting()  {
        application.start();
        verify(printStream).println(contains("Welcome"));
    }


    @Test
    public void shouldDisplayMainMenuWhenStart() {
        application.start();
        verify(mainMenu).showMainMenu();
    }

    @Test
    public void shouldAskForUserInputWhenMainMenuEnded()  {
        application.start();
        verify(mainMenu).figureOutWhatMenuItemToSelect();

    }
}